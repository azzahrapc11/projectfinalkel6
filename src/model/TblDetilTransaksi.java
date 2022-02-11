/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "tbl_detil_transaksi")
@NamedQueries({
    @NamedQuery(name = "TblDetilTransaksi.findAll", query = "SELECT t FROM TblDetilTransaksi t")
    , @NamedQuery(name = "TblDetilTransaksi.findByTransKd", query = "SELECT t FROM TblDetilTransaksi t WHERE t.tblDetilTransaksiPK.transKd = :transKd")
    , @NamedQuery(name = "TblDetilTransaksi.findByBkKd", query = "SELECT t FROM TblDetilTransaksi t WHERE t.tblDetilTransaksiPK.bkKd = :bkKd")
    , @NamedQuery(name = "TblDetilTransaksi.findByBkJudul", query = "SELECT t FROM TblDetilTransaksi t WHERE t.bkJudul = :bkJudul")
    , @NamedQuery(name = "TblDetilTransaksi.findByTransQty", query = "SELECT t FROM TblDetilTransaksi t WHERE t.transQty = :transQty")})
public class TblDetilTransaksi implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetilTransaksiPK tblDetilTransaksiPK;
    @Column(name = "bk_judul")
    private String bkJudul;
    @Column(name = "trans_qty")
    private Integer transQty;
    @JoinColumn(name = "bk_kd", referencedColumnName = "bk_kd", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblBuku tblBuku;
    @JoinColumn(name = "trans_kd", referencedColumnName = "trans_kd", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblTransaksi tblTransaksi;

    public TblDetilTransaksi() {
    }

    public TblDetilTransaksi(TblDetilTransaksiPK tblDetilTransaksiPK) {
        this.tblDetilTransaksiPK = tblDetilTransaksiPK;
    }

    public TblDetilTransaksi(String transKd, String bkKd) {
        this.tblDetilTransaksiPK = new TblDetilTransaksiPK(transKd, bkKd);
    }

    public TblDetilTransaksiPK getTblDetilTransaksiPK() {
        return tblDetilTransaksiPK;
    }

    public void setTblDetilTransaksiPK(TblDetilTransaksiPK tblDetilTransaksiPK) {
        this.tblDetilTransaksiPK = tblDetilTransaksiPK;
    }

    public String getBkJudul() {
        return bkJudul;
    }

    public void setBkJudul(String bkJudul) {
        this.bkJudul = bkJudul;
    }

    public Integer getTransQty() {
        return transQty;
    }

    public void setTransQty(Integer transQty) {
        this.transQty = transQty;
    }

    public TblBuku getTblBuku() {
        return tblBuku;
    }

    public void setTblBuku(TblBuku tblBuku) {
        this.tblBuku = tblBuku;
    }

    public TblTransaksi getTblTransaksi() {
        return tblTransaksi;
    }

    public void setTblTransaksi(TblTransaksi tblTransaksi) {
        this.tblTransaksi = tblTransaksi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblDetilTransaksiPK != null ? tblDetilTransaksiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetilTransaksi)) {
            return false;
        }
        TblDetilTransaksi other = (TblDetilTransaksi) object;
        if ((this.tblDetilTransaksiPK == null && other.tblDetilTransaksiPK != null) || (this.tblDetilTransaksiPK != null && !this.tblDetilTransaksiPK.equals(other.tblDetilTransaksiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TblDetilTransaksi[ tblDetilTransaksiPK=" + tblDetilTransaksiPK + " ]";
    }
    
}
