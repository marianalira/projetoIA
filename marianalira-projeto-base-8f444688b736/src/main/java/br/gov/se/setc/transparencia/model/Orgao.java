package br.gov.se.setc.transparencia.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ORI_ORGAO_IGESP")
public class Orgao implements Serializable{

	/**
	 * 	Class Orgao - IGESP
	 */
	private static final long serialVersionUID = 1L;
	private String codOrgao;
	private String sgOrgao;
	private String dsOrgao;
	private String tipoAdministracao;
	private String nrCNPJ;
	private String dsNaturezaOrgao;
	private Date dtInicioVigencia;
	private Date dtFimVigencia;
	private Integer cdPoder;
	private Integer cdNaturezaOrgao;
	private String cdOrgaoSupervisor;
	private Integer tpAdministracao;
	
	@Id
	@Column(name="ORI_CDORGAO", unique = true, length = 200, nullable = false)
	public String getCodOrgao() {
		return codOrgao;
	}
	public void setCodOrgao(String codOrgao) {
		this.codOrgao = codOrgao;
	}
	
	@Column(name="ORI_SGORGAO", unique = true, length = 200, nullable = false)
	public String getSgOrgao() {
		return sgOrgao;
	}
	public void setSgOrgao(String sgOrgao) {
		this.sgOrgao = sgOrgao;
	}
	
	@Column(name="ORI_DSORGAO", length = 200, nullable = false)
	public String getDsOrgao() {
		return dsOrgao;
	}
	public void setDsOrgao(String dsOrgao) {
		this.dsOrgao = dsOrgao;
	}
	
	@Column(name="ORI_DSTIPOADMINISTRACAO", length = 200, nullable = false)
	public String getTipoAdministracao() {
		return tipoAdministracao;
	}
	public void setTipoAdministracao(String tipoAdministracao) {
		this.tipoAdministracao = tipoAdministracao;
	}
	
	@Column(name="ORI_NRCNPJ", length = 200, nullable = false)
	public String getNrCNPJ() {
		return nrCNPJ;
	}
	public void setNrCNPJ(String nrCNPJ) {
		this.nrCNPJ = nrCNPJ;
	}
	
	@Column(name="ORI_DSNATUREZAORGAO", length = 200, nullable = false)
	public String getDsNaturezaOrgao() {
		return dsNaturezaOrgao;
	}
	public void setDsNaturezaOrgao(String dsNaturezaOrgao) {
		this.dsNaturezaOrgao = dsNaturezaOrgao;
	}
	
	@Column(name="ORI_DTINICIOVIGENCIA", length = 200, nullable = false)
	public Date getDtInicioVigencia() {
		return dtInicioVigencia;
	}
	public void setDtInicioVigencia(Date dtInicioVigencia) {
		this.dtInicioVigencia = dtInicioVigencia;
	}
	
	@Column(name="ORI_DTFIMVIGENCIA", length = 200, nullable = false)
	public Date getDtFimVigencia() {
		return dtFimVigencia;
	}
	public void setDtFimVigencia(Date dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}
	
	@Column(name="PDE_CDPODER", length = 200, nullable = false)
	public Integer getCdPoder() {
		return cdPoder;
	}
	public void setCdPoder(Integer cdPoder) {
		this.cdPoder = cdPoder;
	}
	
	@Column(name="ORI_CDNATUREZAORGAO", length = 200, nullable = false)
	public Integer getCdNaturezaOrgao() {
		return cdNaturezaOrgao;
	}
	public void setCdNaturezaOrgao(Integer cdNaturezaOrgao) {
		this.cdNaturezaOrgao = cdNaturezaOrgao;
	}
	
	@Column(name="ORI_CDORGAOSUPERVISOR", length = 200, nullable = false)
	public String getCdOrgaoSupervisor() {
		return cdOrgaoSupervisor;
	}
	public void setCdOrgaoSupervisor(String cdOrgaoSupervisor) {
		this.cdOrgaoSupervisor = cdOrgaoSupervisor;
	}
	
	@Column(name="ORI_TPADMINISTRACAO", length = 200, nullable = false)
	public Integer getTpAdministracao() {
		return tpAdministracao;
	}
	public void setTpAdministracao(Integer tpAdministracao) {
		this.tpAdministracao = tpAdministracao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOrgao == null) ? 0 : codOrgao.hashCode());
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
		Orgao other = (Orgao) obj;
		if (codOrgao == null) {
			if (other.codOrgao != null)
				return false;
		} else if (!codOrgao.equals(other.codOrgao))
			return false;
		return true;
	}
	
	
	

}
