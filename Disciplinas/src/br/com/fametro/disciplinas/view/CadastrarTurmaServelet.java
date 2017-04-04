package br.com.fametro.disciplinas.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CadastrarTurma")
public class CadastrarTurmaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastrarTurmaServelet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.append("<html>");
		out.append("	<head><title>Cadastro de Turmas</title>");
		out.append("		<link rel='stylesheet' type='text/css' href='estilo.css'>");
		out.append(" 	</head>");
		out.append("	<body>");
		out.append("	<form action='SalvarAluno'>");
		out.append("	<table width=100%>");
		out.append("		<caption>Cadastro de Turmas</caption>");
		out.append("		<tr><th colspan=3>Dados da Turma</th></tr>");
		out.append("		<tr>"
				+ "<td colspan=2><fieldset><legend>Descri��o</legend><input type='text' size=80></fieldset></td>"
				+ "</tr>");
		out.append("		<tr><th>Compor Turma</th></tr>");
		out.append("		<tr>"
				+ "<td colspan=3><fieldset><legend>Meterial</legend><input type='text' size=80></fieldset></td>"
				+ "</tr>");
		out.append("		<tr>"
				+ "<td colspan=3><fieldset><legend>Livros</legend><input type='text' size=80></fieldset></td>"
				+ "</tr>");
		out.append("		<tr>"
				+ "<td colspan=3><fieldset><legend>Ementa</legend><input type='text' size=80></fieldset></td>"
				+ "</tr>");
		out.append("        <tr><th colspan=3 style='text-align: center;'>"
				+ "<input type='submit' name='Salvar' value='Salvar'>"
				+ "<a href='menu.jsp'><input type='button' value='Voltar'></a></th></tr>");
		out.append("	</table>");
		out.append("	</form>");
		out.append("	</body>");
		out.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
