package br.com.shelfpix.model;

public class ProgressoDiarioFoto extends ProgressoDiario {
	private int tiradas;
	private int recebidas;
	private int evidencia;
	private int ocorrencia;
	private int processaveis;
	private int automatico;
	private int manual;
	private int descarte;
	private int publicadas;

	public int getTiradas() {
		return tiradas;
	}

	public void setTiradas(int tiradas) {
		this.tiradas = tiradas;
	}

	public int getRecebidas() {
		return recebidas;
	}

	public void setRecebidas(int recebidas) {
		this.recebidas = recebidas;
	}

	public int getEvidencia() {
		return evidencia;
	}

	public void setEvidencia(int evidencia) {
		this.evidencia = evidencia;
	}

	public int getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(int ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public int getProcessaveis() {
		return processaveis;
	}

	public void setProcessaveis(int processaveis) {
		this.processaveis = processaveis;
	}

	public int getAutomatico() {
		return automatico;
	}

	public void setAutomatico(int automatico) {
		this.automatico = automatico;
	}

	public int getManual() {
		return manual;
	}

	public void setManual(int manual) {
		this.manual = manual;
	}

	public int getDescarte() {
		return descarte;
	}

	public void setDescarte(int descarte) {
		this.descarte = descarte;
	}

	public int getPublicadas() {
		return publicadas;
	}

	public void setPublicadas(int publicadas) {
		this.publicadas = publicadas;
	}

	@Override
	public String toString() {
		return "ProgressoDiarioFoto [tiradas=" + tiradas + ", recebidas=" + recebidas + ", evidencia=" + evidencia
				+ ", ocorrencia=" + ocorrencia + ", processaveis=" + processaveis + ", automatico=" + automatico
				+ ", manual=" + manual + ", descarte=" + descarte + ", publicadas=" + publicadas + "]";
	}
	
	
}
