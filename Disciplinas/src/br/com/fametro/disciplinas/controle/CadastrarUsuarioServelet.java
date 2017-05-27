package br.com.fametro.disciplinas.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fametro.datasource.UsuarioDAO;
import br.com.fametro.disciplina.util.GeradorId;
import br.com.fametro.disciplinas.model.Usuario;

/**
 * Servlet implementation class CadastrarUsuarioServelet
 */
@WebServlet("/CadastrarUsuarioServelet")
public class CadastrarUsuarioServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuarioServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario	usuario = criarUsuario(request);
		if(!isvalido(usuario)){
			getServletContext().setAttribute("msg", "Obrigatorio preencher todos os campos");
			getServletContext().getRequestDispatcher("/CadastrarUsuario.jsp").forward(request, response);
		}else{
			try {
				UsuarioDAO usuarioDAO;
				usuarioDAO.addUsuario(usuario);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	private Usuario criarUsuario( HttpServletRequest request){
		Usuario usuario = null;
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String matricula = request.getParameter("matricula");
		usuario = new Usuario(senha, nome, email, matricula, GeradorId.gerarId());
		return usuario;		
	}
	private boolean isvalido(Usuario usuario){
		boolean erro = true;
		if(usuario.getNome()==""||usuario.getNome()==null||usuario.getSenha()==""||usuario.getSenha()==null||usuario.getEmail()==""||usuario.getEmail()==null || usuario.getMatricula()==""||usuario.getMatricula()==null){
			erro = false;
			return erro;
		}
		return erro;
		}
		
	}


