package com.academia.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Academia";
        String user = "postgres";
        String password = "postgres";

        try (Connection conexao = DriverManager.getConnection(url, user, password)) {

            // Acessando a tabela aluno
            ResultSet rsAluno = conexao.createStatement().executeQuery("SELECT * FROM aluno");
            while (rsAluno.next()) {
                System.out.println("Aluno Nome: " + rsAluno.getString("nome"));
            }

            // Acessando a tabela responsavellegal
            ResultSet rsResponsavel = conexao.createStatement().executeQuery("SELECT * FROM responsavellegal");
            while (rsResponsavel.next()) {
                System.out.println("Responsável Nome: " + rsResponsavel.getString("nome"));
            }

            // Acessando a tabela fichatreino
            ResultSet rsFicha = conexao.createStatement().executeQuery("SELECT * FROM fichatreino");
            while (rsFicha.next()) {
                System.out.println("Exercício: " + rsFicha.getString("exercicio"));
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        }
    }
}
