package br.com.shelfpix.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.com.shelfpix.model.AcumuladoMeta;
import br.com.shelfpix.model.Meta;
import br.com.shelfpix.model.MetaSupervisor;
import br.com.shelfpix.model.PerformanceMeta;
import br.com.shelfpix.model.Pesquisador;
import br.com.shelfpix.model.ProgressoDiarioMeta;
import br.com.shelfpix.model.Projecao;

@Component
@Primary
public class CalculadorMeta extends CalculadorCommons {
	
	public Projecao calcularProjecao(final Meta meta) {
		int qntdPesquisadores = 1;
		if (meta instanceof MetaSupervisor) {
			MetaSupervisor metaSupervisor = (MetaSupervisor) meta;
			qntdPesquisadores = metaSupervisor.getQntdPesquisadores();
		}
		AcumuladoMeta acumulado = meta.getAcumulado();
		PerformanceMeta performance = meta.getPerformance();
		Projecao projecao = new Projecao();
//		projecao.setMetaAjustada(
//				performance.getVelocidadeMedia() * meta.getTotalLojasVisitar()
//			);
		projecao.setMetaAjustada(
				((meta.getTotalDiasUteis() - acumulado.getQntdDiasUteis()) 
						* meta.getHorasTrabalhadasDia() 
						* qntdPesquisadores 
						* acumulado.getVelocidadeMedia()) + acumulado.getQntdLojasVisitadas()
			);
		projecao.setProjecaoOcorrencias(
				projecao.getMetaAjustada() * performance.getQntdOcorrencias()
				);
		projecao.setAmostraProvavel(
					projecao.getMetaAjustada() - projecao.getProjecaoOcorrencias()
				);
		projecao.setAjusteHorasTrabalhadasDia(
				this.dividir(
					this.dividir(
							this.dividir(
									meta.getTotalLojasVisitar(), (1 - performance.getQntdOcorrencias())) - acumulado.getQntdLojasVisitadas(),
							(meta.getTotalDiasUteis() - performance.getQntdDiasUteis())),
					acumulado.getVelocidadeMedia()));
		
//		projecao.setQntdAdicionalLojas(this.checarValorZero(
//				this.dividir(meta.getTotalLojasVisitar(), (1 - performance.getQntdOcorrencias()) - meta.getTotalLojasVisitar())));
		projecao.setQntdAdicionalLojas(projecao.getMetaAjustada() - meta.getTotalLojasVisitar());
		return projecao;
	}

	public AcumuladoMeta calcularAcumulado(final List<ProgressoDiarioMeta> progressoMeta) {
		AcumuladoMeta acumulado = new AcumuladoMeta();
		for (ProgressoDiarioMeta progresso : progressoMeta) {
			acumulado.setDataDeRegistro(progresso.getDataDeRegistro());
			acumulado.setQntdLojasVisitadas(
					acumulado.getQntdLojasVisitadas() + progresso.getQntdLojasVisitadas());
			acumulado.setQntdOcorrencias(
					acumulado.getQntdOcorrencias() + progresso.getQntdOcorrencias());
			acumulado.setQntdDiasUteis(
					acumulado.getQntdDiasUteis() + progresso.getQntdDiasUteis());
			
			acumulado.setQntdHorasTrabalho(
					acumulado.getQntdHorasTrabalho().plus(progresso.getQntdHorasTrabalho()));
			
		}
		acumulado.setMediaLojasDia(this.dividir(
				acumulado.getQntdLojasVisitadas(), acumulado.getQntdDiasUteis()));
		acumulado.setVelocidadeMedia(this.dividir(
				acumulado.getQntdLojasVisitadas(), acumulado.getQntdHorasTrabalho()));
		
		return acumulado;
	}

	public PerformanceMeta calcularPerformance(final Meta meta) {
		AcumuladoMeta acumulado = meta.getAcumulado();
		PerformanceMeta performance = new PerformanceMeta();
		performance.setQntdLojasVisitadas(
				this.dividir(
						acumulado.getQntdLojasVisitadas(),
						(acumulado.getQntdDiasUteis() * meta.getMediaLojasDia())
					)
			);
		performance.setQntdOcorrencias(
				this.dividir(
					acumulado.getQntdOcorrencias(),
					acumulado.getQntdLojasVisitadas()
					)
			);
		
		performance.setQntdDiasUteis(
				acumulado.getQntdDiasUteis());
		
		performance.setQntdHorasTrabalho(this.dividir(
				acumulado.getQntdHorasTrabalho(),
					(acumulado.getQntdDiasUteis() * this.dividir(meta.getTotalHorasTrabalho(), meta.getTotalDiasUteis())
							)
				)
			);
		performance.setMediaLojasDia(
				this.dividir(
						acumulado.getMediaLojasDia(),
						meta.getMediaLojasDia()
					)
			);
		performance.setVelocidadeMedia(
				this.dividir(
						acumulado.getVelocidadeMedia(),
						meta.getVelocidadeMediaVisitas()
					)
			);
		
		return performance;
	}

	public MetaSupervisor criarMetaSupervisor(final List<Pesquisador> pesquisadores) {
		MetaSupervisor meta = new MetaSupervisor();
		meta.setHorasTrabalhadasDia(8);
		meta.setQntdPesquisadores(pesquisadores.size());
		for (Pesquisador pesquisador : pesquisadores) {
			// META
			Meta metaPesq = pesquisador.getMeta();
			meta.setMediaLojasDia(meta.getMediaLojasDia() + metaPesq.getMediaLojasDia());
			meta.setTotalDiasUteis(this.encontrarDiasUteis());
			meta.setTotalHorasTrabalho(meta.getTotalHorasTrabalho() + metaPesq.getTotalHorasTrabalho());
			meta.setTotalLojasVisitar(meta.getTotalLojasVisitar() + metaPesq.getTotalLojasVisitar());
			meta.setVelocidadeMediaVisitas(meta.getVelocidadeMediaVisitas() + 
					dividir(metaPesq.getVelocidadeMediaVisitas(), pesquisadores.size()));
		}
		return meta;
	}

	public List<ProgressoDiarioMeta> calcularProgressoMetaSupervisor(final List<Pesquisador> pesquisadores) {
		List<ProgressoDiarioMeta> listaProgressoMeta = new ArrayList<>();
		
		int hoje = LocalDate.now().getDayOfMonth();
//		for (int i = 1; i <= hoje; i++) {
		int maxDay = pesquisadores.stream().map(p -> p.getMeta().getListaProgressoMeta().size()).findFirst().orElse(hoje);
		for (int i = 1; i <= maxDay; i++){
			ProgressoDiarioMeta progressoSupervisor = new ProgressoDiarioMeta();
			for (Pesquisador pesquisador : pesquisadores) {
				for (ProgressoDiarioMeta progressoPesquisador : pesquisador.getMeta().getListaProgressoMeta()) {
					//FIXME: Melhorar essa solução do IF
					if (progressoPesquisador.getDia() == i) {
						progressoSupervisor.setDia(progressoPesquisador.getDia());
						progressoSupervisor.setDataDeRegistro(progressoPesquisador.getDataDeRegistro());
						progressoSupervisor.setQntdDiasUteis(progressoPesquisador.getQntdDiasUteis());
						progressoSupervisor.setQntdHorasTrabalho(
								progressoSupervisor.getQntdHorasTrabalho().plus(progressoPesquisador.getQntdHorasTrabalho()));
						progressoSupervisor.setQntdOcorrencias(
								progressoSupervisor.getQntdOcorrencias() + progressoPesquisador.getQntdOcorrencias());
						progressoSupervisor.setQntdLojasVisitadas(
								progressoSupervisor.getQntdLojasVisitadas() + progressoPesquisador.getQntdLojasVisitadas());
						progressoSupervisor.setVelocidadeMedia(
								progressoSupervisor.getVelocidadeMedia() + 
								dividir(progressoPesquisador.getVelocidadeMedia(), pesquisadores.size()));
						break;
					}
				}
				
			}
			listaProgressoMeta.add(progressoSupervisor);
		}
		
		return listaProgressoMeta;
	}
	
}
