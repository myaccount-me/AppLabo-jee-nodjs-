/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;


/**
 *
 * @author hp
 */
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id_region;
    private String nomRegion;

    public Region() {
    }

    public Region(Integer idRegion) {
        this.id_region = idRegion;
    }

    public Region(Integer idRegion, String nomRegion) {
        this.id_region = idRegion;
        this.nomRegion = nomRegion;
    }

    public Integer getIdRegion() {
        return id_region;
    }

    public void setIdRegion(Integer idRegion) {
        this.id_region = idRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_region != null ? id_region.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.id_region == null && other.id_region != null) || (this.id_region != null && !this.id_region.equals(other.id_region))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Region[ idRegion=" + id_region + " ]";
    }
    
}
