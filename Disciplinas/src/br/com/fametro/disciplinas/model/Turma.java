package br.com.fametro.disciplinas.model;

public class Turma {

	private int id;
	private int Disciplina;
	private int Ano;
	private int Semestre;
	private int Professor;
	private String DaSemana;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDisciplina() {
		return Disciplina;
	}
	public void setDisciplina(int disciplina) {
		Disciplina = disciplina;
	}
	public int getAno() {
		return Ano;
	}
	public void setAno(int ano) {
		Ano = ano;
	}
	public int getSemestre() {
		return Semestre;
	}
	public void setSemestre(int semestre) {
		Semestre = semestre;
	}
	public int getProfessor() {
		return Professor;
	}
	public void setProfessor(int professor) {
		Professor = professor;
	}
	public String getDaSemana() {
		return DaSemana;
	}
	public void setDaSemana(String daSemana) {
		DaSemana = daSemana;
	}
	
	
}
