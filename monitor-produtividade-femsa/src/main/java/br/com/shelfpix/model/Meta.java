package br.com.shelfpix.model;

import java.util.List;

public class Meta {
	private int totalLojasVisitar;
	private int totalDiasUteis;
	private int horasTrabalhadasDia;
	/** A quantidade de tempo esperada de trabalho por dia. */
	private int totalHorasTrabalho;
	private double mediaLojasDia;
	private double velocidadeMediaVisitas;
	private List<ProgressoDiarioMeta> listaProgressoMeta;
	private PerformanceMeta performance;
	private AcumuladoMeta acumulado;
	private Projecao projecao;

	public Meta() {

	}

	public int getTotalLojasVisitar() {
		return totalLojasVisitar;
	}

	public void setTotalLojasVisitar(int totalLojasVisitar) {
		this.totalLojasVisitar = totalLojasVisitar;
	}

	public int getTotalDiasUteis() {
		return totalDiasUteis;
	}

	public void setTotalDiasUteis(int totalDiasUteis) {
		this.totalDiasUteis = totalDiasUteis;
	}

	public int getHorasTrabalhadasDia() {
		return horasTrabalhadasDia;
	}

	public void setHorasTrabalhadasDia(int horasTrabalhadasDia) {
		this.horasTrabalhadasDia = horasTrabalhadasDia;
	}

	public int getTotalHorasTrabalho() {
		return totalHorasTrabalho;
	}

	public void setTotalHorasTrabalho(int totalHorasTrabalho) {
		this.totalHorasTrabalho = totalHorasTrabalho;
	}

	public double getMediaLojasDia() {
		return mediaLojasDia;
	}

	public void setMediaLojasDia(double mediaLojasDia) {
		this.mediaLojasDia = mediaLojasDia;
	}

	public double getVelocidadeMediaVisitas() {
		return velocidadeMediaVisitas;
	}

	public void setVelocidadeMediaVisitas(double velocidadeMediaVisitas) {
		this.velocidadeMediaVisitas = velocidadeMediaVisitas;
	}

	public PerformanceMeta getPerformance() {
		return performance;
	}

	public void setPerformance(PerformanceMeta performance) {
		this.performance = performance;
	}

	public AcumuladoMeta getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(AcumuladoMeta acumulado) {
		this.acumulado = acumulado;
	}

	public Projecao getProjecao() {
		return projecao;
	}

	public void setProjecao(Projecao projecao) {
		this.projecao = projecao;
	}

	public List<ProgressoDiarioMeta> getListaProgressoMeta() {
		return listaProgressoMeta;
	}

	public void setListaProgressoMeta(List<ProgressoDiarioMeta> listaProgressoMeta) {
		this.listaProgressoMeta = listaProgressoMeta;
	}

	@Override
	public String toString() {
		return "Meta [totalLojasVisitar=" + totalLojasVisitar + ", totalDiasUteis=" + totalDiasUteis
				+ ", horasTrabalhadasDia=" + horasTrabalhadasDia + ", totalHorasTrabalho=" + totalHorasTrabalho
				+ ", mediaLojasDia=" + mediaLojasDia + ", velocidadeMediaVisitas=" + velocidadeMediaVisitas
				+ ", listaProgressoMeta=" + listaProgressoMeta + ", performance=" + performance + ", acumulado="
				+ acumulado + ", projecao=" + projecao + "]";
	}

}
