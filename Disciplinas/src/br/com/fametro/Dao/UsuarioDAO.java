package br.com.fametro.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.UsuarioJaExiste;
import br.com.fametro.disciplinas.model.Usuario;

public class UsuarioDAO extends RegistrarJDBCAdapter {

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

}
