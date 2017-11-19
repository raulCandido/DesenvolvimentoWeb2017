package br.com.fametro.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.UsuarioJaExiste;
import br.com.fametro.disciplinas.model.Usuario;

public class UsuarioDAO extends RegistrarJDBCAdapter {

	private List<Usuario> listaUsuario = new ArrayList<>();

	public UsuarioDAO(DataSource dataSource) {
		super(dataSource);
	}

	public void addUsuario(Usuario usuario) throws SQLException, UsuarioJaExiste, FalhaNoSistema {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			String sqlInsert = "INSERT INTO TB_USUARIO (USUARIO_MATRICULA, USUARIO_EMAIL, USUARIO_NOME, USUARIO_SENHA) VALUES(?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sqlInsert);

			try {
				insert.setInt(1, usuario.getMatricula());
				insert.setString(2, usuario.getEmail());
				insert.setString(3, usuario.getNome());
				insert.setString(4, usuario.getSenha());
				insert.execute();
				insert.close();

			} catch (SQLException e) {
				e.printStackTrace();
				throw new UsuarioJaExiste(usuario.getMatricula());
			}

		} catch (SQLException eOuter) {
			eOuter.printStackTrace();
			throw new FalhaNoSistema();
		}
	}

	public List<Usuario> ResultSetlistaUsuario() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			String consultaUsu = "SELECT * FROM TB_USUARIO";
			ResultSet resultSet = statement.executeQuery(consultaUsu);
			while (resultSet.next()) {
				int matricula = resultSet.getInt("USUARIO_MATRICULA");
				String senha = resultSet.getString("USUARIO_SENHA");
				listaUsuario.add(new Usuario(matricula, senha));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaUsuario;
	}

	public List<Usuario> ResultSetlistaUsuarioCompleto() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			String consultaUsu = "SELECT * FROM TB_USUARIO";
			ResultSet resultSet = statement.executeQuery(consultaUsu);
			while (resultSet.next()) {
				int matricula = resultSet.getInt("USUARIO_MATRICULA");
				String senha = resultSet.getString("USUARIO_SENHA");
				String nome = resultSet.getString("USUARIO_NOME");
				String email = resultSet.getString("USUARIO_EMAIL");
				Integer id = resultSet.getInt("USUARIO_ID");
				listaUsuario.add(new Usuario(senha, nome, email, matricula, id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuario;
	}

	public Usuario ResultSetPegarUsuarioEspecifico(Usuario usuario) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			String consultaUsu = "SELECT * FROM TB_USUARIO where USUARIO_MATRICULA = '"+usuario.getMatricula()+"' and USUARIO_SENHA = '"+usuario.getSenha()+"'";
			ResultSet resultSet = statement.executeQuery(consultaUsu);
			if (resultSet != null) {
				while (resultSet.next()) {
					int matricula = resultSet.getInt("USUARIO_MATRICULA");
					String senha = resultSet.getString("USUARIO_SENHA");
					String nome = resultSet.getString("USUARIO_NOME");
					String email = resultSet.getString("USUARIO_EMAIL");
					Integer id = resultSet.getInt("USUARIO_ID");
					return new Usuario(senha, nome, email, matricula, id);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Usuario> ResultSetPegarUsuarioEspecificoPorCodigo(Integer codigoUsuario) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			String consultaUsu = "SELECT * FROM TB_USUARIO where USUARIO_ID = "+codigoUsuario;
			ResultSet resultSet = statement.executeQuery(consultaUsu);
			if (resultSet != null) {
				while (resultSet.next()) {
					int matricula = resultSet.getInt("USUARIO_MATRICULA");
					String senha = resultSet.getString("USUARIO_SENHA");
					String nome = resultSet.getString("USUARIO_NOME");
					String email = resultSet.getString("USUARIO_EMAIL");
					Integer id = resultSet.getInt("USUARIO_ID");
					listaUsuario.add(new Usuario(senha, nome, email, matricula, id));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaUsuario;
	}
}
