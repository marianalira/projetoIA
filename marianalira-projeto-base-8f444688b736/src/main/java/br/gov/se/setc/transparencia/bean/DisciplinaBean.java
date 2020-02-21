package br.gov.se.setc.transparencia.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.persistence.dao.mongodb.DisciplinaDAO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.DisciplinaTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.HorarioTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.ProfessorTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.TurmaTO;

@SuppressWarnings("deprecation")
@ManagedBean(name = "disciplinaBean")
public class DisciplinaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String codigo;
	private short carga;
	private Boolean lab;
	private DisciplinaTO disciplina;
	
	@PostConstruct
	public void init() {
		System.out.println("init disciplina");

	}
	
	public void saveDisciplina() {
		System.out.println("saveDisciplina");
		disciplina = new DisciplinaTO();
		disciplina.setCargaHoraria(carga);
		disciplina.setCodigo(codigo);
		disciplina.setNome(nome);
		disciplina.setPrecisaLaboratorio(lab);
		System.out.println("Disciplina a ser adicionada: "+ disciplina.getNome() +" "+ disciplina.getCodigo() +" "+ disciplina.getCargaHoraria());
		DisciplinaDAO.getInstance().inserirDisciplina(disciplina);
		codigo = null;
		carga = (short) 0.0;
		nome = null;
		disciplina = null;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public short getCarga() {
		return carga;
	}
	public void setCarga(short carga) {
		this.carga = carga;
	}
	public Boolean getLab() {
		return lab;
	}
	public void setLab(Boolean lab) {
		this.lab = lab;
	}
	
	
	

}
