package br.com.fametro.disciplinas.model;

public class Usuario {

	private int id;
	private String senha;
	private String nome;
	private String email;
	private int matricula;

	public Usuario(int matricula, String senha) {
		setMatricula(matricula);
		setSenha(senha);

	}

	public Usuario(String senha, String nome, String email, int matricula, int id) {
		setNome(nome);
		setEmail(email);
		setMatricula(matricula);
		setSenha(senha);
		setId(id);
	}
	public Usuario(String senha, String nome, String email, int id) {
		setId(id);
		setSenha(senha);
		setNome(nome);
		setEmail(email);
	}

	public Usuario(String nome) {
		setNome(nome);
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
