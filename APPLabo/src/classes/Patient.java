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
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id_pat;

    private String nom;
    
    private String prenom;
    
    private Date dnaiss;
    
    private int telephone;
   
    private String email;
   
    private int id_region;
    
    private String cin;

    private String sexe;

    public Patient() {
    }

    public Patient(Integer idPatient) {
        this.id_pat = idPatient;
    }

    public Patient(Integer idPatient, String nom, String prenom, Date dnaissance, int tel, String mail, int idRegion, String cin, String sexe) {
        this.id_pat = idPatient;
        this.nom = nom;
        this.prenom = prenom;
        this.dnaiss = dnaissance;
        this.telephone = tel;
        this.email = mail;
        this.id_region = idRegion;
        this.cin = cin;
        this.sexe = sexe;
    }

    public Patient(String nom, String prenom,Date dnaissance, int tel, String email, int reg, String cin, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.dnaiss = dnaissance;
        this.telephone = tel;
        this.email = email;
        this.id_region = reg;
        this.cin = cin;
        this.sexe = sexe;
    }

    public Integer getIdPatient() {
        return id_pat;
    }

    public void setIdPatient(Integer idPatient) {
        this.id_pat = idPatient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDnaissance() {
        return dnaiss;
    }

    public void setDnaissance(Date dnaissance) {
        this.dnaiss = dnaissance;
    }

    public int getTel() {
        return telephone;
    }

    public void setTel(int tel) {
        this.telephone = tel;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String mail) {
        this.email = mail;
    }

    public int getIdRegion() {
        return id_region;
    }

    public void setIdRegion(int idRegion) {
        this.id_region = idRegion;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_pat != null ? id_pat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id_pat == null && other.id_pat != null) || (this.id_pat != null && !this.id_pat.equals(other.id_pat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Patient[ idPatient=" + id_pat + " ]";
    }
    
}

