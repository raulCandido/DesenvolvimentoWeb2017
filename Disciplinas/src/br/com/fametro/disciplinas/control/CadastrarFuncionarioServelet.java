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

import br.com.fametro.Dao.FuncionarioDao;
import br.com.fametro.Dao.ProfessorDao;
import br.com.fametro.disciplina.util.GeradorId;
import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.FuncionarioJaExiste;
import br.com.fametro.disciplinas.exception.ProfessorJaExiste;
import br.com.fametro.disciplinas.model.Funcionario;
import br.com.fametro.disciplinas.model.Funcionario;

/**
 * Servlet implementation class CadastrarFuncionario
 */
@WebServlet("/CadastrarFuncionarioServelet")
public class CadastrarFuncionarioServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/RegistrarDB")
	public DataSource dataSource;
	private FuncionarioDao funcionarioDao;

	@Override
	public void init() throws ServletException {
		funcionarioDao = new FuncionarioDao(dataSource);
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
		Funcionario funcionario = criarFuncionario(req);
		if (!isvalido(funcionario)) {
			getServletContext().setAttribute("msg", "Obrigatorio preencher todos os campos");
			getServletContext().getRequestDispatcher("/CadastrarAluno.jsp").forward(req, resp);
		} else {
			try {
				funcionarioDao.addFuncionario(funcionario);
				getServletContext().setAttribute("msg", "Registro Salvo com sucesso");
				getServletContext().getRequestDispatcher("/CadastrarProfessor.jsp").forward(req, resp);
			} catch (FalhaNoSistema e) {
				getServletContext().setAttribute("msg", e.getMessage());
				getServletContext().getRequestDispatcher("/CadastrarProfessor.jsp").forward(req, resp);
			} catch (FuncionarioJaExiste e) {
				getServletContext().setAttribute("msg", e.getMessage());
				getServletContext().getRequestDispatcher("/CadastrarProfessor.jsp").forward(req, resp);
			}

		}

	}

	private Funcionario criarFuncionario(HttpServletRequest request) {
		Funcionario funcionario = null;
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
//		String matricula = request.getParameter("matricula");
		String cargo = request.getParameter("cargo");
		funcionario = new Funcionario(senha, nome, email, GeradorId.gerarMatricula(), GeradorId.gerarId(), cargo);
		return funcionario;
	}

	private boolean isvalido(Funcionario funcionario) {
		boolean erro = true;
		if (funcionario.getNome() == "" || funcionario.getNome() == null || funcionario.getSenha() == ""
				|| funcionario.getSenha() == null || funcionario.getEmail() == "" || funcionario.getEmail() == null
				|| funcionario.getCargo() == null || funcionario.getCargo() == "") {
			erro = false;
			return erro;
		}
		return erro;
	}

}
