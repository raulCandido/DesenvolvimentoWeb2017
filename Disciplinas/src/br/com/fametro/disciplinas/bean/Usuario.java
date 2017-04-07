package br.com.fametro.disciplinas.bean;

public class Usuario {
	private Pessoa pessoa;
	private long id;
	private String senha;

	public Usuario(Pessoa pessoa, String senha) {
		this.pessoa = pessoa;
		this.setSenha(senha);
	}

	public Usuario() {
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
