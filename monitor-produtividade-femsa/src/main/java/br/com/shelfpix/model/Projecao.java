package br.com.shelfpix.model;

public class Projecao {
	private double metaAjustada;
	private double projecaoOcorrencias;
	private double amostraProvavel;
	private double ajusteHorasTrabalhadasDia;
	private double qntdAdicionalLojas;

	public double getMetaAjustada() {
		return metaAjustada;
	}

	public void setMetaAjustada(double metaAjustada) {
		this.metaAjustada = metaAjustada;
	}

	public double getProjecaoOcorrencias() {
		return projecaoOcorrencias;
	}

	public void setProjecaoOcorrencias(double projecaoOcorrencias) {
		this.projecaoOcorrencias = projecaoOcorrencias;
	}

	public double getAmostraProvavel() {
		return amostraProvavel;
	}

	public void setAmostraProvavel(double amostraProvavel) {
		this.amostraProvavel = amostraProvavel;
	}

	public double getAjusteHorasTrabalhadasDia() {
		return ajusteHorasTrabalhadasDia;
	}

	public void setAjusteHorasTrabalhadasDia(double ajusteHorasTrabalhadasDia) {
		this.ajusteHorasTrabalhadasDia = ajusteHorasTrabalhadasDia;
	}

	public double getQntdAdicionalLojas() {
		return qntdAdicionalLojas;
	}

	public void setQntdAdicionalLojas(double qntdAdicionalLojas) {
		this.qntdAdicionalLojas = qntdAdicionalLojas;
	}

	@Override
	public String toString() {
		return "Projecao [metaAjustada=" + metaAjustada + ", projecaoOcorrencias=" + projecaoOcorrencias
				+ ", amostraProvavel=" + amostraProvavel + ", ajusteHorasTrabalhadasDia=" + ajusteHorasTrabalhadasDia
				+ ", qntdAdicionalLojas=" + qntdAdicionalLojas + "]";
	}

}
