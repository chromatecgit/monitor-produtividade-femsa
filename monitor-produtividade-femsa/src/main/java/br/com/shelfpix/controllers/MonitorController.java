package br.com.shelfpix.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.shelfpix.dao.MetaViewDAO;
import br.com.shelfpix.model.Detalhe;
import br.com.shelfpix.model.Meta;
import br.com.shelfpix.model.Pesquisador;
import br.com.shelfpix.model.ProgressoDiarioFoto;
import br.com.shelfpix.model.ProgressoDiarioMeta;
import br.com.shelfpix.model.ProgressoDiarioPreco;
import br.com.shelfpix.model.ProgressoDiarioQuestionario;
import br.com.shelfpix.model.Supervisor;
import br.com.shelfpix.model.dto.MetaViewDTO;
import br.com.shelfpix.util.CalculadorCommons;
import br.com.shelfpix.util.CalculadorFoto;
import br.com.shelfpix.util.CalculadorMeta;
import br.com.shelfpix.util.CalculadorPreco;
import br.com.shelfpix.util.CalculadorQuestionario;
import br.com.shelfpix.util.Chronometer;
import br.com.shelfpix.util.Parser;

//TODO: Remover o Hibernate, usar o JDBC direto para chamar a Procedure
@RestController
public class MonitorController {
	
	@Autowired
	MetaViewDAO metaViewDAO;
	@Autowired
	CalculadorCommons calculador;
	@Autowired
	CalculadorMeta calculadorMeta;
	@Autowired
	CalculadorFoto calculadorFoto;
	@Autowired
	CalculadorPreco calculadorPreco;
	@Autowired
	CalculadorQuestionario calculadorQuestionario;
	
	@CrossOrigin
	@RequestMapping("/monitor")
	public Supervisor obterDados(@RequestParam(name="pais", required=false, defaultValue="Brazil") final String pais,
								@RequestParam(name="estado", required=false) final String estado,
								@RequestParam(name="mes", required=false) final Integer mes,
								@RequestParam(name="ano", required=false, defaultValue="2017") final Integer ano) {
		
		System.out.println("INICIO - MONITOR");
		
		Chronometer.start();
		List<MetaViewDTO> listMetaDTO = null;
		listMetaDTO = metaViewDAO.findAll();
		Chronometer.stop();
		Chronometer.getTime("MetaViewDAO - findAll");
		
		Chronometer.start();
		Supervisor supervisor = new Supervisor();
		supervisor.setNome("Supervisor-MS");
		List<Pesquisador> pesquisadores = converterParaPesquisadores(listMetaDTO);
		supervisor.setPesquisadores(pesquisadores);
		Chronometer.stop();
		Chronometer.getTime("MonitorController - converterParaPesquisadores");
		
		Chronometer.start();
		//============ META
		supervisor.setMeta(
				calculadorMeta.criarMetaSupervisor(supervisor.getPesquisadores()));
		supervisor.getMeta().setListaProgressoMeta(
				calculadorMeta.calcularProgressoMetaSupervisor(pesquisadores));
		supervisor.getMeta().setAcumulado(
				calculadorMeta.calcularAcumulado(supervisor.getMeta().getListaProgressoMeta()));
		//FIXME: Tirar essa repeticao e melhorar essa logica
		supervisor.getMeta().setPerformance( 
				calculadorMeta.calcularPerformance(supervisor.getMeta()));
		supervisor.getMeta().setProjecao(
				calculadorMeta.calcularProjecao(supervisor.getMeta()));
		Chronometer.stop();
		Chronometer.getTime("MetaViewDAO - META");
		
		Chronometer.start();
		//============ DETALHE
		//FOTO
		supervisor.getDetalhe().setListaProgressoFoto(
				calculadorFoto.calcularProgressoFotoSupervisor(pesquisadores));
		supervisor.getDetalhe().setAcumuladoFoto(
				calculadorFoto.calcularAcumulado(supervisor.getDetalhe().getListaProgressoFoto()));
		supervisor.getDetalhe().setPerformanceFoto(
				calculadorFoto.calcularPerformance(supervisor.getDetalhe().getAcumuladoFoto()));
		//PRECO
		supervisor.getDetalhe().setListaProgressoPreco(
				calculadorPreco.calcularProgressoPrecoSupervisor(pesquisadores));
		supervisor.getDetalhe().setAcumuladoPreco(
				calculadorPreco.calcularAcumulado(supervisor.getDetalhe().getListaProgressoPreco()));
		supervisor.getDetalhe().setPerformancePreco(
				calculadorPreco.calcularPerformance(supervisor.getDetalhe().getAcumuladoPreco()));
		Chronometer.stop();
		Chronometer.getTime("MetaViewDAO - DETALHE");
		
		Chronometer.start();
		//QUESTIONARIO
		supervisor.getDetalhe().setListaProgressoQuestionario(
				calculadorQuestionario.calcularProgressoQuestionarioSupervisor(pesquisadores));
		supervisor.getDetalhe().setAcumuladoQuestionario(
				calculadorQuestionario.calcularAcumulado(
						supervisor.getDetalhe().getListaProgressoQuestionario()));
		supervisor.getDetalhe().setPerformanceQuestionario(
				calculadorQuestionario.calcularPerformance(
						supervisor.getDetalhe().getAcumuladoQuestionario()));
		Chronometer.stop();
		Chronometer.getTime("MetaViewDAO - QUESTIONARIO");
		
		System.out.println(supervisor);
		
		return supervisor;
	}
	
	private ArrayList<Pesquisador> converterParaPesquisadores(final List<MetaViewDTO> listMetaDTO) {
		ArrayList<Pesquisador> pesquisadores = new ArrayList<>();
		Pesquisador pesquisador = null;
		Meta metaPesquisador = null;
		ArrayList<ProgressoDiarioMeta> progressosDiariosMeta = null;
		ArrayList<ProgressoDiarioFoto> progressosDiariosFoto = null;
		ArrayList<ProgressoDiarioPreco> progressosDiariosPreco = null;
		ArrayList<ProgressoDiarioQuestionario> progressosDiariosQuestionario = null;
		
		for (Integer id : this.filtrarIDs(listMetaDTO)) {
			for (MetaViewDTO metaDTO : listMetaDTO) {
				if (id.equals(metaDTO.getIdPesquisador())) {
					if (pesquisador == null) {
						pesquisador = new Pesquisador();
						pesquisador.setNome(metaDTO.getNome());
						pesquisador.setSobrenome(metaDTO.getSobrenome());
						pesquisador.setId(metaDTO.getIdPesquisador());
						// META FIXA
						metaPesquisador = new Meta();
						metaPesquisador.setTotalLojasVisitar(metaDTO.getTotalLojasVisitar());
						metaPesquisador.setTotalDiasUteis(calculador.encontrarDiasUteis());
						metaPesquisador.setHorasTrabalhadasDia(metaDTO.getHorasTrabalhadasDia());
						metaPesquisador.setTotalHorasTrabalho(
								metaPesquisador.getHorasTrabalhadasDia() * metaPesquisador.getTotalDiasUteis());
						metaPesquisador
								.setMediaLojasDia(calculador.dividir(
										metaPesquisador.getTotalLojasVisitar(), metaPesquisador.getTotalDiasUteis()));
						metaPesquisador.setVelocidadeMediaVisitas(calculador.dividir(
								metaPesquisador.getTotalLojasVisitar(), metaPesquisador.getTotalHorasTrabalho()));
	
						pesquisador.setMeta(metaPesquisador);
						
						pesquisador.setDetalhe(new Detalhe());
						progressosDiariosMeta = new ArrayList<>();
						progressosDiariosFoto = new ArrayList<>();
						progressosDiariosPreco = new ArrayList<>();
						progressosDiariosQuestionario = new ArrayList<>();
					}
					
					ProgressoDiarioMeta progressoMeta = new ProgressoDiarioMeta();
					progressoMeta.setDia(metaDTO.getDataVisita().getDayOfMonth());
					progressoMeta.setDataDeRegistro(metaDTO.getDataVisita());
					progressoMeta.setQntdDiasUteis(metaDTO.getFlagDiaUtil() ? 1 : 0);
					
					ProgressoDiarioFoto progressoFoto = new ProgressoDiarioFoto();
					progressoFoto.setDia(metaDTO.getDataVisita().getDayOfMonth());
					progressoFoto.setPublicadas(metaDTO.getFotosPublicadas());
					progressoFoto.setOcorrencia(metaDTO.getFotosOcorrencia());
					progressoFoto.setRecebidas(
							metaDTO.getFotosPublicadas() 
							+ metaDTO.getFotosOcorrencia() 
							+ metaDTO.getFotosEvidencia());
					// Nao existira ainda
					// progressoFoto.setTiradas
					progressoFoto.setEvidencia(metaDTO.getFotosEvidencia());
					
					ProgressoDiarioPreco progressoPreco = new ProgressoDiarioPreco();
					progressoPreco.setDia(metaDTO.getDataVisita().getDayOfMonth());
					progressoPreco.setPublicados(metaDTO.getPrecosPublicados());
					
					ProgressoDiarioQuestionario progressoQuestionario = new ProgressoDiarioQuestionario();
					
					progressoMeta.setQntdHorasTrabalho(Parser.parseLocalTime(metaDTO.getHorasTrabalhadas()));
					progressoMeta.setQntdOcorrencias(metaDTO.getNumeroLojasRecusadas());
					progressoMeta.setQntdLojasVisitadas(metaDTO.getNumeroLojasVisitadas());
					progressoMeta.setVelocidadeMedia(calculador.dividir(
							progressoMeta.getQntdLojasVisitadas(), progressoMeta.getQntdHorasTrabalho()));
					
					progressosDiariosMeta.add(progressoMeta);
					progressosDiariosFoto.add(progressoFoto);
					progressosDiariosPreco.add(progressoPreco);
					progressosDiariosQuestionario.add(progressoQuestionario);
					
				}
			}
			System.out.println("Pesquisador adicionado: " + pesquisador.getNome());
			pesquisador.getMeta().setListaProgressoMeta(progressosDiariosMeta);
			pesquisador.getDetalhe().setListaProgressoFoto(progressosDiariosFoto);
			pesquisador.getDetalhe().setListaProgressoPreco(progressosDiariosPreco);
			pesquisador.getDetalhe().setListaProgressoQuestionario(progressosDiariosQuestionario);
			pesquisador.getMeta().setAcumulado(calculadorMeta.calcularAcumulado(progressosDiariosMeta));
			//META
			pesquisador.getMeta().setPerformance(calculadorMeta.calcularPerformance(
					pesquisador.getMeta()));
			pesquisador.getMeta().setProjecao(calculadorMeta.calcularProjecao(
					pesquisador.getMeta()));
			//DETAIL FOTO
			pesquisador.getDetalhe().setAcumuladoFoto(calculadorFoto.calcularAcumulado(progressosDiariosFoto));
			pesquisador.getDetalhe().setPerformanceFoto(calculadorFoto.calcularPerformance(
					pesquisador.getDetalhe().getAcumuladoFoto()));
			//DETAIL PRECO
			pesquisador.getDetalhe().setAcumuladoPreco(calculadorPreco.calcularAcumulado(progressosDiariosPreco));
			pesquisador.getDetalhe().setPerformancePreco(calculadorPreco.calcularPerformance(
					pesquisador.getDetalhe().getAcumuladoPreco()));
			
			pesquisadores.add(pesquisador);
			pesquisador = null;
		}
		return pesquisadores;
	}
	
	private List<Integer> filtrarIDs(List<MetaViewDTO> listMetaDTO) {
		List<Integer> idsDiferentes = new ArrayList<>();
		int idAtual = 0;
		for (MetaViewDTO meta : listMetaDTO) {
			if (idAtual != meta.getIdPesquisador()) {
				idsDiferentes.add(meta.getIdPesquisador());
				idAtual = meta.getIdPesquisador();
			}
		}
		return idsDiferentes;
	}

	
}
