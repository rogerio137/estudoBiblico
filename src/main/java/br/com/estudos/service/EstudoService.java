package br.com.estudos.service;

import br.com.estudos.entity.Estudo;
import br.com.estudos.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.UUID;

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

    public List<Estudo> estudos(){
        List<Estudo> lista = entityManager.createQuery("SELECT e FROM Estudo e", Estudo.class).getResultList();
        return lista;
    }

    public List<Estudo> estudos(String texto){
        List<Estudo> lista = entityManager.createQuery("SELECT e FROM Estudo e WHERE e.tema LIKE :tema", Estudo.class).setParameter("tema", "%"+texto+"%").getResultList();
        return lista;
    }
}
