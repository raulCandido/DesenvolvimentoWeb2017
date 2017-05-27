package br.com.fametro.disciplinas.model;

public class Aluno extends Usuario {
	private String periodo;

	public Aluno(String senha, String nome, String email, String matricula, int id, String periodo) {
		super(senha, nome, email, matricula, id);
		setPeriodo(periodo);
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
