package com.academia.model;

public class Plano {
    private String nome;
    private double mensalidade;

    // Construtor
    public Plano(String nome, double mensalidade) {
        this.nome = nome;
        this.mensalidade = mensalidade;
    }

    // Método para calcular o valor do plano baseado na idade e frequência
    public static Plano calcularPlano(int idade, int frequenciaSemanal) {
        double valorBase = 100.00;

        if (idade < 18 && frequenciaSemanal == 3) {
            // Plano Junior: 20% desconto
            return new Plano("Junior", valorBase * 0.8);
        } else if (idade >= 18 && frequenciaSemanal == 5) {
            // Plano Premium: 15% desconto
            return new Plano("Premium", valorBase * 0.85);
        } else if (idade >= 60 && frequenciaSemanal == 3) {
            // Plano Melhor Idade: 25% desconto
            return new Plano("Melhor Idade", valorBase * 0.75);
        } else {
            // Plano Base
            return new Plano("Base", valorBase);
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public double getMensalidade() {
        return mensalidade;
    }
}
