package br.com.fametro.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.FuncionarioJaExiste;
import br.com.fametro.disciplinas.model.Funcionario;

public class FuncionarioDao extends RegistrarJDBCAdapter {

	private String selectTodos = "SELECT * FROM TB_USUARIO";
	private String sqlInsert = "INSERT INTO TB_USUARIO(USUARIO_NOME, USUARIO_EMAIL, USUARIO_MATRICULA, USUARIO_SENHA, USUARIO_CARGO, USURUARIO_FUNCIONARIO) VALUES(?,?,?,?,?,?)";

	public FuncionarioDao(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

	public void addFuncionario(Funcionario funcionario) throws FuncionarioJaExiste, FalhaNoSistema {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();

			PreparedStatement insert = connection.prepareStatement(sqlInsert);

			try {
				insert.setString(1, funcionario.getNome());
				insert.setString(2, funcionario.getEmail());
				insert.setInt(3, funcionario.getMatricula());
				insert.setString(4, funcionario.getSenha());
				insert.setString(5, funcionario.getCargo());
				insert.setBoolean(6, true);
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

	public List<Funcionario> ResultSetlistaFuncionario() {
		Connection connection = null;
		List<Funcionario> listaFuncionario = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectTodos);
			while (resultSet.next()) {
				Funcionario funcionario = new Funcionario(resultSet.getString("USUARIO_NOME"));
				listaFuncionario.add(funcionario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaFuncionario;
		
	}

}
