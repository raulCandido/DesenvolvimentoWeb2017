package br.com.fametro.disciplinas.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fametro.datasoruce.RegistrarJDBCAdapter;
import br.com.fametro.disciplinas.bean.Aluno;
import br.com.fametro.disciplinas.bean.Usuario;
import br.com.fametro.disciplinas.exception.ServerExceptionDaoDisciplina;

public class UsuarioDAO {
	private static final Map<Long, Usuario> USUARIO = new HashMap<>();
	private RegistrarJDBCAdapter registrarJDBCAdapter;
	private final String insertUsuarioSql = "INSERT INTO TB_USUARIO (USUARIO_ID, USUARIO_FKPESSOA, USUARIO_SENHA) VALUE(?,?,?)";

	public UsuarioDAO() {
		gerarUsuario(new Usuario(new Aluno(1, "matricula", "123"), "senha"));
	}

	public void add(Usuario usuario) {
		gerarUsuario(usuario);
	}

	private void gerarUsuario(Usuario usuario) {
		try {
			PreparedStatement insert = registrarJDBCAdapter.preparedStatement(insertUsuarioSql);
			insert.setLong(4, usuario.getId());
			insert.setLong(4, usuario.getPessoa().getId());
			insert.setString(4, usuario.getSenha());
			insert.execute();
			insert.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		long id = USUARIO.size() + 1L;
		usuario.setId(id);
		USUARIO.put(id, usuario);
	}

	public Collection<Usuario> buscaPorNomeSimilar(String nome) {
		// caso nulo retorna todas disciplinas
		if (nome == null) {
			return USUARIO.values();
		}
		// percorrendo lista de disciplinas e retornando lista de disciplina
		// que contenha no parametro
		List<Usuario> listaDeUsuario = new ArrayList<>();
		for (Usuario usuarios : USUARIO.values()) {
			if (usuarios.getPessoa().getNome().toLowerCase().contains(nome.toLowerCase())) {
				listaDeUsuario.add(usuarios);
			}

		}
		return listaDeUsuario;

	}

	public boolean usuarioLogin(String matricula, String senha) throws ServerExceptionDaoDisciplina {
		if (matricula.equalsIgnoreCase("") || matricula == null || senha.equals("") || senha == null) {
			throw new ServerExceptionDaoDisciplina("Preencher campos");
		} else {
			for (Usuario usuarioDaLista : USUARIO.values()) {
				if (usuarioDaLista.getPessoa().getMatricula().equals(matricula)
						&& usuarioDaLista.getSenha().equals(senha)) {
					return true;
				}
			}
			throw new ServerExceptionDaoDisciplina("Usuario nao cadastrado");
		}

	}

}
