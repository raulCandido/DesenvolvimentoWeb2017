package br.com.fametro.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import br.com.fametro.disciplinas.exception.AlunoJaExiste;
import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.FuncionarioJaExiste;
import br.com.fametro.disciplinas.model.Funcionario;
import br.com.fametro.disciplinas.model.Professor;

public class FuncionarioDao extends RegistrarJDBCAdapter {

	public FuncionarioDao(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

	public void addFuncionario(Funcionario funcionario) throws FuncionarioJaExiste, FalhaNoSistema {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			
			
			String sqlInsert = "INSERT INTO TB_USUARIO(USUARIO_NOME, USUARIO_EMAIL, USUARIO_MATRICULA, USUARIO_SENHA, USUARIO_CARGO) VALUES(?,?,?,?,?)";

			PreparedStatement insert = connection.prepareStatement(sqlInsert);

			try {
				insert.setString(1, funcionario.getNome());
				insert.setString(2, funcionario.getEmail());
				insert.setString(3, funcionario.getMatricula());
				insert.setString(4, funcionario.getSenha());
				insert.setString(5, funcionario.getCargo());
				insert.execute();
				insert.close();

			} catch (SQLException e) {
				e.printStackTrace();
				throw new FuncionarioJaExiste(funcionario.getMatricula());
			}

		} catch (SQLException eOuter) {
			eOuter.printStackTrace();
			throw new FalhaNoSistema();
		}
		
	}
	

}
