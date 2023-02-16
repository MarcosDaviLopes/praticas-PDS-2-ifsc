package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Connection Conexao;
	private static Conexao instancia;
	private static final String DATABASE = "big";
	private static final String USER = "root";
	private static final String PSW = "aluno";
	
	
	private Conexao() {
		
	}
	
	public static Conexao getIntancia() {
		if (instancia  == null) {
			instancia = new Conexao();
		}
		return instancia;
	}
	
	public  Connection conectar() {
		try {
			Conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE +"?serverTimezone=UTC", USER, PSW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Conexao;
	}
	public  boolean fecharConexao() {
		try {
			Conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
		
}
