package br.com.fametro.disciplinas.model;

public class Funcionario extends Usuario {

	public Funcionario(String senha, String nome, String email, String matricula, int id) {
		super(senha, nome, email, matricula, id);
		// TODO Auto-generated constructor stub
	}

	private String cargo;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
