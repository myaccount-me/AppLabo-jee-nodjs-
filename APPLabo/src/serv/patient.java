/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.util.Date;

/**
 *
 * @author Haifa
 */
public class patient {
    private int id_pat;
    private int cin;
    private String nom;
    private String prenom;
    private Date dnaiss;
    private int telephone;
    private String email;
    private String sexe;
    private int id_region;

    public patient(int id_pat) {
        this.id_pat = id_pat;
    }

    public patient(int id_pat, int cin, String nom, String prenom, Date dnaiss, int telephone, String email, String sexe, int id_region) {
        this.id_pat = id_pat;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.dnaiss = dnaiss;
        this.telephone = telephone;
        this.email = email;
        this.sexe = sexe;
        this.id_region = id_region;
    }

    public patient() {
    }

    public int getId_pat() {
        return id_pat;
    }

    public void setId_pat(int id_pat) {
        this.id_pat = id_pat;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
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

    public Date getDnaiss() {
        return dnaiss;
    }

    public void setDnaiss(Date dnaiss) {
        this.dnaiss = dnaiss;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }
    
    
}
