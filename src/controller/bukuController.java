/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import model.TblBuku;

/**
 *
 * @author User
 */
public class bukuController {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("finalproject_team6PU");
    EntityManager em = emf.createEntityManager();
    
    public bukuController(EntityManager em) {
        this.em = em;
    }
    
    public List<TblBuku> tampilSemua()
    {
        return em.createNamedQuery("TblBuku.findAll").getResultList();
    }
    
    public List<TblBuku> tampilID(String ID){
        return em.createQuery("SELECT t FROM TblBuku t WHERE t.bkKd LIKE :ID").setParameter("ID", ID).getResultList();
    }
    
    public List<TblBuku> tampilJudul(String judul)
    {
        return em.createQuery(
                "SELECT t FROM TblBuku t WHERE t.bkJudul LIKE :judul")
                .setParameter("judul", judul)
                .getResultList();
    }
    
    public void simpanBuku(TblBuku buku){
        try{
            em.getEntityManagerFactory();
            em.getTransaction().begin();
            em.persist(buku);
            em.getTransaction().commit();
        }catch(RollbackException ex){
            em.getTransaction().rollback();
        }
    }
    
    public void editBuku(TblBuku buku){
        try{
            em.getEntityManagerFactory();
            em.getTransaction().begin();
            em.merge(buku);
            em.getTransaction().commit();
        }catch(RollbackException ex){
            em.getTransaction().rollback();
        }
    }
    
    public void hapusBuku(TblBuku buku){
        try{
            em.getEntityManagerFactory();
            em.getTransaction().begin();
            em.remove(buku);
            em.getTransaction().commit();
        }catch(RollbackException ex){
            em.getTransaction().rollback();
        }
    }
    
    public String idMaxBuku()
    {
        return (String.valueOf(em.createQuery("SELECT t.bkKd FROM TblBuku t WHERE t.bkKd = (SELECT MAX(t.bkKd) FROM TblBuku t)").getSingleResult()));
    }
}
