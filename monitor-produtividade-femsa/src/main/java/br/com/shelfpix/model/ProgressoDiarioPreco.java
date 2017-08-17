package br.com.shelfpix.model;

public class ProgressoDiarioPreco extends ProgressoDiario {
	private int capturados;
	private int publicados;

	public int getCapturados() {
		return capturados;
	}

	public void setCapturados(int capturados) {
		this.capturados = capturados;
	}

	public int getPublicados() {
		return publicados;
	}

	public void setPublicados(int publicados) {
		this.publicados = publicados;
	}

	@Override
	public String toString() {
		return "ProgressoDiarioPreco [capturados=" + capturados + ", publicados=" + publicados + "]";
	}
	
	
}
