package br.com.shelfpix.model;

import java.time.Duration;

public class AcumuladoMeta extends PerformanceAcumuladoCommons{
	private Duration qntdHorasTrabalho;
	
	public AcumuladoMeta() {
		this.qntdHorasTrabalho = Duration.ZERO;
	}
	

	@Override
	public String toString() {
		return "AcumuladoMeta [qntdHorasTrabalho=" + qntdHorasTrabalho + "]";
	}

	public Duration getQntdHorasTrabalho() {
		return qntdHorasTrabalho;
	}

	public void setQntdHorasTrabalho(Duration qntdHorasTrabalho) {
		this.qntdHorasTrabalho = qntdHorasTrabalho;
	}
	
}
