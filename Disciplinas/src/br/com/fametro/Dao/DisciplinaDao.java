package br.com.fametro.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import br.com.fametro.disciplinas.exception.DisciplinaJaExiste;
import br.com.fametro.disciplinas.exception.FalhaNoSistema;
import br.com.fametro.disciplinas.exception.UsuarioJaExiste;
import br.com.fametro.disciplinas.model.Disciplina;

public class DisciplinaDao extends RegistrarJDBCAdapter {

	public DisciplinaDao(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

	public void addDisciplina(Disciplina disciplina) throws DisciplinaJaExiste, FalhaNoSistema {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			String sqlInsert = "INSERT INTO TB_DISCIPLINA (DISCIPLINA_NOME, DISCIPLINA_CARGA_HORARIA,DISCIPLINA_EMENTA ) VALUES(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sqlInsert);

			try {
				insert.setString(1, disciplina.getNomeDisciplina());
				insert.setInt(2, disciplina.getCargaHoraria());
				insert.setString(3, disciplina.getEmenta());
				insert.execute();
				insert.close();

			} catch (SQLException e) {
				e.printStackTrace();
				throw new DisciplinaJaExiste(disciplina.getNomeDisciplina());
			}

		} catch (SQLException eOuter) {
			eOuter.printStackTrace();
			throw new FalhaNoSistema();
		}

	}

}
