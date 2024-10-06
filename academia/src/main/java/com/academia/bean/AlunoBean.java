package com.academia.bean;

import com.academia.model.Aluno;
import jakarta.annotation.PostConstruct; // Atualizado para usar Jakarta
import jakarta.faces.view.ViewScoped; // Atualizado para usar Jakarta
import jakarta.inject.Named; // Usar @Named em vez de @ManagedBean
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable; // Importando Serializable
import java.util.List;

@Named // Substituindo @ManagedBean
@ViewScoped
public class AlunoBean implements Serializable { // Implementando Serializable

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext
    private EntityManager entityManager;

    private List<Aluno> alunos;
    private String filtroNome;
    private String filtroClassificacaoIMC;
    private String filtroFoneCelular;
    private String filtroEmail;

    @PostConstruct
    public void init() {
        carregarAlunos();
    }

    public void carregarAlunos() {
        String jpql = "SELECT a FROM Aluno a WHERE 1=1";
        
        if (filtroNome != null && !filtroNome.isEmpty()) {
            jpql += " AND a.nome LIKE :nome";
        }
        if (filtroClassificacaoIMC != null && !filtroClassificacaoIMC.isEmpty()) {
            jpql += " AND a.classificacaoIMC = :classificacaoIMC";
        }
        if (filtroFoneCelular != null && !filtroFoneCelular.isEmpty()) {
            jpql += " AND a.foneCelular LIKE :foneCelular";
        }
        if (filtroEmail != null && !filtroEmail.isEmpty()) {
            jpql += " AND a.email LIKE :email";
        }

        TypedQuery<Aluno> query = entityManager.createQuery(jpql, Aluno.class);
        
        if (filtroNome != null && !filtroNome.isEmpty()) {
            query.setParameter("nome", "%" + filtroNome + "%");
        }
        if (filtroClassificacaoIMC != null && !filtroClassificacaoIMC.isEmpty()) {
            query.setParameter("classificacaoIMC", filtroClassificacaoIMC);
        }
        if (filtroFoneCelular != null && !filtroFoneCelular.isEmpty()) {
            query.setParameter("foneCelular", "%" + filtroFoneCelular + "%");
        }
        if (filtroEmail != null && !filtroEmail.isEmpty()) {
            query.setParameter("email", "%" + filtroEmail + "%");
        }

        alunos = query.getResultList();
    }

    // Getters e Setters
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getFiltroNome() {
        return filtroNome;
    }

    public void setFiltroNome(String filtroNome) {
        this.filtroNome = filtroNome;
    }

    public String getFiltroClassificacaoIMC() {
        return filtroClassificacaoIMC;
    }

    public void setFiltroClassificacaoIMC(String filtroClassificacaoIMC) {
        this.filtroClassificacaoIMC = filtroClassificacaoIMC;
    }

    public String getFiltroFoneCelular() {
        return filtroFoneCelular;
    }

    public void setFiltroFoneCelular(String filtroFoneCelular) {
        this.filtroFoneCelular = filtroFoneCelular;
    }

    public String getFiltroEmail() {
        return filtroEmail;
    }

    public void setFiltroEmail(String filtroEmail) {
        this.filtroEmail = filtroEmail;
    }
}
