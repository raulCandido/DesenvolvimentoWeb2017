package br.com.fametro.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import br.com.fametro.disciplinas.exception.AlunoJaExiste;
import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.UsuarioJaExiste;
import br.com.fametro.disciplinas.model.Aluno;

public class AlunoDao extends RegistrarJDBCAdapter {

	public AlunoDao(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

	public void addAluno(Aluno aluno) throws AlunoJaExiste, FalhaNoSistema {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			
			
			String sqlInsert = "INSERT INTO TB_USUARIO(USUARIO_NOME, USUARIO_EMAIL, USUARIO_MATRICULA, USUARIO_SENHA, USUARIO_PERIODO) VALUES(?,?,?,?,?)";

			PreparedStatement insert = connection.prepareStatement(sqlInsert);

			try {
				insert.setString(1, aluno.getNome());
				insert.setString(2, aluno.getEmail());
				insert.setString(3, aluno.getMatricula());
				insert.setString(4, aluno.getSenha());
				insert.setString(5, aluno.getPeriodo());
				insert.execute();
				insert.close();

			} catch (SQLException e) {
				e.printStackTrace();
				throw new AlunoJaExiste(aluno.getMatricula());
			}

		} catch (SQLException eOuter) {
			eOuter.printStackTrace();
			throw new FalhaNoSistema();
		}
	}

}
