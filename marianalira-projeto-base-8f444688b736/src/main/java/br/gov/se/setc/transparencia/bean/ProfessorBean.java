package br.gov.se.setc.transparencia.bean;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.persistence.dao.mongodb.DisciplinaDAO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.persistence.dao.mongodb.ProfessorDAO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.DisciplinaTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.HorarioTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.ProfessorTO;

@SessionScoped
@SuppressWarnings("deprecation")
@ManagedBean(name = "professorBean")
public class ProfessorBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProfessorTO professor;
	private String nome;
	private String codigo;
	private short cargahoraria;
	
	
	private String disciplinaSelecionada;
	private String horarioSelecionado;
	private List<DisciplinaTO> listDisciplina; 
	private List<DisciplinaTO> listDisciplinasEscolhidas;
	private List<HorarioTO> listHorariosEscolhidos;
	
	@PostConstruct
	public void init() {
		listDisciplina = DisciplinaDAO.getInstance().getDisciplinas();
		System.out.println("Quantidade de disciplinas: " + listDisciplina.size());
		
		listDisciplinasEscolhidas = new ArrayList<DisciplinaTO>();
		listHorariosEscolhidos = new ArrayList<HorarioTO>();
		professor = new ProfessorTO();
	}
	
	public void addDisciplina() {
		DisciplinaTO disciplina = DisciplinaDAO.getInstance().getDisciplina(disciplinaSelecionada);
		listDisciplinasEscolhidas.add(disciplina);
		System.out.println("Tamanho da lista de disciplina: " +listDisciplinasEscolhidas.size());
		disciplinaSelecionada = null;
	}
	public void addHorario() {
		HorarioTO horario = HorarioTO.fromCodigo(horarioSelecionado);
		System.out.println("------------------------Horário Adicionado--------------------------");
		System.out.println(horario.getCodigo() +" "+ horario.getDia());
		listHorariosEscolhidos.add(horario);
		System.out.println("Tamanho da lista de horarios: " +listHorariosEscolhidos.size());
		horarioSelecionado = null;
	}
	
	public void saveProfessor() {
		professor.setCargaHorariaSemanal(cargahoraria);
		professor.setMatricula(codigo);
		professor.setPreferencias(listDisciplinasEscolhidas);
		professor.setPreferenciaHorarios(listHorariosEscolhidos);
		ProfessorDAO.getInstance().inserirProfessor(professor);
		professor = null;
		nome = null;
		cargahoraria = (short) 0.0;
		horarioSelecionado = null;
		codigo = null;
		disciplinaSelecionada = null;
		listDisciplinasEscolhidas.clear();
		listHorariosEscolhidos.clear();
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

	public void setCodigo(String código) {
		this.codigo = código;
	}

	

	public List<DisciplinaTO> getListDisciplina() {
		return listDisciplina;
	}

	public void setListDisciplina(List<DisciplinaTO> listDisciplina) {
		this.listDisciplina = listDisciplina;
	}

	public List<DisciplinaTO> getListDisciplinasEscolhidas() {
		return listDisciplinasEscolhidas;
	}

	public void setListDisciplinasEscolhidas(List<DisciplinaTO> listDisciplinasEscolhidas) {
		this.listDisciplinasEscolhidas = listDisciplinasEscolhidas;
	}

	public short getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(short cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

	
	public List<HorarioTO> getListHorariosEscolhidos() {
		return listHorariosEscolhidos;
	}

	public void setListHorariosEscolhidos(List<HorarioTO> listHorariosEscolhidos) {
		this.listHorariosEscolhidos = listHorariosEscolhidos;
	}

	public String getDisciplinaSelecionada() {
		return disciplinaSelecionada;
	}

	public void setDisciplinaSelecionada(String disciplinaSelecionada) {
		this.disciplinaSelecionada = disciplinaSelecionada;
	}

	public String getHorarioSelecionado() {
		return horarioSelecionado;
	}

	public void setHorarioSelecionado(String horarioSelecionado) {
		this.horarioSelecionado = horarioSelecionado;
	}

	public ProfessorTO getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorTO professor) {
		this.professor = professor;
	}
	
	
	

	
}
