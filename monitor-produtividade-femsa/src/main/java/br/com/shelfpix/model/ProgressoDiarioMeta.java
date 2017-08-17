package br.com.shelfpix.model;

import java.time.Duration;

public class ProgressoDiarioMeta extends ProgressoDiario {
	private int qntdLojasVisitadas;
	private int qntdOcorrencias;
	private int qntdDiasUteis;
	private Duration qntdHorasTrabalho;
	private double velocidadeMedia;
	
	public ProgressoDiarioMeta() {
		this.qntdHorasTrabalho = Duration.ZERO;
	}

	public int getQntdLojasVisitadas() {
		return qntdLojasVisitadas;
	}

	public void setQntdLojasVisitadas(int qntdLojasVisitadas) {
		this.qntdLojasVisitadas = qntdLojasVisitadas;
	}

	public int getQntdOcorrencias() {
		return qntdOcorrencias;
	}

	public void setQntdOcorrencias(int qntdOcorrencias) {
		this.qntdOcorrencias = qntdOcorrencias;
	}

	public int getQntdDiasUteis() {
		return qntdDiasUteis;
	}

	public void setQntdDiasUteis(int qntdDiasUteis) {
		this.qntdDiasUteis = qntdDiasUteis;
	}

	public Duration getQntdHorasTrabalho() {
		return qntdHorasTrabalho;
	}

	public void setQntdHorasTrabalho(Duration qntdHorasTrabalho) {
		this.qntdHorasTrabalho = qntdHorasTrabalho;
	}

	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

	@Override
	public String toString() {
		return "ProgressoDiarioMeta [qntdLojasVisitadas=" + qntdLojasVisitadas + ", qntdOcorrencias=" + qntdOcorrencias
				+ ", qntdDiasUteis=" + qntdDiasUteis + ", qntdHorasTrabalho=" + qntdHorasTrabalho + ", velocidadeMedia="
				+ velocidadeMedia + "]";
	}

}
