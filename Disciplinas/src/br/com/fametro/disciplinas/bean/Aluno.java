package br.com.fametro.disciplinas.bean;

public class Aluno extends Pessoa {
	
	private String periodo;
	private String turma;
	
	public Aluno(long id, String matricula, String nome) {
		this.setId(id);
		this.setMatricula(matricula);
		this.setNome(nome);
	}

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
