package br.com.shelfpix.model;

public class PerformancePreco {
	private double capturados;
	private double publicados;

	public double getCapturados() {
		return capturados;
	}

	public void setCapturados(double capturados) {
		this.capturados = capturados;
	}

	public double getPublicados() {
		return publicados;
	}

	public void setPublicados(double publicados) {
		this.publicados = publicados;
	}

	@Override
	public String toString() {
		return "PerformancePreco [capturados=" + capturados + ", publicados=" + publicados + "]";
	}
	

}
