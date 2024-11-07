package com.Hotelaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        Connection conn = Conexao.conectar();
        try {
            String sql = "INSERT INTO hospede (nome, email, idade) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Leila");
            stmt.setString(2, "leila@email.com");
            stmt.setInt(3, 25);
            
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Dados inseridos: " + rowsAffected + " linha(s) afetada(s).");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public static void inserirDados(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
}