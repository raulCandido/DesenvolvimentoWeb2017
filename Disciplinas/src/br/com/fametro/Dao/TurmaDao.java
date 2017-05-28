package br.com.fametro.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.TurmaJaExiste;
import br.com.fametro.disciplinas.model.Turma;

public class TurmaDao extends RegistrarJDBCAdapter {

	public TurmaDao(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

	public void addTurma(Turma turma) throws TurmaJaExiste, FalhaNoSistema {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();

			String sqlInsert = "INSERT INTO TB_TURMA(TURMA_ANO, TURMA_SEMESTRE, TURMA_OBSERVACAO, TURMA_DIA_SEMANA) VALUES(?,?,?,?)";

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

}
