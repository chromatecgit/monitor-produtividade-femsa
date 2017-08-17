package br.com.shelfpix.model;

public class Pesquisador {
	private int id;
	private String nome;
	private String sobrenome;
	private Meta meta;
	private Detalhe detalhe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Detalhe getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(Detalhe detalhe) {
		this.detalhe = detalhe;
	}

	@Override
	public String toString() {
		return "Pesquisador [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", meta=" + meta + ", detalhe="
				+ detalhe + "]";
	}
	
	

}
