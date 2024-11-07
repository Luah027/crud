package com.Hotelaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection conectar() {
        try {
            // Conectando ao banco de dados H2 (em arquivo)
            return DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}