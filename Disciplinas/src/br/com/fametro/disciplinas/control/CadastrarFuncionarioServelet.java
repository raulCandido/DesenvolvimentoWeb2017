package br.com.fametro.disciplinas.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import br.com.fametro.Dao.ProfessorDao;
import br.com.fametro.disciplina.util.GeradorId;
import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.ProfessorJaExiste;
import br.com.fametro.disciplinas.model.Professor;

/**
 * Servlet implementation class CadastrarFuncionario
 */
@WebServlet("/CadastrarFuncionario")
public class CadastrarFuncionarioServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/RegistrarDB")
	public DataSource dataSource;
	private ProfessorDao professorDao;

	@Override
	public void init() throws ServletException {
		professorDao = new ProfessorDao(dataSource);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Professor professor = criarProfessor(req);
		if (!isvalido(professor)) {
			getServletContext().setAttribute("msg", "Obrigatorio preencher todos os campos");
			getServletContext().getRequestDispatcher("/CadastrarAluno.jsp").forward(req, resp);
		} else {
			try {
				professorDao.addProfessor(professor);
				getServletContext().setAttribute("msg", "Registro Salvo com sucesso");
				getServletContext().getRequestDispatcher("/CadastrarProfessor.jsp").forward(req, resp);
			} catch (FalhaNoSistema e) {
				getServletContext().setAttribute("msg", e.getMessage());
				getServletContext().getRequestDispatcher("/CadastrarProfessor.jsp").forward(req, resp);
			} catch (ProfessorJaExiste e) {
				getServletContext().setAttribute("msg", e.getMessage());
				getServletContext().getRequestDispatcher("/CadastrarProfessor.jsp").forward(req, resp);
			}

		}

	}

	private Professor criarProfessor(HttpServletRequest request) {
		Professor professor = null;
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String matricula = request.getParameter("matricula");
		String formacao = request.getParameter("formacao");
		professor = new Professor(senha, nome, email, matricula, GeradorId.gerarId(), formacao);
		return professor;
	}

	private boolean isvalido(Professor professor) {
		boolean erro = true;
		if (professor.getNome() == "" || professor.getNome() == null || professor.getSenha() == ""
				|| professor.getSenha() == null || professor.getEmail() == "" || professor.getEmail() == null
				|| professor.getMatricula() == "" || professor.getMatricula() == null || professor.getFormacao() == null
				|| professor.getFormacao() == "") {
			erro = false;
			return erro;
		}
		return erro;
	}

}
