/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "tbl_transaksi")
@NamedQueries({
    @NamedQuery(name = "TblTransaksi.findAll", query = "SELECT t FROM TblTransaksi t")
    , @NamedQuery(name = "TblTransaksi.findByTransKd", query = "SELECT t FROM TblTransaksi t WHERE t.transKd = :transKd")
    , @NamedQuery(name = "TblTransaksi.findByTransTglTransaksi", query = "SELECT t FROM TblTransaksi t WHERE t.transTglTransaksi = :transTglTransaksi")
    , @NamedQuery(name = "TblTransaksi.findByMbKd", query = "SELECT t FROM TblTransaksi t WHERE t.mbKd = :mbKd")
    , @NamedQuery(name = "TblTransaksi.findByTransTglPinjam", query = "SELECT t FROM TblTransaksi t WHERE t.transTglPinjam = :transTglPinjam")
    , @NamedQuery(name = "TblTransaksi.findByTransTglKembali", query = "SELECT t FROM TblTransaksi t WHERE t.transTglKembali = :transTglKembali")
    , @NamedQuery(name = "TblTransaksi.findByStatusPengembalian", query = "SELECT t FROM TblTransaksi t WHERE t.statusPengembalian = :statusPengembalian")})
public class TblTransaksi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "trans_kd")
    private String transKd;
    @Column(name = "trans_tgl_transaksi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transTglTransaksi;
    @Column(name = "mb_kd")
    private String mbKd;
    @Column(name = "trans_tgl_pinjam")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transTglPinjam;
    @Column(name = "trans_tgl_kembali")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transTglKembali;
    @Column(name = "status_pengembalian")
    private String statusPengembalian;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblTransaksi")
    private List<TblDetilTransaksi> tblDetilTransaksiList;

    public TblTransaksi() {
    }

    public TblTransaksi(String transKd) {
        this.transKd = transKd;
    }

    public String getTransKd() {
        return transKd;
    }

    public void setTransKd(String transKd) {
        this.transKd = transKd;
    }

    public Date getTransTglTransaksi() {
        return transTglTransaksi;
    }

    public void setTransTglTransaksi(Date transTglTransaksi) {
        this.transTglTransaksi = transTglTransaksi;
    }

    public String getMbKd() {
        return mbKd;
    }

    public void setMbKd(String mbKd) {
        this.mbKd = mbKd;
    }

    public Date getTransTglPinjam() {
        return transTglPinjam;
    }

    public void setTransTglPinjam(Date transTglPinjam) {
        this.transTglPinjam = transTglPinjam;
    }

    public Date getTransTglKembali() {
        return transTglKembali;
    }

    public void setTransTglKembali(Date transTglKembali) {
        this.transTglKembali = transTglKembali;
    }

    public String getStatusPengembalian() {
        return statusPengembalian;
    }

    public void setStatusPengembalian(String statusPengembalian) {
        this.statusPengembalian = statusPengembalian;
    }

    public List<TblDetilTransaksi> getTblDetilTransaksiList() {
        return tblDetilTransaksiList;
    }

    public void setTblDetilTransaksiList(List<TblDetilTransaksi> tblDetilTransaksiList) {
        this.tblDetilTransaksiList = tblDetilTransaksiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transKd != null ? transKd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTransaksi)) {
            return false;
        }
        TblTransaksi other = (TblTransaksi) object;
        if ((this.transKd == null && other.transKd != null) || (this.transKd != null && !this.transKd.equals(other.transKd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TblTransaksi[ transKd=" + transKd + " ]";
    }
    
}
