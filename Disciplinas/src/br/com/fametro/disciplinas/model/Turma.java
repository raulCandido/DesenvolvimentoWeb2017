package br.com.fametro.disciplinas.model;

import java.util.List;

public class Turma {

	private int id;
	private int Ano;
	private int Semestre;
	private String diaDaSemana;

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
