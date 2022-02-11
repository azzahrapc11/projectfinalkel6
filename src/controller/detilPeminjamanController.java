/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import model.TblDetilTransaksi;

/**
 *
 * @author User
 */
public class detilPeminjamanController {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("finalproject_team6PU");
    EntityManager em = emf.createEntityManager();

    public detilPeminjamanController(EntityManager em) {
        this.em = em;
    }
    
    public void tambah(TblDetilTransaksi detilPinjam)
    {
        try
        {
                em.getEntityManagerFactory();
                em.getTransaction().begin();
                em.persist(detilPinjam);
                em.getTransaction().commit();
        }
        catch (RollbackException ex)
        {
            em.getTransaction().rollback();
        }
    }
    
    public void tambah1(TblDetilTransaksi detilJual)
    {
        try
        {
                EntityTransaction tx = em.getTransaction();
                em.getTransaction().begin();
                em.persist(detilJual);
                tx.commit();
        }
        catch (RollbackException ex){
            em.getTransaction().rollback();
        }
    }
    
    public List<TblDetilTransaksi> tampilSemuaDetilPenjualan()
    {
         return em.createNamedQuery("TblDetilTransaksi.findAll").getResultList();
    }
    
    public List<TblDetilTransaksi> tampilDetilPenjualan(String idPinjam)
    {
         return em.createQuery("SELECT t FROM TblDetilTransaksi t WHERE t.tblDetilTransaksiPK.transKd = :transKd")
                 .setParameter("transKd", idPinjam).getResultList();
    }
}
