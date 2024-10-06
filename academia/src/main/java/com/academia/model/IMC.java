package com.academia.model;

public class IMC {
    private double peso;
    private double altura;
    private String classificacaoIMC;

    // Métodos para calcular o IMC e classificar
    public double calcularIMC() {
        if (altura > 0) {
            return peso / (altura * altura);
        } else {
            return 0;
        }
    }

    public void definirClassificacaoIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) {
            classificacaoIMC = "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            classificacaoIMC = "Peso normal";
        } else if (imc >= 25 && imc <= 29.9) {
            classificacaoIMC = "Sobrepeso";
        } else if (imc >= 30 && imc <= 34.9){
            classificacaoIMC = "Obesidade grau I";
        } else if (imc >= 35 && imc <= 39.9){
            classificacaoIMC = "Obesidade grau II";
        } else {
            classificacaoIMC = "Obesidade grau III";
        }
    }

    // Getters e Setters
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getClassificacaoIMC() {
        return classificacaoIMC;
    }
}
