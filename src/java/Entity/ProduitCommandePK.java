/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Joker
 */
@Embeddable
public class ProduitCommandePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_produit")
    private int idProduit;
    @Basic(optional = false)
    @Column(name = "id_commande")
    private int idCommande;

    public ProduitCommandePK() {
    }

    public ProduitCommandePK(int idProduit, int idCommande) {
        this.idProduit = idProduit;
        this.idCommande = idCommande;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduit;
        hash += (int) idCommande;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitCommandePK)) {
            return false;
        }
        ProduitCommandePK other = (ProduitCommandePK) object;
        if (this.idProduit != other.idProduit) {
            return false;
        }
        if (this.idCommande != other.idCommande) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ProduitCommandePK[ idProduit=" + idProduit + ", idCommande=" + idCommande + " ]";
    }
    
}
