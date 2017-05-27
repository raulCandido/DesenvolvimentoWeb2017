package br.com.fametro.disciplinas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fametro.Dao.RegistrarJDBCAdapter;
import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.UsuarioJaExiste;

public class Usuario {

	private int id;
	private String senha;
	private String nome;
	private String email;
	private String matricula;
	
	
	
	public Usuario(String senha, String nome, String email, String matricula, int id) {
		setNome(nome);
		setEmail(email);
		setMatricula(matricula);
		setSenha(senha);
		setId(id);
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
