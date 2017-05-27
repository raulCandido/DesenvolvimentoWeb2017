package br.com.fametro.disciplinas.model;

public class Professor extends Usuario {

	private String ctps;
	private String disciplina;

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

}
