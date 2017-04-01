package telas;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CadastrarAluno")
public class CadastrarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastrarAluno() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.append("<html>");
		out.append("	<head><title>Cadastro de Aluno</title>");
		out.append("		<link rel='stylesheet' type='text/css' href='estilo.css'>");
		out.append(" 	</head>");
		out.append("	<body>");
		out.append("	<form action='SalvarAluno'>");
		out.append("	<table width=100%>");
		out.append("		<caption>Cadastro de Usuario</caption>");
		out.append("		<tr><th colspan=3>Dados Escolares</th></tr>");
		out.append("		<tr>"
				+ "<td><fieldset><legend>Matricula</legend><input type='text'></fieldset></td>"
				+ "<td><fieldset><legend>Per�odo</legend><input type='text'></fieldset></td>"
				+ "<td><fieldset><legend>Turma</legend><input type='text'></fieldset></td>"
				+ "</tr>");
		out.append("		<tr><th colspan=3>Dados Pessoais</th></tr>");
		out.append("		<tr>"
				+ "<td colspan=3><fieldset><legend>Nome</legend><input type='text' size=80></fieldset></td>"
				+ "</tr>");
		out.append("		<tr>"
				+ "<td colspan=2><fieldset><legend>Endere�o</legend><input type='text' size=60></fieldset></td>"
				+ "<td><fieldset><legend>Bairro</legend><input type='text'></fieldset></td>"
				+ "</tr>");
		out.append("		<tr>"
				+ "<td><fieldset><legend>Cidade</legend><input type='text'></fieldset></td>"
				+ "<td><fieldset><legend>CEP</legend><input type='text'></fieldset></td>"
				+ "<td><fieldset><legend>UF</legend><input type='text'></fieldset></td>"
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
