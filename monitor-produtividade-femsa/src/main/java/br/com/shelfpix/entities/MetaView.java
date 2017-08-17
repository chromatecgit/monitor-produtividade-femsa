package br.com.shelfpix.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//NAO USAR
@Entity
@Table(name = "Meta")
@NamedStoredProcedureQuery(
		procedureName = "spxPkgMeta",
		resultClasses = MetaView.class,
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "dataInicio"), 
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "dataFim"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "idCompanhia"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "idItinerario")
		},
		name = "metaViewProcedure")
public class MetaView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "Pesquisador")
	private Integer idPesquisador;

	@Column(name = "Nome", length = 100)
	private String nome;

	@Column(name = "Sobrenome", length = 100)
	private String sobrenome;

	@Column(name = "DataVisita")
	@Temporal(TemporalType.DATE)
	private Date dataVisita;

	@Column(name = "TotalLojasVisitar")
	private Integer totalLojasVisitar;

	@Column(name = "TotalDiasUteis")
	private Integer totalDiasUteis;

	@Column(name = "HorasTrabalhadasDia")
	private Integer horasTrabalhadasDia;

	@Column(name = "LojasVisitadas")
	private Integer numeroLojasVisitadas;

	@Column(name = "LojasRecusadas")
	private Integer numeroLojasRecusadas;

	@Column(name = "DiaUtil")
	private Integer flagDiaUtil;

	@Column(name = "HorasTrabalhadas")
	private String horasTrabalhadas;

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

	public Date getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(Date dataVisita) {
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

	public Integer getFlagDiaUtil() {
		return flagDiaUtil;
	}

	public void setFlagDiaUtil(Integer flagDiaUtil) {
		this.flagDiaUtil = flagDiaUtil;
	}

	public String getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(String horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataVisita == null) ? 0 : dataVisita.hashCode());
		result = prime * result + ((flagDiaUtil == null) ? 0 : flagDiaUtil.hashCode());
		result = prime * result + ((horasTrabalhadas == null) ? 0 : horasTrabalhadas.hashCode());
		result = prime * result + ((horasTrabalhadasDia == null) ? 0 : horasTrabalhadasDia.hashCode());
		result = prime * result + ((idPesquisador == null) ? 0 : idPesquisador.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroLojasRecusadas == null) ? 0 : numeroLojasRecusadas.hashCode());
		result = prime * result + ((numeroLojasVisitadas == null) ? 0 : numeroLojasVisitadas.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + ((totalDiasUteis == null) ? 0 : totalDiasUteis.hashCode());
		result = prime * result + ((totalLojasVisitar == null) ? 0 : totalLojasVisitar.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetaView other = (MetaView) obj;
		if (dataVisita == null) {
			if (other.dataVisita != null)
				return false;
		} else if (!dataVisita.equals(other.dataVisita))
			return false;
		if (flagDiaUtil == null) {
			if (other.flagDiaUtil != null)
				return false;
		} else if (!flagDiaUtil.equals(other.flagDiaUtil))
			return false;
		if (horasTrabalhadas == null) {
			if (other.horasTrabalhadas != null)
				return false;
		} else if (!horasTrabalhadas.equals(other.horasTrabalhadas))
			return false;
		if (horasTrabalhadasDia == null) {
			if (other.horasTrabalhadasDia != null)
				return false;
		} else if (!horasTrabalhadasDia.equals(other.horasTrabalhadasDia))
			return false;
		if (idPesquisador == null) {
			if (other.idPesquisador != null)
				return false;
		} else if (!idPesquisador.equals(other.idPesquisador))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroLojasRecusadas == null) {
			if (other.numeroLojasRecusadas != null)
				return false;
		} else if (!numeroLojasRecusadas.equals(other.numeroLojasRecusadas))
			return false;
		if (numeroLojasVisitadas == null) {
			if (other.numeroLojasVisitadas != null)
				return false;
		} else if (!numeroLojasVisitadas.equals(other.numeroLojasVisitadas))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		if (totalDiasUteis == null) {
			if (other.totalDiasUteis != null)
				return false;
		} else if (!totalDiasUteis.equals(other.totalDiasUteis))
			return false;
		if (totalLojasVisitar == null) {
			if (other.totalLojasVisitar != null)
				return false;
		} else if (!totalLojasVisitar.equals(other.totalLojasVisitar))
			return false;
		return true;
	}
	
}
