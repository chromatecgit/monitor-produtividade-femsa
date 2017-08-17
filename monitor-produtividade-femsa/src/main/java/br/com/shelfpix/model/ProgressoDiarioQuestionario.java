package br.com.shelfpix.model;

public class ProgressoDiarioQuestionario extends ProgressoDiario {
	private int preenchidos;
	private int publicados;

	public int getPreenchidos() {
		return preenchidos;
	}

	public void setPreenchidos(int preenchidos) {
		this.preenchidos = preenchidos;
	}

	public int getPublicados() {
		return publicados;
	}

	public void setPublicados(int publicados) {
		this.publicados = publicados;
	}

	@Override
	public String toString() {
		return "ProgressoDiarioQuestionario [preenchidos=" + preenchidos + ", publicados=" + publicados + "]";
	}
	
}
