package br.com.fametro.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.ProfessorJaExiste;
import br.com.fametro.disciplinas.model.Professor;

public class ProfessorDao extends RegistrarJDBCAdapter {

	public ProfessorDao(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

	public void addProfessor(Professor professor) throws FalhaNoSistema, ProfessorJaExiste {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			
			
			String sqlInsert = "INSERT INTO TB_USUARIO(USUARIO_NOME, USUARIO_EMAIL, USUARIO_MATRICULA, USUARIO_SENHA, USUARIO_FORMACAO) VALUES(?,?,?,?,?)";

			PreparedStatement insert = connection.prepareStatement(sqlInsert);

			try {
				insert.setString(1, professor.getNome());
				insert.setString(2, professor.getEmail());
				insert.setString(3, professor.getMatricula());
				insert.setString(4, professor.getSenha());
				insert.setString(5, professor.getFormacao());
				insert.execute();
				insert.close();

			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProfessorJaExiste(professor.getMatricula());
			}

		} catch (SQLException eOuter) {
			eOuter.printStackTrace();
			throw new FalhaNoSistema();
		}
		
	}
	

}
