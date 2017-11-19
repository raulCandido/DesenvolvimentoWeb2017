package br.com.fametro.disciplinas.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import br.com.fametro.Dao.UsuarioDAO;
import br.com.fametro.disciplinas.model.Usuario;

@WebServlet("/ListarUsuario")
public class ListarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/RegistrarDB")
	public DataSource dataSource;
	private List<Usuario> listaUsuario = new ArrayList<>();
	private UsuarioDAO usuarioDAO;

	public ListarUsuario() {
	}

	@Override
	public void init() throws ServletException {
		usuarioDAO = new UsuarioDAO(dataSource);
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
			throws IOException, ServletException {
		if (validarTipoConsulta(request) != null) {
			if (!listaUsuario.isEmpty()) {
				listaUsuario.clear();
			}
			listaUsuario = usuarioPegarEspecifico(Integer.parseInt(request.getParameter("codUsuario")));
			request.setAttribute("listaUsuario", listaUsuario);
			getServletContext().getRequestDispatcher("/pesquisarUsuario.jsp").forward(request, response);
		} else {
			if (!listaUsuario.isEmpty()) {
				listaUsuario.clear();
			}
			listaUsuario = usuarioPegarCompleto();
			request.setAttribute("listaUsuario", listaUsuario);
			getServletContext().getRequestDispatcher("/pesquisarUsuario.jsp").forward(request, response);
		}
	}

	private List<Usuario> usuarioPegarCompleto() {
		List<Usuario> listaUsuarioRetorno = usuarioDAO.ResultSetlistaUsuarioCompleto();
		return listaUsuarioRetorno;
	}

	private List<Usuario> usuarioPegarEspecifico(Integer codigoUsuario) {
		return usuarioDAO.ResultSetPegarUsuarioEspecificoPorCodigo(codigoUsuario);
	}

	private String validarTipoConsulta(HttpServletRequest request) {
		String codigoUsuario = request.getParameter("codUsuario");
		if (codigoUsuario.equals(null) || codigoUsuario.equals("")) {
			return null;
		}
		return codigoUsuario;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

}
