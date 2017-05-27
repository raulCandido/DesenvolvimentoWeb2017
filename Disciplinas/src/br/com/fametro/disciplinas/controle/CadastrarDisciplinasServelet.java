package br.com.fametro.disciplinas.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import br.com.fametro.Dao.DisciplinaDao;
import br.com.fametro.Dao.UsuarioDAO;
import br.com.fametro.disciplina.util.GeradorId;
import br.com.fametro.disciplinas.exception.DisciplinaJaExiste;
import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.UsuarioJaExiste;
import br.com.fametro.disciplinas.model.Disciplina;
import br.com.fametro.disciplinas.model.Usuario;

@WebServlet("/CadastrarDisciplinas")
public class CadastrarDisciplinasServelet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/RegistrarDB")
	public DataSource dataSource;
	private DisciplinaDao disciplinaDao;

	@Override
	public void init() throws ServletException {
		disciplinaDao = new DisciplinaDao(dataSource);
	}

	public CadastrarDisciplinasServelet() {
		// TODO Auto-generated constructor stub
	}

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
			throws ServletException, IOException {
		Disciplina disciplina = criarDisciplina(request);
		if (!isvalido(disciplina)) {
			getServletContext().setAttribute("msg", "Obrigatorio preencher todos os campos");
			getServletContext().getRequestDispatcher("/CadastrarUsuario.jsp").forward(request, response);
		} else {
			try {
				try {
					disciplinaDao.addDisciplina(disciplina);
					getServletContext().setAttribute("msg", "Cadastro da disciplina: "+disciplina.getNomeDisciplina()+" efetuado com sucesso");
					getServletContext().getRequestDispatcher("/cadastroDisciplina.jsp").forward(request, response);
				} catch (FalhaNoSistema e) {
					getServletContext().setAttribute("msg", e.getMessage());
					getServletContext().getRequestDispatcher("/cadastroDisciplina.jsp").forward(request, response);
					e.printStackTrace();
				}
			} catch (DisciplinaJaExiste e) {
				getServletContext().setAttribute("msg", e.getMessage());
				getServletContext().getRequestDispatcher("/cadastroDisciplina.jsp").forward(request, response);
			}
		}

	}

	private Disciplina criarDisciplina(HttpServletRequest request) {
		Disciplina disciplina = null;
		String nomeDisciplina = request.getParameter("nomeDisciplina");
		int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
		String ementa = request.getParameter("ementa");
		disciplina = new Disciplina(nomeDisciplina, cargaHoraria, ementa);
		return disciplina;
	}

	private boolean isvalido(Disciplina disciplina) {
		boolean erro = true;
		if (disciplina.getNomeDisciplina() == null || disciplina.getNomeDisciplina() == ""
				|| disciplina.getCargaHoraria() == 0 || disciplina.getEmenta() == null
				|| disciplina.getEmenta() == "") {
			erro = false;
			return erro;
		}
		return erro;
	}

}
