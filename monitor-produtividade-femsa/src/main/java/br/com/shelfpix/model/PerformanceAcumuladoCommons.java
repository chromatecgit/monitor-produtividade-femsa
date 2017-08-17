package br.com.shelfpix.model;

import java.time.LocalDate;

public class PerformanceAcumuladoCommons {
	private LocalDate dataDeRegistro;
	private double qntdLojasVisitadas;
	private double qntdOcorrencias;
	private int qntdDiasUteis;
	private double velocidadeMedia;
	private double mediaLojasDia;
	
	public PerformanceAcumuladoCommons() {
		this.dataDeRegistro = LocalDate.MIN;
	}



	@Override
	public String toString() {
		return "PerformanceAcumuladoCommons [dataDeRegistro=" + dataDeRegistro + ", qntdLojasVisitadas="
				+ qntdLojasVisitadas + ", qntdOcorrencias=" + qntdOcorrencias + ", qntdDiasUteis=" + qntdDiasUteis
				+ ", velocidadeMedia=" + velocidadeMedia + ", mediaLojasDia=" + mediaLojasDia + "]";
	}



	public LocalDate getDataDeRegistro() {
		return dataDeRegistro;
	}

	public void setDataDeRegistro(LocalDate dataDeRegistro) {
		this.dataDeRegistro = dataDeRegistro;
	}

	public double getQntdLojasVisitadas() {
		return qntdLojasVisitadas;
	}

	public void setQntdLojasVisitadas(double qntdLojasVisitadas) {
		this.qntdLojasVisitadas = qntdLojasVisitadas;
	}

	public double getQntdOcorrencias() {
		return qntdOcorrencias;
	}

	public void setQntdOcorrencias(double qntdOcorrencias) {
		this.qntdOcorrencias = qntdOcorrencias;
	}

	public int getQntdDiasUteis() {
		return qntdDiasUteis;
	}

	public void setQntdDiasUteis(int qntdDiasUteis) {
		this.qntdDiasUteis = qntdDiasUteis;
	}

	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

	public double getMediaLojasDia() {
		return mediaLojasDia;
	}

	public void setMediaLojasDia(double mediaLojasDia) {
		this.mediaLojasDia = mediaLojasDia;
	}

}
