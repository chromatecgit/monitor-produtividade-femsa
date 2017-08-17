package br.com.shelfpix.model;

import java.util.List;

public class Supervisor {
	private String nome;
	private List<Pesquisador> pesquisadores;
	private MetaSupervisor meta;
	private Detalhe detalhe;

	public Supervisor() {
		this.detalhe = new Detalhe();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public MetaSupervisor getMeta() {
		return meta;
	}

	public void setMeta(MetaSupervisor meta) {
		this.meta = meta;
	}

	public List<Pesquisador> getPesquisadores() {
		return pesquisadores;
	}

	public void setPesquisadores(List<Pesquisador> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}

	public Detalhe getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(Detalhe detalhe) {
		this.detalhe = detalhe;
	}

	@Override
	public String toString() {
		return "Supervisor [nome=" + nome + ", pesquisadores=" + pesquisadores + ", meta=" + meta + ", detalhe="
				+ detalhe + "]";
	}

}
