package br.com.fametro.disciplinas.exception;

public class TurmaJaExiste extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TurmaJaExiste(int id) {
		super("Turma de id: "+id+" ja existe");
	}
}
