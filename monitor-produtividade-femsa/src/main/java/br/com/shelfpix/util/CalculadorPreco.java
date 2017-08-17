package br.com.shelfpix.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.shelfpix.model.AcumuladoPreco;
import br.com.shelfpix.model.PerformancePreco;
import br.com.shelfpix.model.Pesquisador;
import br.com.shelfpix.model.ProgressoDiarioPreco;

@Component
public class CalculadorPreco extends CalculadorCommons {
	
	public AcumuladoPreco calcularAcumulado(final List<ProgressoDiarioPreco> progressoPreco) {
		AcumuladoPreco acumulado = new AcumuladoPreco();
		for (ProgressoDiarioPreco progresso : progressoPreco) {
			
			acumulado.setDataDeRegistro(progresso.getDataDeRegistro());
			
			acumulado.setCapturados(acumulado.getCapturados() + progresso.getCapturados());
			
			acumulado.setPublicados(
					acumulado.getPublicados() + progresso.getPublicados());
			
		}
		
		return acumulado;
	}

	public PerformancePreco calcularPerformance(final AcumuladoPreco acumulado) {
		
		PerformancePreco performance = new PerformancePreco();
		
		performance.setCapturados(acumulado.getCapturados());
		
		performance.setPublicados(this.dividir(
				acumulado.getPublicados(), acumulado.getCapturados()));
		
		return performance;
	}


	public List<ProgressoDiarioPreco> calcularProgressoPrecoSupervisor(final List<Pesquisador> pesquisadores) {
		List<ProgressoDiarioPreco> listaProgressoPreco = new ArrayList<>();
		int hoje = LocalDate.now().getDayOfMonth();
		for (int i = 1; i <= hoje; i++) {
			ProgressoDiarioPreco progressoSupervisor = new ProgressoDiarioPreco();
			for (Pesquisador pesquisador : pesquisadores) {
				for (ProgressoDiarioPreco progressoPesquisador : pesquisador.getDetalhe().getListaProgressoPreco()) {
					if (progressoPesquisador.getDia() == i) {
						
						progressoSupervisor.setDia(progressoPesquisador.getDia());
						
						progressoSupervisor.setDataDeRegistro(progressoPesquisador.getDataDeRegistro());
						
						progressoSupervisor.setCapturados(
								progressoSupervisor.getCapturados() + progressoPesquisador.getCapturados());
						
						progressoSupervisor.setPublicados(
								progressoSupervisor.getPublicados() + progressoPesquisador.getPublicados());
						
						
						break;
					}
				}
				
			}
			listaProgressoPreco.add(progressoSupervisor);
		}
		
		return listaProgressoPreco;
	}

}
