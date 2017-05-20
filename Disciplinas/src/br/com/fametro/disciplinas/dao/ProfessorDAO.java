package br.com.fametro.disciplinas.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fametro.datasoruce.RegistrarJDBCAdapter;
import br.com.fametro.disciplinas.bean.Professor;

public class ProfessorDAO {

	RegistrarJDBCAdapter registrarJDBCAdapter;
	String insertClientSql = "INSERT INTO PROFESSOR (PROFESSOR_ID, NOME, SOBRENOME, SENHA, EMAIL) VALUE(?,?,?,?,?)";

	public void add(Professor professor) {
		try {
			PreparedStatement insert = registrarJDBCAdapter.preparedStatement(insertClientSql);
			insert.setLong(1, professor.getId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
