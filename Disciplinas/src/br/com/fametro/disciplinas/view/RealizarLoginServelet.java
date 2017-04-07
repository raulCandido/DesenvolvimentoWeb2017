package br.com.fametro.disciplinas.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fametro.disciplinas.controle.LoginUsuarioControle;

/**
 Autor: Raul Candido
 */
@WebServlet(urlPatterns = "/RealizarLoginServelet")
public class RealizarLoginServelet extends HttpServlet {
	private LoginUsuarioControle loginUsuarioControle = new LoginUsuarioControle();
	private static final long serialVersionUID = 1L;
       
   
    public RealizarLoginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loginUsuarioControle.verificarUsuario(request.getParameter("matricula"), request.getParameter("senha"));
	}

}