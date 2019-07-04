/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joker
 */
@Entity
@Table(name = "Evenement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evenement.findAll", query = "SELECT e FROM Evenement e"),
    @NamedQuery(name = "Evenement.findByIdUtilisateur", query = "SELECT e FROM Evenement e WHERE e.evenementPK.idUtilisateur = :idUtilisateur"),
    @NamedQuery(name = "Evenement.findByIdProduit", query = "SELECT e FROM Evenement e WHERE e.evenementPK.idProduit = :idProduit"),
    @NamedQuery(name = "Evenement.findByLibelleEvenement", query = "SELECT e FROM Evenement e WHERE e.libelleEvenement = :libelleEvenement")})
public class Evenement implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvenementPK evenementPK;
    @Column(name = "libelle_evenement")
    private String libelleEvenement;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;

    public Evenement() {
    }

    public Evenement(EvenementPK evenementPK) {
        this.evenementPK = evenementPK;
    }

    public Evenement(int idUtilisateur, int idProduit) {
        this.evenementPK = new EvenementPK(idUtilisateur, idProduit);
    }

    public EvenementPK getEvenementPK() {
        return evenementPK;
    }

    public void setEvenementPK(EvenementPK evenementPK) {
        this.evenementPK = evenementPK;
    }

    public String getLibelleEvenement() {
        return libelleEvenement;
    }

    public void setLibelleEvenement(String libelleEvenement) {
        this.libelleEvenement = libelleEvenement;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evenementPK != null ? evenementPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evenement)) {
            return false;
        }
        Evenement other = (Evenement) object;
        if ((this.evenementPK == null && other.evenementPK != null) || (this.evenementPK != null && !this.evenementPK.equals(other.evenementPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Evenement[ evenementPK=" + evenementPK + " ]";
    }
    
}
