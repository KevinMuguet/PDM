/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classBdd;

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
@Table(name = "produit_commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduitCommande.findAll", query = "SELECT p FROM ProduitCommande p"),
    @NamedQuery(name = "ProduitCommande.findByIdProduit", query = "SELECT p FROM ProduitCommande p WHERE p.produitCommandePK.idProduit = :idProduit"),
    @NamedQuery(name = "ProduitCommande.findByIdCommande", query = "SELECT p FROM ProduitCommande p WHERE p.produitCommandePK.idCommande = :idCommande"),
    @NamedQuery(name = "ProduitCommande.findByFraisDePort", query = "SELECT p FROM ProduitCommande p WHERE p.fraisDePort = :fraisDePort")})
public class ProduitCommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProduitCommandePK produitCommandePK;
    @Column(name = "frais_de_port")
    private String fraisDePort;
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;
    @JoinColumn(name = "id_commande", referencedColumnName = "id_commande", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;

    public ProduitCommande() {
    }

    public ProduitCommande(ProduitCommandePK produitCommandePK) {
        this.produitCommandePK = produitCommandePK;
    }

    public ProduitCommande(int idProduit, int idCommande) {
        this.produitCommandePK = new ProduitCommandePK(idProduit, idCommande);
    }

    public ProduitCommandePK getProduitCommandePK() {
        return produitCommandePK;
    }

    public void setProduitCommandePK(ProduitCommandePK produitCommandePK) {
        this.produitCommandePK = produitCommandePK;
    }

    public String getFraisDePort() {
        return fraisDePort;
    }

    public void setFraisDePort(String fraisDePort) {
        this.fraisDePort = fraisDePort;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produitCommandePK != null ? produitCommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitCommande)) {
            return false;
        }
        ProduitCommande other = (ProduitCommande) object;
        if ((this.produitCommandePK == null && other.produitCommandePK != null) || (this.produitCommandePK != null && !this.produitCommandePK.equals(other.produitCommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ProduitCommande[ produitCommandePK=" + produitCommandePK + " ]";
    }
    
}
