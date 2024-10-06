package com.academia.bean;

import com.academia.model.Aluno;
import jakarta.faces.view.ViewScoped; // Atualizado para usar Jakarta
import jakarta.inject.Named; // Usar @Named em vez de @ManagedBean
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named // Substituindo @ManagedBean
@ViewScoped
public class CadastroAlunoBean {

    @PersistenceContext
    private EntityManager entityManager;

    private Aluno novoAluno;

    public CadastroAlunoBean() {
        novoAluno = new Aluno();
    }

    @Transactional
    public String salvarAluno() {
        novoAluno.setClassificacaoIMC(novoAluno.definirClassificacaoIMC());
        entityManager.persist(novoAluno);
        return "lista-alunos.xhtml?faces-redirect=true"; // Redireciona após salvar
    }

    // Getters e Setters
    public Aluno getNovoAluno() {
        return novoAluno;
    }

    public void setNovoAluno(Aluno novoAluno) {
        this.novoAluno = novoAluno;
    }
}