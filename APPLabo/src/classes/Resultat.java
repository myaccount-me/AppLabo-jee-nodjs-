/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author hp
 */
public class Resultat implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id_rslt;
    private int id_labo;
    private int id_patient;
    private Date date;
    private String etat;

    public Resultat() {
    }

    public Resultat(Integer idResultat) {
        this.id_rslt = idResultat;
    }

    public Resultat(Integer idResultat, int idLabo, int idPatient, Date date, String etat) {
        this.id_rslt = idResultat;
        this.id_labo = idLabo;
        this.id_patient = idPatient;
        this.date = date;
        this.etat = etat;
    }
        public Resultat( int idLabo, int idPatient, Date date, String etat) {
        this.id_labo = idLabo;
        this.id_patient = idPatient;
        this.date = date;
        this.etat = etat;
    }

    public Integer getIdResultat() {
        return id_rslt;
    }

    public void setIdResultat(Integer idResultat) {
        this.id_rslt = idResultat;
    }

    public int getIdLabo() {
        return id_labo;
    }

    public void setIdLabo(int idLabo) {
        this.id_labo = idLabo;
    }

    public int getIdPatient() {
        return id_patient;
    }

    public void setIdPatient(int idPatient) {
        this.id_patient = idPatient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_rslt != null ? id_rslt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultat)) {
            return false;
        }
        Resultat other = (Resultat) object;
        if ((this.id_rslt == null && other.id_rslt != null) || (this.id_rslt != null && !this.id_rslt.equals(other.id_rslt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "classes.Resultat[ idResultat=" + id_rslt + " ]";
    }
    
}
