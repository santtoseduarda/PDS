package teste;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Segundo {

	public static void main(String[] args) {
		//Executa operacoes no bd
		Statement stml = null;
		
		//Faz a conexao com o bd
		Connection conn = ConexaoBD.getConexaoMySQL();
		
		try {
			stml = (Statement) conn.createStatement();
			//Traz os resultados da consulta SQL	
			ResultSet res1 = null;
			res1 = stml.executeQuery("SELECT * FROM CLIENTES");
			System.out.println("ID   NOME   E-MAIL");
			while(res1.next()) {
				System.out.println(res1.getInt("id") + "     " +
						res1.getString("nome") + "    " +
						res1.getString("email") 
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
