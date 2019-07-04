/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classBdd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Joker
 */
@Embeddable
public class EvenementPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_utilisateur")
    private int idUtilisateur;
    @Basic(optional = false)
    @Column(name = "id_produit")
    private int idProduit;

    public EvenementPK() {
    }

    public EvenementPK(int idUtilisateur, int idProduit) {
        this.idUtilisateur = idUtilisateur;
        this.idProduit = idProduit;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUtilisateur;
        hash += (int) idProduit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvenementPK)) {
            return false;
        }
        EvenementPK other = (EvenementPK) object;
        if (this.idUtilisateur != other.idUtilisateur) {
            return false;
        }
        if (this.idProduit != other.idProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.EvenementPK[ idUtilisateur=" + idUtilisateur + ", idProduit=" + idProduit + " ]";
    }
    
}
