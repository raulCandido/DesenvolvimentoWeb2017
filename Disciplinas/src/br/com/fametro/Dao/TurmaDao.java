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
import br.com.fametro.disciplinas.exception.TurmaJaExiste;
import br.com.fametro.disciplinas.model.Turma;

public class TurmaDao extends RegistrarJDBCAdapter {
	private String sqlInsert;
	private String sqlSelect;
	private List<Turma> listaTurma = new ArrayList<>();

	public TurmaDao(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

	public void addTurma(Turma turma) throws TurmaJaExiste, FalhaNoSistema {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();

			sqlInsert = "INSERT INTO TB_TURMA(TURMA_ANO, TURMA_SEMESTRE, TURMA_OBSERVACAO, TURMA_DIA_SEMANA) VALUES(?,?,?,?)";

			PreparedStatement insert = connection.prepareStatement(sqlInsert);

			try {
				insert.setInt(1, turma.getAno());
				insert.setInt(2, turma.getSemestre());
				insert.setString(3, turma.getObersevacao());
				insert.setString(4, turma.getDiaDaSemana());
				insert.execute();
				insert.close();

			} catch (SQLException e) {
				e.printStackTrace();
				throw new TurmaJaExiste(turma.getId());
			}

		} catch (SQLException eOuter) {
			eOuter.printStackTrace();
			throw new FalhaNoSistema();
		}

	}

	public List<Turma> ResultSetlistaTurma() {
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			sqlSelect = "SELECT * FROM TB_TURMA";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlSelect);
			while (resultSet.next()) {
				int turmaId = Integer.parseInt(resultSet.getString("TURMA_ID"));
				String turmaObservacao = resultSet.getString("TURMA_OBSERVACAO");
				String diaDaSemana = resultSet.getString("TURMA_DIA_SEMANA");
				listaTurma.add(new Turma(turmaId, turmaObservacao, diaDaSemana));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaTurma;
	}

	public List<Turma> getListaTurma() {
		return listaTurma;
	}

	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}

}
