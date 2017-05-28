package br.com.fametro.disciplinas.control;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import br.com.fametro.Dao.TurmaDao;
import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.TurmaJaExiste;
import br.com.fametro.disciplinas.model.Turma;

@WebServlet("/CadastrarTurmaServelet")
public class CadastrarTurmaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/RegistrarDB")
	public DataSource dataSource;
	private TurmaDao turmaDao;

	@Override
	public void init() throws ServletException {
		turmaDao = new TurmaDao(dataSource);
	}

	public CadastrarTurmaServelet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Turma turma = criarTurma(request);
		if (!isvalido(turma)) {
			getServletContext().setAttribute("msg", "Obrigatorio preencher todos os campos");
			getServletContext().getRequestDispatcher("/CadastrarTurma.jsp").forward(request, response);
		} else {
			try {
				try {
					turmaDao.addTurma(turma);
					getServletContext().setAttribute("msg", "Turma cadastrada com sucesso.");
					getServletContext().getRequestDispatcher("/CadastrarTurma.jsp").forward(request, response);
				} catch (FalhaNoSistema e) {
					getServletContext().setAttribute("msg", e.getMessage());
					getServletContext().getRequestDispatcher("/CadastrarTurma.jsp").forward(request, response);
					e.printStackTrace();
				}
			} catch (TurmaJaExiste e) {
				getServletContext().setAttribute("msg", e.getMessage());
				getServletContext().getRequestDispatcher("/CadastrarTurma.jsp").forward(request, response);
			}
		}

	}

	private Turma criarTurma(HttpServletRequest request) {
		Turma turma = null;
		int ano = Integer.parseInt(request.getParameter("ano"));
		int semestre = Integer.parseInt(request.getParameter("semestre"));
		String diaDaSemana = request.getParameter("diaSemana");
		String obeservacao = request.getParameter("observacao");
		turma = new Turma(ano, semestre, diaDaSemana, obeservacao);
		return turma;
	}

	private boolean isvalido(Turma turma) {
		boolean erro = true;
		if (turma.getDiaDaSemana() == null || turma.getDiaDaSemana() == "") {
			erro = false;
			return erro;
		}
		return erro;
	}

}
