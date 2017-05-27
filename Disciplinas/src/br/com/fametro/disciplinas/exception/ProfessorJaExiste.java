package br.com.fametro.disciplinas.exception;

public class ProfessorJaExiste extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127826758913446351L;

	public ProfessorJaExiste(String identificador) {
		super("Professor com esse identificador :" + identificador + " ja cadastrado");
	}

	public ProfessorJaExiste(int id) {
		super("Professor com esse id: " + id + " ja cadastrado");
	}
}
