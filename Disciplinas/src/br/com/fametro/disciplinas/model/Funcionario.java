package br.com.fametro.disciplinas.model;

public class Funcionario extends Usuario {

	private String ctps;
	private String cargo;

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
