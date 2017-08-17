package br.com.shelfpix.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component
public class MetaViewDTO {
	
	private Integer idPesquisador;
	private String nome;
	private String sobrenome;
	private LocalDate dataVisita;
	private Integer totalLojasVisitar;
	private Integer totalDiasUteis;
	private Integer horasTrabalhadasDia;
	private Integer numeroLojasVisitadas;
	private Integer numeroLojasRecusadas;
	private Boolean flagDiaUtil;
	private LocalTime horasTrabalhadas;
	private Integer fotosPublicadas;
	private Integer fotosOcorrencia;
	private Integer fotosEvidencia;
	private Integer precosPublicados;
	
	public MetaViewDTO() {
		this.horasTrabalhadas = LocalTime.MIN;
	}
	
	public Integer getIdPesquisador() {
		return idPesquisador;
	}

	public void setIdPesquisador(Integer idPesquisador) {
		this.idPesquisador = idPesquisador;
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

	public LocalDate getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(LocalDate dataVisita) {
		this.dataVisita = dataVisita;
	}

	public Integer getTotalLojasVisitar() {
		return totalLojasVisitar;
	}

	public void setTotalLojasVisitar(Integer totalLojasVisitar) {
		this.totalLojasVisitar = totalLojasVisitar;
	}

	public Integer getTotalDiasUteis() {
		return totalDiasUteis;
	}

	public void setTotalDiasUteis(Integer totalDiasUteis) {
		this.totalDiasUteis = totalDiasUteis;
	}

	public Integer getHorasTrabalhadasDia() {
		return horasTrabalhadasDia;
	}

	public void setHorasTrabalhadasDia(Integer horasTrabalhadasDia) {
		this.horasTrabalhadasDia = horasTrabalhadasDia;
	}

	public Integer getNumeroLojasVisitadas() {
		return numeroLojasVisitadas;
	}

	public void setNumeroLojasVisitadas(Integer numeroLojasVisitadas) {
		this.numeroLojasVisitadas = numeroLojasVisitadas;
	}

	public Integer getNumeroLojasRecusadas() {
		return numeroLojasRecusadas;
	}

	public void setNumeroLojasRecusadas(Integer numeroLojasRecusadas) {
		this.numeroLojasRecusadas = numeroLojasRecusadas;
	}

	public Boolean getFlagDiaUtil() {
		return flagDiaUtil;
	}

	public void setFlagDiaUtil(Boolean flagDiaUtil) {
		this.flagDiaUtil = flagDiaUtil;
	}

	public LocalTime getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(LocalTime horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public Integer getFotosPublicadas() {
		return fotosPublicadas;
	}

	public void setFotosPublicadas(Integer fotosPublicadas) {
		this.fotosPublicadas = fotosPublicadas;
	}

	public Integer getFotosOcorrencia() {
		return fotosOcorrencia;
	}

	public void setFotosOcorrencia(Integer fotosOcorrencia) {
		this.fotosOcorrencia = fotosOcorrencia;
	}

	public Integer getFotosEvidencia() {
		return fotosEvidencia;
	}

	public void setFotosEvidencia(Integer fotosEvidencia) {
		this.fotosEvidencia = fotosEvidencia;
	}

	public Integer getPrecosPublicados() {
		return precosPublicados;
	}

	public void setPrecosPublicados(Integer precosPublicados) {
		this.precosPublicados = precosPublicados;
	}
	
}
