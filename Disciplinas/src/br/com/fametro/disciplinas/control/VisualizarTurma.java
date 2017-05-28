package br.com.fametro.disciplinas.control;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import br.com.fametro.Dao.TurmaDao;
import br.com.fametro.disciplinas.model.Turma;

@WebServlet("/VisualizarTurma")
public class VisualizarTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/RegistrarDB")
	public DataSource dataSource;
	private TurmaDao turmaDao;
	private List<Turma> listaTurma;

	private List<Turma> listaTurmaComParametro;

	@Override
	public void init() throws ServletException {
		turmaDao = new TurmaDao(dataSource);
	}

	public VisualizarTurma() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		request.setAttribute("listaTurma", listaTurma);
		getServletContext().getRequestDispatcher("/pesquisarTurma.jsp").forward(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		tratarConsulta(request);
	}

	private void tratarConsulta(HttpServletRequest request) {
		String codTurma = request.getParameter("codTurma");
		if (codTurma == null || codTurma == "") {
			listaTurma = turmaDao.ResultSetlistaTurma();
		} else {
			setListaTurma(turmaDao.ResultSetlistaTurma());
			for (Turma turma : listaTurma) {
				if (turma.getId() == Integer.parseInt(codTurma)) {
					listaTurmaComParametro.add(turma);
				}
			}
		}
	}

	public List<Turma> getListaTurma() {
		return listaTurma;
	}

	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}

	public List<Turma> getListaTurmaComParametro() {
		return listaTurmaComParametro;
	}

	public void setListaTurmaComParametro(List<Turma> listaTurmaComParametro) {
		this.listaTurmaComParametro = listaTurmaComParametro;
	}

}
