package br.com.fametro.disciplinas.exception;

public class UsuarioJaExiste extends Exception {
	/**
	 Raul Candido
	 */
	private static final long serialVersionUID = 4251246721457323622L;
	public UsuarioJaExiste( String identificador) {
		super("usuario de matricula: " +identificador+" ja existe" );
	}
	public UsuarioJaExiste( int id) {
		super("usuario de id: " +id+" ja existe" );
	}
}
