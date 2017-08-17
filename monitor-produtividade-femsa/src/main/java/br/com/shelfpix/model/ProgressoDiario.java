package br.com.shelfpix.model;

import java.time.LocalDate;

public class ProgressoDiario {
	private int dia;
	private LocalDate dataDeRegistro;
	
	public ProgressoDiario() {
		this.dataDeRegistro = LocalDate.MIN;
	}
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public LocalDate getDataDeRegistro() {
		return dataDeRegistro;
	}

	public void setDataDeRegistro(LocalDate dataDeRegistro) {
		this.dataDeRegistro = dataDeRegistro;
	}

}
