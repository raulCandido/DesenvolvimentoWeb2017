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

import br.com.fametro.Dao.UsuarioDAO;
import br.com.fametro.disciplinas.model.Turma;
import br.com.fametro.disciplinas.model.Usuario;

/**
 * Servlet implementation class RealizarLoginServelet
 */
@WebServlet("/RealizarLoginServelet")
public class RealizarLoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/RegistrarDB")
	public DataSource dataSource;
	public UsuarioDAO usuarioDAO;

	public RealizarLoginServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		usuarioDAO = new UsuarioDAO(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		tratarConsulta(request);
		
	}

	private boolean tratarConsulta(HttpServletRequest request) {
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		String senha = request.getParameter("senha");
		List<Usuario> listaUsuario = usuarioDAO.ResultSetlistaUsuario();
		for (Usuario usuario : listaUsuario) {
			if (usuario.getMatricula() == matricula && usuario.getSenha().equals(senha)) {
				return true;
			} 
			
		}
		return false;

	}

}
