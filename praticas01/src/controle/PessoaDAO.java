package controle;


import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaDAO {
	
	private Conexao con;
	
	private static PessoaDAO instancia;
	
	//cr
	public boolean inserir(Pessoa pessoa) {
		
		con =  Conexao.getIntancia();
		
		Connection c = con.conectar();
		
		try {
			String query = "Insert Into pessoa"+" (cpf, nome) Values (?, ?);"; 
			PreparedStatement stm = c.prepareStatement(query);
			
			stm.setInt(1,123);
			stm.setString(2, "big");
			
			stm.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		con.fecharConexao();
		return false;
	}
	public boolean deletar(Pessoa pessoa) {
		con =  Conexao.getIntancia();
		
		Connection c = con.conectar();
		
		try {
			String query = "DELETE FROM pessoa WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setInt(1, pessoa.getCpf());
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;
	}
	public boolean atualizar(Pessoa pessoa) {
		con =  Conexao.getIntancia();
		
		Connection c = con.conectar();
		
		try {
			String query = "UPDATE pessoa SET nome = ? WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, pessoa.getNome());
			stm.setInt(2, pessoa.getCpf());
			stm.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;
	}
	public ArrayList<Pessoa> listarPessoa(){
		
		ArrayList<Pessoa> pessoas =  new ArrayList<>();
		con =  Conexao.getIntancia();
		
		
		Connection c = con.conectar();
		
		try {
		
			Statement stm = c.createStatement();
			String query = "Select * from pessoa";
			ResultSet rs =  stm.executeQuery(query);
			while (rs.next()) {
				int cpf = rs.getInt("cpf");
				String nome = rs.getString("nome");
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(cpf);
				pessoa.setNome(nome);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		con.fecharConexao();
		
		return null;
	}
}
