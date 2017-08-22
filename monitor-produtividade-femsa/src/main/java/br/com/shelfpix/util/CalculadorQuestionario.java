package br.com.shelfpix.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.shelfpix.model.AcumuladoQuestionario;
import br.com.shelfpix.model.PerformanceQuestionario;
import br.com.shelfpix.model.Pesquisador;
import br.com.shelfpix.model.ProgressoDiarioQuestionario;

@Component
public class CalculadorQuestionario extends CalculadorCommons {
	
	public AcumuladoQuestionario calcularAcumulado(final List<ProgressoDiarioQuestionario> progressoQuestionario) {
		AcumuladoQuestionario acumulado = new AcumuladoQuestionario();
		for (ProgressoDiarioQuestionario progresso : progressoQuestionario) {
			
			acumulado.setDataDeRegistro(progresso.getDataDeRegistro());
			
			acumulado.setPreenchidos(
					acumulado.getPreenchidos() + progresso.getPreenchidos());
			
			acumulado.setPublicados(
					acumulado.getPublicados() + progresso.getPublicados());
			
		}
		
		return acumulado;
	}

	public PerformanceQuestionario calcularPerformance(final AcumuladoQuestionario acumulado) {
		
		PerformanceQuestionario performance = new PerformanceQuestionario();
		
		performance.setPreenchidos(acumulado.getPreenchidos());
		
		performance.setPublicados(this.dividir(
				acumulado.getPublicados(), acumulado.getPreenchidos()));
		
		return performance;
	}

	public List<ProgressoDiarioQuestionario> calcularProgressoQuestionarioSupervisor(final List<Pesquisador> pesquisadores) {
		List<ProgressoDiarioQuestionario> listaProgressoQuestionario = new ArrayList<>();
		int hoje = LocalDate.now().getDayOfMonth();
//		for (int i = 1; i <= hoje; i++) {
		int maxDay = pesquisadores.stream().map(p -> p.getMeta().getListaProgressoMeta().size()).findFirst().orElse(hoje);
		for (int i = 1; i <= maxDay; i++) {
			ProgressoDiarioQuestionario progressoSupervisor = new ProgressoDiarioQuestionario();
			for (Pesquisador pesquisador : pesquisadores) {
				for (ProgressoDiarioQuestionario progressoPesquisador : pesquisador.getDetalhe().getListaProgressoQuestionario()) {
					if (progressoPesquisador.getDia() == i) {
						
						progressoSupervisor.setDia(progressoPesquisador.getDia());
						
						progressoSupervisor.setDataDeRegistro(progressoPesquisador.getDataDeRegistro());
						
						progressoSupervisor.setPreenchidos(
								progressoSupervisor.getPreenchidos() + progressoPesquisador.getPreenchidos());
						
						progressoSupervisor.setPublicados(
								progressoSupervisor.getPublicados() + progressoPesquisador.getPublicados());
						
						
						break;
					}
				}
				
			}
			listaProgressoQuestionario.add(progressoSupervisor);
		}
		
		return listaProgressoQuestionario;
	}


	

}
