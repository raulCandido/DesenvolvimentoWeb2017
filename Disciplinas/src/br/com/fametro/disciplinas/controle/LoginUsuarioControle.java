package br.com.fametro.disciplinas.controle;

import br.com.fametro.disciplinas.dao.UsuarioDAO;
import br.com.fametro.disciplinas.exception.ServerExceptionDaoDisciplina;

public class LoginUsuarioControle {
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	

	public void verificarUsuario(String matricula, String senha) {
		try {
			boolean sucesso = usuarioDAO.usuarioLogin(matricula, senha);
			System.out.println(sucesso);
			
		} catch (ServerExceptionDaoDisciplina e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}