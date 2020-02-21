package br.gov.se.setc.transparencia.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.OrganizadorIClass;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.organizador.OganizadorIClassBase.CspSolverEnum;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.persistence.dao.mongodb.ProfessorDAO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.GradeTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.HorarioTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.ProblemaOrganizacaoTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.ProblemaOrganizacaoTO.TurnoGrade;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.ProfessorTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.ResultadoOrganizacaoTO;
import br.ufs.dcomp.eduard6.disciplinas.ia.projetos.iclass.to.TurmaTO;

@SessionScoped
@ManagedBean(name = "horarioBean")
public class HorarioBean {
	
	private ProblemaOrganizacaoTO problema;
	private List<ProfessorTO> listProfessorSelecionado;
	private List<ProfessorTO> listProfessor;
	private List<TurmaTO> listTurma;
	private List<TurmaTO> listturmasObrigatorias;
	private List<TurmaTO> listturmasPredefinidas;
	private List<GradeTO> listMelhores;
	private List<Integer> listSolucoes;
	private String cod_turma;
	private String descricao;
	private String professor;
	private Integer solucaoSelecionada;
	private List<HorarioTO> listHorarioGrade;

	
	@PostConstruct
	public void init() {
		listProfessor = ProfessorDAO.getInstance().getProfessores();
		listturmasObrigatorias = new ArrayList<TurmaTO>();
		listturmasPredefinidas = new ArrayList<TurmaTO>();
		listProfessorSelecionado = new ArrayList<ProfessorTO>();
		listTurma = new ArrayList<TurmaTO>();
		problema = new ProblemaOrganizacaoTO();
		listHorarioGrade = new ArrayList<HorarioTO>();
		listMelhores = new ArrayList<GradeTO>();
	}
	
	public String gerarGrade() {
		problema.setDescricao(descricao);
		problema.setProfessores(listProfessorSelecionado);
		problema.setTurmasObrigatorias(listturmasObrigatorias);
		problema.setTurmasPredefinida(listturmasPredefinidas);
		problema.setCargaHorariaGrade(4);
		problema.setTurnoGrade(TurnoGrade.NOITE);
		
		System.out.println("Problema modelado: " + problema.getDescricao()+ " - " +problema.getCargaHorariaGrade());
		
		OrganizadorIClass organizador = new OrganizadorIClass(problema, CspSolverEnum.MIN_CONFLICTS, true);
		
		ResultadoOrganizacaoTO resultado = organizador.organize();
		
		listMelhores = resultado.getMelhoresSolucoesParciais();
		
		System.out.println(resultado.getMelhoresSolucoesParciais().size());
		
		listSolucoes = new ArrayList<Integer>();
		
		for (int i = 1 ; i<resultado.getMelhoresSolucoesParciais().size()+1; i++ ) {
			listSolucoes.add(i);
		}
		
		//listGrade = resultado.getMelhoresSolucoesParciais().get(0).getHorarios();
		
		
		
		return "/Resultado.xhtml";
		
	}
	
	public void mostrar() {
		listHorarioGrade = null;
		listHorarioGrade =  listMelhores.get(solucaoSelecionada).getHorarios();
	}
	
	public void addObrigatoria() {
		listturmasObrigatorias.add(this.searchTurma(cod_turma));
		System.out.println("Tamanho da lista de Turmas Obirgatoria: "+ listturmasObrigatorias.size());
	}
	
	public void addPredefinida() {
		listturmasPredefinidas.add(this.searchTurma(cod_turma));
		System.out.println("Tamanho da lista de Turmas Pre: "+ listturmasPredefinidas.size());
	}
	
	public TurmaTO searchTurma(String cod) {
		for (TurmaTO turma: listTurma) {
			if(turma.getCodTurma().equals(cod)) {
				return turma;
			}
		}
		return null;
	}
	
	public void addProfessor() {
		ProfessorTO professor = ProfessorDAO.getInstance().getProfessor(this.professor);
		listProfessorSelecionado.add(professor);
	}
	
	public ProblemaOrganizacaoTO getProblema() {
		return problema;
	}
	public void setProblema(ProblemaOrganizacaoTO problema) {
		this.problema = problema;
	}
	public List<ProfessorTO> getListProfessorSelecionado() {
		return listProfessorSelecionado;
	}
	public void setListProfessorSelecionado(List<ProfessorTO> listProfessorSelecionado) {
		this.listProfessorSelecionado = listProfessorSelecionado;
	}
	public List<ProfessorTO> getListProfessor() {
		return listProfessor;
	}
	public void setListProfessor(List<ProfessorTO> listProfessor) {
		this.listProfessor = listProfessor;
	}
	public List<TurmaTO> getListturmasObrigatorias() {
		return listturmasObrigatorias;
	}
	public void setListturmasObrigatorias(List<TurmaTO> listturmasObrigatorias) {
		this.listturmasObrigatorias = listturmasObrigatorias;
	}
	public List<TurmaTO> getListturmasPredefinidas() {
		return listturmasPredefinidas;
	}
	public void setListturmasPredefinidas(List<TurmaTO> listturmasPredefinidas) {
		this.listturmasPredefinidas = listturmasPredefinidas;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getCod_turma() {
		return cod_turma;
	}

	public void setCod_turma(String cod_turma) {
		this.cod_turma = cod_turma;
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

	

	/**
	 * @return the listMelhores
	 */
	public List<GradeTO> getListMelhores() {
		return listMelhores;
	}

	/**
	 * @param listMelhores the listMelhores to set
	 */
	public void setListMelhores(List<GradeTO> listMelhores) {
		this.listMelhores = listMelhores;
	}

	public List<Integer> getListSoluçoes() {
		return listSolucoes;
	}

	public void setListSoluçoes(List<Integer> listSoluçoes) {
		this.listSolucoes = listSoluçoes;
	}

	/**
	 * @return the listHorarioGrade
	 */
	public List<HorarioTO> getListHorarioGrade() {
		return listHorarioGrade;
	}

	/**
	 * @param listHorarioGrade the listHorarioGrade to set
	 */
	public void setListHorarioGrade(List<HorarioTO> listHorarioGrade) {
		this.listHorarioGrade = listHorarioGrade;
	}

	public List<Integer> getListSolucoes() {
		return listSolucoes;
	}

	public void setListSolucoes(List<Integer> listSolucoes) {
		this.listSolucoes = listSolucoes;
	}

	public Integer getSolucaoSelecionada() {
		return solucaoSelecionada;
	}

	public void setSolucaoSelecionada(Integer solucaoSelecionada) {
		this.solucaoSelecionada = solucaoSelecionada;
	}

	
	
	
}
