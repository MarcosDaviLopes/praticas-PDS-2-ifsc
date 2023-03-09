package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CriaBanco {

	public static void main(String[] args) {
		
		Connection conexao;
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" +"?serverTimezone=UTC", "root", "aluno");
			
			
			Statement stm = conexao.createStatement();
			String query = "CREATE DATABASE BancoPDS2;";
			
			int rs =  stm.executeUpdate(query);
			
			query = "CREATE TABLE pessoa(id INT NOT NULL AUTO_INCREMENT,"
					+ "CPF INT NOT NULL, SEXO VARCHAR(45) NOT NULL,"
					+ "PRIMARY KEY(id);";
			stm.executeUpdate(query);
			
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}
}
