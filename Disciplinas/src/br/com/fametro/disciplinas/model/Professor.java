package br.com.fametro.disciplinas.model;

import java.util.List;

public class Professor extends Usuario {

	public Professor(String senha, String nome, String email, String matricula, int id, String formacao) {
		super(senha, nome, email, matricula, id);
		setFormacao(formacao);
	}

	private List<Disciplina> disciplina;
	private String formacao;

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

}
