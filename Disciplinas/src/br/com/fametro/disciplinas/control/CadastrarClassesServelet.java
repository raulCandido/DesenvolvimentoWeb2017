package br.com.fametro.disciplinas.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CadastrarClasses")
public class CadastrarClassesServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastrarClassesServelet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.append("<html>");
		out.append("	<head><title>Cadastro de Classes</title>");
		out.append("		<link rel='stylesheet' type='text/css' href='estilo.css'>");
		out.append(" 	</head>");
		out.append("	<body>");
		out.append("	<form action='SalvarAluno'>");
		out.append("	<table width=100%>");
		out.append("		<caption>Cadastro de Classes</caption>");
		out.append("		<tr><th colspan=3>Dados Escolares</th></tr>");
		out.append("		<tr>"
				+ "<td><fieldset><legend>Turma</legend><input type='text'></fieldset></td>"
				+ "<td colspan=2><fieldset><legend>Aluno</legend><input type='text'></fieldset></td>"
				+ "</tr>");
		out.append("        <tr><th colspan=3 style='text-align: center;'>"
				+ "<input type='submit' name='Salvar' value='Salvar'>"
				+ "<a href='menu.jsp'><input type='button' value='Voltar'></a></th></tr>");
		out.append("	</table>");
		out.append("	</form>");
		out.append("	</body>");
		out.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
