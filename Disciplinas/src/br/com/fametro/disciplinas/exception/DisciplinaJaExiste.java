package br.com.fametro.disciplinas.exception;

public class DisciplinaJaExiste extends Exception {
	
	/**
	Raul Candido
	 */
	private static final long serialVersionUID = 1L;
	public DisciplinaJaExiste(String identificador) {
		super("Disciplina: " +identificador+" ja existe" );
	}
	public DisciplinaJaExiste(int id) {
		super("Disciplina de ID: "+id+" ja existe");
	}
}
