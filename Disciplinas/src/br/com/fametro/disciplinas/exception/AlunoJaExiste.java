package br.com.fametro.disciplinas.exception;

public class AlunoJaExiste extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AlunoJaExiste(String identificador) {
		super("aluno ja cadastrado com esse identificador :"+ identificador);
	}
	public AlunoJaExiste(int id) {
		super("aluno ja cadastrado com esse id: "+ id);
	}
}
