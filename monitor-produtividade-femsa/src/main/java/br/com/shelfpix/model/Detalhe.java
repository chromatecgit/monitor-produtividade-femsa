package br.com.shelfpix.model;

import java.util.List;

public class Detalhe {

	private PerformanceFoto performanceFoto;
	private AcumuladoFoto acumuladoFoto;
	private List<ProgressoDiarioFoto> listaProgressoFoto;
	private PerformancePreco performancePreco;
	private AcumuladoPreco acumuladoPreco;
	private List<ProgressoDiarioPreco> listaProgressoPreco;
	private PerformanceQuestionario performanceQuestionario;
	private AcumuladoQuestionario acumuladoQuestionario;
	private List<ProgressoDiarioQuestionario> listaProgressoQuestionario;
	
	public Detalhe() {
		this.performanceFoto = new PerformanceFoto();
		this.acumuladoFoto = new AcumuladoFoto();
		this.performancePreco = new PerformancePreco();
		this.acumuladoPreco = new AcumuladoPreco();
		this.performanceQuestionario = new PerformanceQuestionario();
		this.acumuladoQuestionario = new AcumuladoQuestionario();
	}

	public PerformanceFoto getPerformanceFoto() {
		return performanceFoto;
	}

	public void setPerformanceFoto(PerformanceFoto performanceFoto) {
		this.performanceFoto = performanceFoto;
	}

	public AcumuladoFoto getAcumuladoFoto() {
		return acumuladoFoto;
	}

	public void setAcumuladoFoto(AcumuladoFoto acumuladoFoto) {
		this.acumuladoFoto = acumuladoFoto;
	}

	public List<ProgressoDiarioFoto> getListaProgressoFoto() {
		return listaProgressoFoto;
	}

	public void setListaProgressoFoto(List<ProgressoDiarioFoto> listaProgressoFoto) {
		this.listaProgressoFoto = listaProgressoFoto;
	}

	public PerformancePreco getPerformancePreco() {
		return performancePreco;
	}

	public void setPerformancePreco(PerformancePreco performancePreco) {
		this.performancePreco = performancePreco;
	}

	public AcumuladoPreco getAcumuladoPreco() {
		return acumuladoPreco;
	}

	public void setAcumuladoPreco(AcumuladoPreco acumuladoPreco) {
		this.acumuladoPreco = acumuladoPreco;
	}

	public List<ProgressoDiarioPreco> getListaProgressoPreco() {
		return listaProgressoPreco;
	}

	public void setListaProgressoPreco(List<ProgressoDiarioPreco> listaProgressoPreco) {
		this.listaProgressoPreco = listaProgressoPreco;
	}

	public PerformanceQuestionario getPerformanceQuestionario() {
		return performanceQuestionario;
	}

	public void setPerformanceQuestionario(PerformanceQuestionario performanceQuestionario) {
		this.performanceQuestionario = performanceQuestionario;
	}

	public AcumuladoQuestionario getAcumuladoQuestionario() {
		return acumuladoQuestionario;
	}

	public void setAcumuladoQuestionario(AcumuladoQuestionario acumuladoQuestionario) {
		this.acumuladoQuestionario = acumuladoQuestionario;
	}

	public List<ProgressoDiarioQuestionario> getListaProgressoQuestionario() {
		return listaProgressoQuestionario;
	}

	public void setListaProgressoQuestionario(List<ProgressoDiarioQuestionario> listaProgressoQuestionario) {
		this.listaProgressoQuestionario = listaProgressoQuestionario;
	}

	@Override
	public String toString() {
		return "Detalhe [performanceFoto=" + performanceFoto + ", acumuladoFoto=" + acumuladoFoto
				+ ", listaProgressoFoto=" + listaProgressoFoto + ", performancePreco=" + performancePreco
				+ ", acumuladoPreco=" + acumuladoPreco + ", listaProgressoPreco=" + listaProgressoPreco
				+ ", performanceQuestionario=" + performanceQuestionario + ", acumuladoQuestionario="
				+ acumuladoQuestionario + ", listaProgressoQuestionario=" + listaProgressoQuestionario + "]";
	}
	

}
