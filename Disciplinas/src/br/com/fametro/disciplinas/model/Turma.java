package br.com.fametro.disciplinas.model;

public class Turma {

	private int id;
	private int Ano;
	private int Semestre;
	private String diaDaSemana;
	private String obersevacao;

	public Turma(int ano, int semestre, String diaDaSemana, String observacao) {
		setAno(ano);
		setSemestre(semestre);
		setDiaDaSemana(diaDaSemana);
		setObersevacao(observacao);
	}

	public Turma() {
	}

	public Turma(int id, String observacao, String diaDaSemana) {
		setId(id);
		setObersevacao(diaDaSemana);
		setDiaDaSemana(diaDaSemana);
	}

	public String getObersevacao() {
		return obersevacao;
	}

	public void setObersevacao(String obersevacao) {
		this.obersevacao = obersevacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAno() {
		return Ano;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
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

}
