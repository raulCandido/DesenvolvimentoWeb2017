package br.com.fametro.disciplinas.controle;

import br.com.fametro.disciplinas.dao.UsuarioDAO;
import br.com.fametro.disciplinas.exception.ServerExceptionDaoDisciplina;

public class LoginUsuarioControle {
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	

	public Boolean verificarUsuario(String matricula, String senha) throws ServerExceptionDaoDisciplina {	
		return usuarioDAO.usuarioLogin(matricula, senha);
		
	}
}