package br.com.fametro.disciplinas.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fametro.disciplinas.exception.Erro;

/**
 * Autor: Raul Candido
 */
@WebServlet(urlPatterns = "/RealizarLoginServelet")
public class RealizarLoginServelet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RealizarLoginServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Erro erro = new Erro();
		String matricula = request.getParameter("matricula");
		String senha = request.getParameter("senha");
		if (matricula == null || matricula == "" || senha == null || senha == "") {
			erro.addErro("informacoes nao preenchida");
		}if(!erro.isExisteErro()){
//			if(loginUsuarioControle.validarUsuario(matricula, senha) == true){
//				
//			}
			
		}
		

	}

}
