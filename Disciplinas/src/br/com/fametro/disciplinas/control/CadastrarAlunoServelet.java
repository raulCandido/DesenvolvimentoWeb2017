package br.com.fametro.disciplinas.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import br.com.fametro.Dao.AlunoDao;
import br.com.fametro.disciplina.util.GeradorId;
import br.com.fametro.disciplinas.exception.AlunoJaExiste;
import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.UsuarioJaExiste;
import br.com.fametro.disciplinas.model.Aluno;

@WebServlet("/CadastrarAlunoServelet")
public class CadastrarAlunoServelet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/RegistrarDB")
	public DataSource dataSource;
	private AlunoDao alunoDao;

	@Override
	public void init() throws ServletException {
		alunoDao = new AlunoDao(dataSource);
	}

	public CadastrarAlunoServelet() {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	

	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Aluno aluno = criarAluno(req);
		if (!isvalido(aluno)) {
			getServletContext().setAttribute("msg", "Obrigatorio preencher todos os campos");
			getServletContext().getRequestDispatcher("/CadastrarAluno.jsp").forward(req, resp);
		} else {
			try {
				try {
					alunoDao.addAluno(aluno);
					getServletContext().setAttribute("msg", "Registro Salvo com sucesso");
					getServletContext().getRequestDispatcher("/CadastrarAluno.jsp").forward(req, resp);
				} catch (FalhaNoSistema e) {
					getServletContext().setAttribute("msg", e.getMessage());
					getServletContext().getRequestDispatcher("/CadastrarAluno.jsp").forward(req, resp);
				}
			} catch (AlunoJaExiste e) {
				getServletContext().setAttribute("msg", e.getMessage());
				getServletContext().getRequestDispatcher("/CadastrarAluno.jsp").forward(req, resp);
			}
			
		}

	}

	private Aluno criarAluno(HttpServletRequest request) {
		Aluno aluno = null;
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String matricula = request.getParameter("matricula");
		String periodo = request.getParameter("periodo");
		aluno = new Aluno(senha, nome, email, matricula, GeradorId.gerarId(), periodo);
		return aluno;
	}

	private boolean isvalido(Aluno aluno) {
		boolean erro = true;
		if (aluno.getNome() == "" || aluno.getNome() == null || aluno.getSenha() == "" || aluno.getSenha() == null
				|| aluno.getEmail() == "" || aluno.getEmail() == null || aluno.getMatricula() == ""
				|| aluno.getMatricula() == null || aluno.getPeriodo() == null || aluno.getPeriodo() == "") {
			erro = false;
			return erro;
		}
		return erro;
	}
}
