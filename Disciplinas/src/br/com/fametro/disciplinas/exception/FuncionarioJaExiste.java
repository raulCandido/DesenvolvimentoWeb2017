package br.com.fametro.disciplinas.exception;

public class FuncionarioJaExiste extends Exception {

	public FuncionarioJaExiste( String identificador) {
		super("Funcionario com esse identificar: "+identificador+" ja existe");
	}
	public FuncionarioJaExiste(int id) {
		super("Funcionario com esse id: "+id+" ja cadastrado");
	}

}
