package br.com.shelfpix.model;

public class MetaSupervisor extends Meta {
	private int qntdPesquisadores;

	public int getQntdPesquisadores() {
		return qntdPesquisadores;
	}

	public void setQntdPesquisadores(int qntdPesquisadores) {
		this.qntdPesquisadores = qntdPesquisadores;
	}

	@Override
	public String toString() {
		return "MetaSupervisor [qntdPesquisadores=" + qntdPesquisadores + "]";
	}
	
}
