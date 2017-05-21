package br.com.fametro.datasoruce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class RegistrarJDBCAdapter {
	
	private DataSource dataSource;
	private PreparedStatement preparedStatement;
	public RegistrarJDBCAdapter() {
	}
	public RegistrarJDBCAdapter(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Connection connectionDataSource() throws SQLException{
		 return dataSource.getConnection();
	}
	public PreparedStatement preparedStatement(String insert) throws SQLException{
		return preparedStatement = connectionDataSource().prepareStatement(insert);
		
	}
}
