package br.com.shelfpix.model;

public class PerformanceQuestionario {
	private double preenchidos;
	private double publicados;

	public double getPreenchidos() {
		return preenchidos;
	}

	public void setPreenchidos(double preenchidos) {
		this.preenchidos = preenchidos;
	}

	public double getPublicados() {
		return publicados;
	}

	public void setPublicados(double publicados) {
		this.publicados = publicados;
	}

	@Override
	public String toString() {
		return "PerformanceQuestionario [preenchidos=" + preenchidos + ", publicados=" + publicados + "]";
	}

}
