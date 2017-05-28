package br.com.fametro.disciplinas.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.taglibs.standard.lang.jstl.BooleanLiteral;

import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.TurmaJaExiste;
import br.com.fametro.disciplinas.model.Turma;

/**
 * Servlet implementation class ControleFuncionario
 */
@WebServlet("/ControleAluno")
public class ControleAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleAluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (controleRedirect(request) == true) {
			response.sendRedirect("./CadastrarAluno.jsp");
		} else {
			response.sendRedirect("./pesquisarAluno.jsp");
		}
	}

	private boolean controleRedirect(HttpServletRequest request) {
		if (request.getParameter("novo") != null) {
			Boolean botaoNovo = true;
			return botaoNovo;
		}
		boolean botaoLimpar = false;
		return botaoLimpar;

	}

}
