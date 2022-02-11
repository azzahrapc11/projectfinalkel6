/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import model.TblBuku;
import model.TblMember;
import model.TblTransaksi;

/**
 *
 * @author User
 */
public class peminjamanController {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("finalproject_team6PU");
    EntityManager em = emf.createEntityManager();
    
    public peminjamanController(EntityManager em) {
        this.em = em;
    }
    
    public List<TblTransaksi> tampilSemua()
    {
        return em.createNamedQuery("TblTransaksi.findAll").getResultList();
    }
    
    public List<TblTransaksi> tampilID(String id)
    {
        return em.createQuery(
                "SELECT t FROM TblTransaksi t WHERE t.transKd LIKE :id")
                .setParameter("id", id)
                .getResultList();
    }
    
    public List<TblTransaksi> tampilStatus(String status)
    {
        return em.createQuery(
                "SELECT t FROM TblTransaksi t WHERE t.statusPengembalian LIKE :statusPengembalian")
                .setParameter("statusPengembalian", status)
                .getResultList();
    }
    
    public List<TblBuku> tampilBuku(){
        return em.createNamedQuery("TblBuku.findAll").getResultList();
    }
    
    public List<TblMember> getIdMember(String id){
        return em.createNamedQuery("TblMember.findByMbKd")
                .setParameter("mbKd", id)
                .getResultList();
    }
     
    public List<TblMember> tampilnamaMember(String id){
        return em.createQuery("SELECT t.mbNama FROM TblMember t WHERE t.mbKd = :mbKd")
                .setParameter("mbKd", id)
                .getResultList();
    }
    
    public void simpanPeminjaman(TblTransaksi transaksi){
        try{
            em.getEntityManagerFactory();
            em.getTransaction().begin();
            em.persist(transaksi);
            em.getTransaction().commit();
        }catch(RollbackException ex){
            em.getTransaction().rollback();
        }
    }
    
    public void editPeminjaman(TblTransaksi transaksi){
        try{
            em.getEntityManagerFactory();
            em.getTransaction().begin();
            em.merge(transaksi);
            em.getTransaction().commit();
        }catch(RollbackException ex){
            em.getTransaction().rollback();
        }
    }
    
    public String idMaxTransaksi()
    {
        return (String.valueOf(em.createQuery("SELECT t.transKd FROM TblTransaksi t WHERE t.transKd = (SELECT MAX(t.transKd) FROM TblTransaksi t)").getSingleResult()));
    }
    
}
