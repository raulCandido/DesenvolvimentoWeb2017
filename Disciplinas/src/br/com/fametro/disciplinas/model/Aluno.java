package br.com.fametro.disciplinas.model;

public class Aluno extends Usuario {

	public Aluno(String senha, String nome, String email, String matricula, int id) {
		super(senha, nome, email, matricula, id);
		// TODO Auto-generated constructor stub
	}

	private String periodo;
	private String turma;

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

}
