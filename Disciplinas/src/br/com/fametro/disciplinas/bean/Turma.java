package br.com.fametro.disciplinas.bean;

public class Turma {

	private int Id;
	private int Disciplina;
	private int Ano;
	private int Semestre;
	private int Professor;
	private String DaSemana;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
