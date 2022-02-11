/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class TblDetilTransaksiPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "trans_kd")
    private String transKd;
    @Basic(optional = false)
    @Column(name = "bk_kd")
    private String bkKd;

    public TblDetilTransaksiPK() {
    }

    public TblDetilTransaksiPK(String transKd, String bkKd) {
        this.transKd = transKd;
        this.bkKd = bkKd;
    }

    public String getTransKd() {
        return transKd;
    }

    public void setTransKd(String transKd) {
        this.transKd = transKd;
    }

    public String getBkKd() {
        return bkKd;
    }

    public void setBkKd(String bkKd) {
        this.bkKd = bkKd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transKd != null ? transKd.hashCode() : 0);
        hash += (bkKd != null ? bkKd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetilTransaksiPK)) {
            return false;
        }
        TblDetilTransaksiPK other = (TblDetilTransaksiPK) object;
        if ((this.transKd == null && other.transKd != null) || (this.transKd != null && !this.transKd.equals(other.transKd))) {
            return false;
        }
        if ((this.bkKd == null && other.bkKd != null) || (this.bkKd != null && !this.bkKd.equals(other.bkKd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TblDetilTransaksiPK[ transKd=" + transKd + ", bkKd=" + bkKd + " ]";
    }
    
}
