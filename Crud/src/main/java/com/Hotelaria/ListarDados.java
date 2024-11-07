package com.Hotelaria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListarDados {
    public static void main(String[] args) {
        Connection conn = Conexao.conectar();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM hospede";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                int idade = rs.getInt("idade");
                
                System.out.println("ID: " + id + " | Nome: " + nome + " | E-mail: " + email + " | Idade: " + idade);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar dados: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public static void listarHospede() {
		// TODO Auto-generated method stub
		
	}
}