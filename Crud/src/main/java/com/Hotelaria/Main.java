package com.Hotelaria;

public class Main {
    public static void main(String[] args) {
        
        CreateTable.criarTabela();

        InsertData.inserirDados("João", "joao@example.com");
        InsertData.inserirDados("Maria", "maria@example.com");

        
        System.out.println("Lista de Hospedes:");
        ListarDados.listarHospede();

        
        DeleteData.excluirUsuario(1);

        
        System.out.println("Lista de Hospedes após a exclusão:");
        ListarDados.listarHospede();
    }
}