package com.example.application;

import com.example.domain.Pessoa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Program {
    public static void main(String[] args) {

        // Exemplo de Inserção de Dados com JPA
        // Pessoa p1 = new Pessoa(null, "Pedro", "pedro@example.com");
        // Pessoa p2 = new Pessoa(null, "Maria", "maria@example.com");
        // Pessoa p3 = new Pessoa(null, "João", "joao@example.com");

        // Exemplo de find by ID com JPA(lá embaixo)

        // Exemplo de remove com JPA(lá embaixo) [Remove só funciona se o objeto estiver
        // no estado gerenciado(monitorado), ou seja, se ele tiver sido recuperado do
        // banco de dados
        // ou persistido anteriormente]

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin(); // qualquer operação que não seja apenas leitura precisa estar dentro de uma
                                     // transação, ou seja, entre begin() e commit()

        // em.persist(p1);
        // em.persist(p2);
        // em.persist(p3);
        // Pessoa p = em.find(Pessoa.class, 1);

        Pessoa p = em.find(Pessoa.class, 6);
        em.remove(p);

        em.getTransaction().commit();
        em.close();
        emf.close();

        // System.out.println("Pessoas persistidas com sucesso!");
        // System.out.println("Pessoa encontrada: " + p);
        System.out.println("Pessoa removida: " + p);

    }
}
