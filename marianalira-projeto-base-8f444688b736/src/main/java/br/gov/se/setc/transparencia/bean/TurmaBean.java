package br.gov.se.setc.transparencia.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.persistence.dao.mongodb.DisciplinaDAO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.persistence.dao.mongodb.ProfessorDAO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.DisciplinaTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.HorarioTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.ProfessorTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.TurmaTO;

import java.util.List;

@SessionScoped
@ManagedBean(name = "turmaBean")
public class TurmaBean implements Serializable  {

	private List<ProfessorTO> listProfessor;
	private List<DisciplinaTO> listDisciplina;
	private List<HorarioTO> listHorariosEscolhidos;
	private List<TurmaTO> listTurma; 
	
	private String horario;
	private TurmaTO turma;
	private String professor;
	private String disciplina;
	private String codigodaTurma;
	private LinkedHashMap<String, HorarioTO> horariosAulas;
	
	
	@PostConstruct
	public void init(){
		listProfessor = ProfessorDAO.getInstance().getProfessores();
		listDisciplina = DisciplinaDAO.getInstance().getDisciplinas();
		listTurma = new ArrayList<TurmaTO>();
		listHorariosEscolhidos = new ArrayList<HorarioTO>();
		
	}
	
	public void saveTurma() {
		TurmaTO turma = new TurmaTO();
		LinkedHashMap<String, HorarioTO> horariosAulas = new LinkedHashMap<String, HorarioTO>();
		turma.setHorariosAulas(horariosAulas);
		
		DisciplinaTO disciplina = DisciplinaDAO.getInstance().getDisciplina(this.disciplina);
		ProfessorTO professor = ProfessorDAO.getInstance().getProfessor(this.professor);
		turma.setCodTurma(codigodaTurma);
		turma.setDisciplina(disciplina);
		turma.setProfessor(professor);
		
		for (HorarioTO hora: listHorariosEscolhidos) {
			turma.getHorariosAulas().put(hora.getCodigo(), hora);
		}
		
		listTurma.add(turma);
		System.out.println("Tamanho da lista de turmas: " +listTurma.size());
		listHorariosEscolhidos.clear();
		this.disciplina = null;
		this.horario = null;
		this.professor = null;
		this.codigodaTurma = null;
	}
	
	public void addHorario() {
		System.out.println("------------------------Horário Adicionado--------------------------");
		if (this.horario.equals("null")) {
			this.horario = null;
		}
		else {
		HorarioTO horario = HorarioTO.fromCodigo(this.horario);
		System.out.println(horario.getCodigo() +" "+ horario.getDia());
		listHorariosEscolhidos.add(horario);
		System.out.println("Tamanho da lista de horarios: " +listHorariosEscolhidos.size());
		this.horario = null;
		}
	}
	
	public List<ProfessorTO> getListProfessor() {
		return listProfessor;
	}
	public void setListProfessor(List<ProfessorTO> listProfessor) {
		this.listProfessor = listProfessor;
	}
	public List<DisciplinaTO> getListDisciplina() {
		return listDisciplina;
	}
	public void setListDisciplina(List<DisciplinaTO> listDisciplina) {
		this.listDisciplina = listDisciplina;
	}
	
	public TurmaTO getTurma() {
		return turma;
	}

	public void setTurma(TurmaTO turma) {
		this.turma = turma;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getCodigodaTurma() {
		return codigodaTurma;
	}
	public void setCodigodaTurma(String codigodaTurma) {
		this.codigodaTurma = codigodaTurma;
	}

	public List<HorarioTO> getListHorariosEscolhidos() {
		return listHorariosEscolhidos;
	}

	public void setListHorariosEscolhidos(List<HorarioTO> listHorariosEscolhidos) {
		this.listHorariosEscolhidos = listHorariosEscolhidos;
	}

	public LinkedHashMap<String, HorarioTO> getHorariosAulas() {
		return horariosAulas;
	}

	public void setHorariosAulas(LinkedHashMap<String, HorarioTO> horariosAulas) {
		this.horariosAulas = horariosAulas;
	}

	/**
	 * @return the listTurma
	 */
	public List<TurmaTO> getListTurma() {
		return listTurma;
	}

	/**
	 * @param listTurma the listTurma to set
	 */
	public void setListTurma(List<TurmaTO> listTurma) {
		this.listTurma = listTurma;
	}

	
}
