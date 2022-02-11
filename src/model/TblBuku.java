/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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

/**
 *
 * @author User
 */
@Entity
@Table(name = "tbl_buku")
@NamedQueries({
    @NamedQuery(name = "TblBuku.findAll", query = "SELECT t FROM TblBuku t")
    , @NamedQuery(name = "TblBuku.findByBkKd", query = "SELECT t FROM TblBuku t WHERE t.bkKd = :bkKd")
    , @NamedQuery(name = "TblBuku.findByBkJudul", query = "SELECT t FROM TblBuku t WHERE t.bkJudul = :bkJudul")
    , @NamedQuery(name = "TblBuku.findByBkPengarang", query = "SELECT t FROM TblBuku t WHERE t.bkPengarang = :bkPengarang")
    , @NamedQuery(name = "TblBuku.findByBkPenerbit", query = "SELECT t FROM TblBuku t WHERE t.bkPenerbit = :bkPenerbit")
    , @NamedQuery(name = "TblBuku.findByBkTahunTerbit", query = "SELECT t FROM TblBuku t WHERE t.bkTahunTerbit = :bkTahunTerbit")
    , @NamedQuery(name = "TblBuku.findByBkStok", query = "SELECT t FROM TblBuku t WHERE t.bkStok = :bkStok")
    , @NamedQuery(name = "TblBuku.findByBkStatus", query = "SELECT t FROM TblBuku t WHERE t.bkStatus = :bkStatus")})
public class TblBuku implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "bk_kd")
    private String bkKd;
    @Column(name = "bk_judul")
    private String bkJudul;
    @Column(name = "bk_pengarang")
    private String bkPengarang;
    @Column(name = "bk_penerbit")
    private String bkPenerbit;
    @Column(name = "bk_tahun_terbit")
    private String bkTahunTerbit;
    @Column(name = "bk_stok")
    private Integer bkStok;
    @Column(name = "bk_status")
    private String bkStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblBuku")
    private List<TblDetilTransaksi> tblDetilTransaksiList;

    public TblBuku() {
    }

    public TblBuku(String bkKd) {
        this.bkKd = bkKd;
    }

    public String getBkKd() {
        return bkKd;
    }

    public void setBkKd(String bkKd) {
        this.bkKd = bkKd;
    }

    public String getBkJudul() {
        return bkJudul;
    }

    public void setBkJudul(String bkJudul) {
        this.bkJudul = bkJudul;
    }

    public String getBkPengarang() {
        return bkPengarang;
    }

    public void setBkPengarang(String bkPengarang) {
        this.bkPengarang = bkPengarang;
    }

    public String getBkPenerbit() {
        return bkPenerbit;
    }

    public void setBkPenerbit(String bkPenerbit) {
        this.bkPenerbit = bkPenerbit;
    }

    public String getBkTahunTerbit() {
        return bkTahunTerbit;
    }

    public void setBkTahunTerbit(String bkTahunTerbit) {
        this.bkTahunTerbit = bkTahunTerbit;
    }

    public Integer getBkStok() {
        return bkStok;
    }

    public void setBkStok(Integer bkStok) {
        this.bkStok = bkStok;
    }

    public String getBkStatus() {
        return bkStatus;
    }

    public void setBkStatus(String bkStatus) {
        this.bkStatus = bkStatus;
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
        hash += (bkKd != null ? bkKd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBuku)) {
            return false;
        }
        TblBuku other = (TblBuku) object;
        if ((this.bkKd == null && other.bkKd != null) || (this.bkKd != null && !this.bkKd.equals(other.bkKd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TblBuku[ bkKd=" + bkKd + " ]";
    }
    
}
