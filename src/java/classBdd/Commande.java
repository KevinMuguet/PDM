/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classBdd;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joker
 */
@Entity
@Table(name = "Commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByIdCommande", query = "SELECT c FROM Commande c WHERE c.idCommande = :idCommande"),
    @NamedQuery(name = "Commande.findByDateCommande", query = "SELECT c FROM Commande c WHERE c.dateCommande = :dateCommande"),
    @NamedQuery(name = "Commande.findByPrixTotalCommande", query = "SELECT c FROM Commande c WHERE c.prixTotalCommande = :prixTotalCommande"),
    @NamedQuery(name = "Commande.findByEtatCommande", query = "SELECT c FROM Commande c WHERE c.etatCommande = :etatCommande")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_commande")
    private Integer idCommande;
    @Basic(optional = false)
    @Column(name = "date_commande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommande;
    @Basic(optional = false)
    @Column(name = "prix_total_commande")
    private int prixTotalCommande;
    @Basic(optional = false)
    @Column(name = "etat_commande")
    private String etatCommande;
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Utilisateur idClient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private Collection<ProduitCommande> produitCommandeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCommande")
    private Collection<Reglement> reglementCollection;

    public Commande() {
    }

    public Commande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Commande(Integer idCommande, Date dateCommande, int prixTotalCommande, String etatCommande) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.prixTotalCommande = prixTotalCommande;
        this.etatCommande = etatCommande;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getPrixTotalCommande() {
        return prixTotalCommande;
    }

    public void setPrixTotalCommande(int prixTotalCommande) {
        this.prixTotalCommande = prixTotalCommande;
    }

    public String getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(String etatCommande) {
        this.etatCommande = etatCommande;
    }

    public Utilisateur getIdClient() {
        return idClient;
    }

    public void setIdClient(Utilisateur idClient) {
        this.idClient = idClient;
    }

    @XmlTransient
    public Collection<ProduitCommande> getProduitCommandeCollection() {
        return produitCommandeCollection;
    }

    public void setProduitCommandeCollection(Collection<ProduitCommande> produitCommandeCollection) {
        this.produitCommandeCollection = produitCommandeCollection;
    }

    @XmlTransient
    public Collection<Reglement> getReglementCollection() {
        return reglementCollection;
    }

    public void setReglementCollection(Collection<Reglement> reglementCollection) {
        this.reglementCollection = reglementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommande != null ? idCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Commande[ idCommande=" + idCommande + " ]";
    }
    
}
