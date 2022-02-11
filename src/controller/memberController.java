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
import model.TblMember;

/**
 *
 * @author User
 */
public class memberController {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("finalproject_team6PU");
    EntityManager em = emf.createEntityManager();
    
    public memberController(EntityManager em) {
        this.em = em;
    }
    
    public List<TblMember> tampilSemua()
    {
        return em.createNamedQuery("TblMember.findAll").getResultList();
    }
    
    public List<TblMember> tampilID(String ID){
        return em.createQuery("SELECT t FROM TblMember t WHERE t.mbKd LIKE :ID").setParameter("ID", ID).getResultList();
    }
    
    public List<TblMember> tampilNama(String nama)
    {
        return em.createQuery(
                "SELECT t FROM TblMember t WHERE t.mbNama LIKE :nama")
                .setParameter("nama", nama)
                .getResultList();
    }
    
    public void simpanMember(TblMember member){
        try{
            em.getEntityManagerFactory();
            em.getTransaction().begin();
            em.persist(member);
            em.getTransaction().commit();
        }catch(RollbackException ex){
            em.getTransaction().rollback();
        }
    }
    
    public void editMember(TblMember member){
        try{
            em.getEntityManagerFactory();
            em.getTransaction().begin();
            em.merge(member);
            em.getTransaction().commit();
        }catch(RollbackException ex){
            em.getTransaction().rollback();
        }
    }
    
    public void hapusMember(TblMember member){
        try{
            em.getEntityManagerFactory();
            em.getTransaction().begin();
            em.remove(member);
            em.getTransaction().commit();
        }catch(RollbackException ex){
            em.getTransaction().rollback();
        }
    }
    
    public String idMaxMember()
    {
        return (String.valueOf(em.createQuery("SELECT t.mbKd FROM TblMember t WHERE t.mbKd = (SELECT MAX(t.mbKd) FROM TblMember t)").getSingleResult()));
    }
}
