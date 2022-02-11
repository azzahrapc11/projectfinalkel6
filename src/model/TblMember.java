/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "tbl_member")
@NamedQueries({
    @NamedQuery(name = "TblMember.findAll", query = "SELECT t FROM TblMember t")
    , @NamedQuery(name = "TblMember.findByMbKd", query = "SELECT t FROM TblMember t WHERE t.mbKd = :mbKd")
    , @NamedQuery(name = "TblMember.findByMbNama", query = "SELECT t FROM TblMember t WHERE t.mbNama = :mbNama")
    , @NamedQuery(name = "TblMember.findByMbNoHp", query = "SELECT t FROM TblMember t WHERE t.mbNoHp = :mbNoHp")
    , @NamedQuery(name = "TblMember.findByMbAlamat", query = "SELECT t FROM TblMember t WHERE t.mbAlamat = :mbAlamat")})
public class TblMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mb_kd")
    private String mbKd;
    @Column(name = "mb_nama")
    private String mbNama;
    @Column(name = "mb_no_hp")
    private String mbNoHp;
    @Column(name = "mb_alamat")
    private String mbAlamat;

    public TblMember() {
    }

    public TblMember(String mbKd) {
        this.mbKd = mbKd;
    }

    public String getMbKd() {
        return mbKd;
    }

    public void setMbKd(String mbKd) {
        this.mbKd = mbKd;
    }

    public String getMbNama() {
        return mbNama;
    }

    public void setMbNama(String mbNama) {
        this.mbNama = mbNama;
    }

    public String getMbNoHp() {
        return mbNoHp;
    }

    public void setMbNoHp(String mbNoHp) {
        this.mbNoHp = mbNoHp;
    }

    public String getMbAlamat() {
        return mbAlamat;
    }

    public void setMbAlamat(String mbAlamat) {
        this.mbAlamat = mbAlamat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mbKd != null ? mbKd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMember)) {
            return false;
        }
        TblMember other = (TblMember) object;
        if ((this.mbKd == null && other.mbKd != null) || (this.mbKd != null && !this.mbKd.equals(other.mbKd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TblMember[ mbKd=" + mbKd + " ]";
    }
    
}
