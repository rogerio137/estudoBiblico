package br.com.estudos.service;

import br.com.estudos.entity.Estudo;
import br.com.estudos.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class EstudoService {

    private JpaUtil JPAUtil;
    private EntityManager entityManager = JPAUtil.getEntityManager();

    public void salvar(Estudo estudo){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(estudo);
            entityManager.getTransaction().commit();
        }finally {
            entityManager.close();
        }

    }
}
