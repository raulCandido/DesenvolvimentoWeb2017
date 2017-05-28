package br.com.fametro.disciplinas.model;

public class Funcionario extends Usuario {

	public Funcionario(String senha, String nome, String email, int matricula, int id, String cargo) {
		super(senha, nome, email, matricula, id);
		setCargo(cargo);
	}
	public Funcionario(String nome) {
		super(nome);
	}

	private String cargo;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
