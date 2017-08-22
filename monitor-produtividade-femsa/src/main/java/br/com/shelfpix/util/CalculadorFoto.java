package br.com.shelfpix.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.shelfpix.model.AcumuladoFoto;
import br.com.shelfpix.model.PerformanceFoto;
import br.com.shelfpix.model.Pesquisador;
import br.com.shelfpix.model.ProgressoDiarioFoto;

@Component
public class CalculadorFoto extends CalculadorCommons {

	public AcumuladoFoto calcularAcumulado(final List<ProgressoDiarioFoto> progressoFoto) {
		AcumuladoFoto acumulado = new AcumuladoFoto();
		for (ProgressoDiarioFoto progresso : progressoFoto) {
			
			acumulado.setDataDeRegistro(progresso.getDataDeRegistro());
			
			acumulado.setAutomatico(
					acumulado.getAutomatico() + progresso.getAutomatico());
			
			acumulado.setDescarte(
					acumulado.getDescarte() + progresso.getDescarte());
			
			acumulado.setEvidencia(
					acumulado.getEvidencia() + progresso.getEvidencia());
			
			acumulado.setManual(
					acumulado.getManual() + progresso.getManual());
			
			acumulado.setOcorrencia(
					acumulado.getOcorrencia() + progresso.getOcorrencia());
			
			acumulado.setProcessaveis(
					acumulado.getProcessaveis() + progresso.getProcessaveis());
			
			acumulado.setPublicadas(
					acumulado.getPublicadas() + progresso.getPublicadas());
			
			acumulado.setRecebidas(
					acumulado.getRecebidas() + progresso.getRecebidas());
			
			acumulado.setTiradas(
					acumulado.getTiradas() + progresso.getTiradas());
			
		}
		
		return acumulado;
	}

	public PerformanceFoto calcularPerformance(final AcumuladoFoto acumulado) {
		
		PerformanceFoto performance = new PerformanceFoto();
		
		performance.setAutomatico(this.dividir(
				acumulado.getAutomatico(), acumulado.getProcessaveis()));
		
		performance.setDescarte(this.dividir(
				acumulado.getDescarte(), acumulado.getProcessaveis()));
		
		performance.setEvidencia(this.dividir(
				acumulado.getEvidencia(), acumulado.getRecebidas()));
		
		performance.setManual(this.dividir(
				acumulado.getManual(), acumulado.getProcessaveis()));
		
		performance.setOcorrencia(this.dividir(
				acumulado.getOcorrencia(), acumulado.getRecebidas()));
		
		performance.setProcessaveis(this.dividir(
				acumulado.getProcessaveis(), acumulado.getRecebidas()));
		
		performance.setPublicadas(this.dividir(
				acumulado.getManual(), acumulado.getProcessaveis()));
		
		performance.setRecebidas(this.dividir(
				acumulado.getRecebidas(), acumulado.getTiradas()));
		
		performance.setTiradas(acumulado.getTiradas());
		
		return performance;
	}


	public List<ProgressoDiarioFoto> calcularProgressoFotoSupervisor(final List<Pesquisador> pesquisadores) {
		List<ProgressoDiarioFoto> listaProgressoFoto = new ArrayList<>();
		int hoje = LocalDate.now().getDayOfMonth();
//		for (int i = 1; i <= hoje; i++) {
		int maxDay = pesquisadores.stream().map(p -> p.getMeta().getListaProgressoMeta().size()).findFirst().orElse(hoje);
		for (int i = 1; i <= maxDay; i++) {
			ProgressoDiarioFoto progressoSupervisor = new ProgressoDiarioFoto();
			for (Pesquisador pesquisador : pesquisadores) {
				for (ProgressoDiarioFoto progressoPesquisador : pesquisador.getDetalhe().getListaProgressoFoto()) {
					if (progressoPesquisador.getDia() == i) {
						
						progressoSupervisor.setDia(progressoPesquisador.getDia());
						
						progressoSupervisor.setDataDeRegistro(progressoPesquisador.getDataDeRegistro());
						
						progressoSupervisor.setAutomatico(
								progressoSupervisor.getAutomatico() + progressoPesquisador.getAutomatico());
						
						progressoSupervisor.setDescarte(
								progressoSupervisor.getDescarte() + progressoPesquisador.getDescarte());
						
						progressoSupervisor.setEvidencia(
								progressoSupervisor.getEvidencia() + progressoPesquisador.getEvidencia());
						
						progressoSupervisor.setManual(
								progressoSupervisor.getManual() + progressoPesquisador.getManual());
						
						progressoSupervisor.setOcorrencia(
								progressoSupervisor.getOcorrencia() + progressoPesquisador.getOcorrencia());
						
						progressoSupervisor.setProcessaveis(
								progressoSupervisor.getProcessaveis() + progressoPesquisador.getProcessaveis());
						
						progressoSupervisor.setPublicadas(
								progressoSupervisor.getPublicadas() + progressoPesquisador.getPublicadas());
						
						progressoSupervisor.setRecebidas(
								progressoSupervisor.getRecebidas() + progressoPesquisador.getRecebidas());
						
						progressoSupervisor.setTiradas(
								progressoSupervisor.getTiradas() + progressoPesquisador.getTiradas());
						
						break;
					}
				}
				
			}
			listaProgressoFoto.add(progressoSupervisor);
		}
		
		return listaProgressoFoto;
	}

}
