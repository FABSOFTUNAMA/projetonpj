package br.unama.fabsoft.connection;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestConnectionFactory {

	@Test
	public void testConectonFactory() throws SQLException {
		
		ConnectionFactory con = new ConnectionFactory();
		con.setUrl("jdbc:postgresql://179.188.16.128:5432/npjunama");
		con.setUser("npjunama");
		con.setPass("Adoni@s260lac@");
		con.setForName("org.postgresql.Driver");
		
		Connection conexao = con.getConnection();
		assertEquals(true, conexao.isValid(0));
		conexao.close();
		assertEquals(false, conexao.isValid(0));	
	}
	

	@Test(expected = RuntimeException.class)
	public void testConectonFactoryFalhaConexao() throws SQLException {
		
		ConnectionFactory con = new ConnectionFactory();
		con.setUrl("jdbc:postgresql://179.188.16.182:5432/npjunama");
		con.setUser("npjunama");
		con.setPass("Adoni@s260lac@");
		con.setForName("org.postgresql.Driver");
		
		Connection conexao = con.getConnection();
	}
	
	
	@Test(expected = RuntimeException.class)
	public void testConectonFactoryFalhaDrive() throws ClassNotFoundException {
		
		ConnectionFactory con = new ConnectionFactory();
		con.setUrl("jdbc:postgresql://179.188.16.128:5432/npjunama");
		con.setUser("npjunama");
		con.setPass("Adoni@s260lac@");
		con.setForName("org.postgresql.Drivers");
		
		Connection conexao = con.getConnection();
	}
}
