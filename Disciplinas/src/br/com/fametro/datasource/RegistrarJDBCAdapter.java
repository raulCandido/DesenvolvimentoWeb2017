package br.com.fametro.datasource;

import javax.sql.DataSource;

public class RegistrarJDBCAdapter {
	 
	public DataSource dataSource;

	public RegistrarJDBCAdapter( DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
