package br.com.fametro.disciplinas.exception;

public class ServerExceptionDaoDisciplina extends RuntimeException{
	
	/**
	 Autor: Raul Candido
	 */
	private static final long serialVersionUID = -4926140778838034206L;

	public ServerExceptionDaoDisciplina(String message){
		super(message);
	}
}
