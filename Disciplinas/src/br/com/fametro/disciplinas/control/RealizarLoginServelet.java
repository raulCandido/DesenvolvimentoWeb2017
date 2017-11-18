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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		Integer matricula = Integer.parseInt(request.getParameter("matricula"));
		String senha = request.getParameter("senha");
		if (matricula == null && senha.equals(null) || senha.equals("")) {
			try {
				// nunca vai chegar aqui html nao deixa//desencargo de
				// consciencia
				response.sendRedirect("./index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Usuario usuarioValidado = validarLogin(matricula, senha);
			if (usuarioValidado != null) {
				try {
					response.sendRedirect("./menu.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					getServletContext().setAttribute("msg", "Usuario nao cadastrado");
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private Usuario validarLogin(Integer matricula, String senha) {
		Usuario usuarioValidado = usuarioDAO.ResultSetPegarUsuarioEspecifico(new Usuario(matricula, senha));
		if (usuarioValidado == null) {
			return null;
		} else {
			return usuarioValidado;
		}
	}
}
