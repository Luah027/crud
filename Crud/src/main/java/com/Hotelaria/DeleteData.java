package com.Hotelaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        Connection conn = Conexao.conectar();
        try {
            String sql = "DELETE FROM hospede WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 1);
            
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Dados excluídos: " + rowsAffected + " linha(s) afetada(s).");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir dados: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public static void excluirUsuario(int i) {
		// TODO Auto-generated method stub
		
	}
}