package com.Hotelaria;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        Connection conn = Conexao.conectar();
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                       + "id INT AUTO_INCREMENT PRIMARY KEY, "
                       + "nome VARCHAR(255), "
                       + "email VARCHAR(255), "
                       + "idade INT)";
            stmt.executeUpdate(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public static void criarTabela() {
		// TODO Auto-generated method stub
		
	}
}