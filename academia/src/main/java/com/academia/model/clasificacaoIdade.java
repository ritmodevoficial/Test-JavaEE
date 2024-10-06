package com.academia.model;

import java.time.LocalDate;
import java.time.Period;

public class clasificacaoIdade {
    private String nome;
    private LocalDate dataNascimento;
    private ResponsavelLegal responsavelLegal;

    // Construtor
    public clasificacaoIdade(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // Método para calcular a idade
    public int calcularIdade() {
        LocalDate hoje = LocalDate.now();
        return Period.between(dataNascimento, hoje).getYears();
    }

    // Verifica se o aluno é menor de idade
    public boolean eMenorDeIdade() {
        return calcularIdade() < 18;
    }

    // Define o responsável legal caso o aluno seja menor de idade
    public void definirResponsavelLegal(String nome, String parentesco) {
        if (eMenorDeIdade()) {
            this.responsavelLegal = new ResponsavelLegal();
            this.responsavelLegal.setNome(nome);
            this.responsavelLegal.setParentesco(parentesco);
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ResponsavelLegal getResponsavelLegal() {
        return responsavelLegal;
    }
}
