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

import br.com.fametro.Dao.UsuarioDAO;
import br.com.fametro.disciplina.util.GeradorId;
import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.UsuarioJaExiste;
import br.com.fametro.disciplinas.model.Usuario;

/**
 * Servlet implementation class CadastrarUsuarioServelet
 */
@WebServlet("/CadastrarUsuarioServelet")
public class CadastrarUsuarioServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/RegistrarDB")
	public DataSource dataSource;
	private UsuarioDAO usuarioDAO;

	@Override
	public void init() throws ServletException {
		usuarioDAO = new UsuarioDAO(dataSource);
	}

	public CadastrarUsuarioServelet() {
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
			throws ServletException, IOException {
		Usuario usuario = criarUsuario(request);
		if (!isvalido(usuario)) {
			getServletContext().setAttribute("msg", "Obrigatorio preencher todos os campos");
			getServletContext().getRequestDispatcher("/CadastrarUsuario.jsp").forward(request, response);
		} else {
			try {
				try {
					usuarioDAO.addUsuario(usuario);
					getServletContext().setAttribute("msg", "Cadastro com sucesso");
					getServletContext().getRequestDispatcher("/CadastrarUsuario.jsp").forward(request, response);
				} catch (SQLException e) {
					getServletContext().setAttribute("msg", e.getMessage());
					getServletContext().getRequestDispatcher("/CadastrarUsuario.jsp").forward(request, response);
					e.printStackTrace();
				} catch (FalhaNoSistema e) {
					getServletContext().setAttribute("msg", e.getMessage());
					getServletContext().getRequestDispatcher("/CadastrarUsuario.jsp").forward(request, response);
					e.printStackTrace();
				}
			} catch (UsuarioJaExiste e) {
				getServletContext().setAttribute("msg",e.getMessage());
				getServletContext().getRequestDispatcher("/CadastrarUsuario.jsp").forward(request, response);
			}
		}

	}

	private Usuario criarUsuario(HttpServletRequest request) {
		Usuario usuario = null;
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String matricula = request.getParameter("matricula");
		usuario = new Usuario(senha, nome, email, matricula, GeradorId.gerarId());
		return usuario;
	}

	private boolean isvalido(Usuario usuario) {
		boolean erro = true;
		if (usuario.getNome() == "" || usuario.getNome() == null || usuario.getSenha() == ""
				|| usuario.getSenha() == null || usuario.getEmail() == "" || usuario.getEmail() == null
				|| usuario.getMatricula() == "" || usuario.getMatricula() == null) {
			erro = false;
			return erro;
		}
		return erro;
	}

}
