/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classBdd;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joker
 */
@Entity
@Table(name = "Entrepot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrepot.findAll", query = "SELECT e FROM Entrepot e"),
    @NamedQuery(name = "Entrepot.findByIdEntrepot", query = "SELECT e FROM Entrepot e WHERE e.idEntrepot = :idEntrepot"),
    @NamedQuery(name = "Entrepot.findByLibelleEntrepot", query = "SELECT e FROM Entrepot e WHERE e.libelleEntrepot = :libelleEntrepot"),
    @NamedQuery(name = "Entrepot.findByNumRueEntrepot", query = "SELECT e FROM Entrepot e WHERE e.numRueEntrepot = :numRueEntrepot"),
    @NamedQuery(name = "Entrepot.findByNomRueEntrepot", query = "SELECT e FROM Entrepot e WHERE e.nomRueEntrepot = :nomRueEntrepot"),
    @NamedQuery(name = "Entrepot.findByCpEntrepot", query = "SELECT e FROM Entrepot e WHERE e.cpEntrepot = :cpEntrepot")})
public class Entrepot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entrepot")
    private Integer idEntrepot;
    @Basic(optional = false)
    @Column(name = "libelle_entrepot")
    private String libelleEntrepot;
    @Basic(optional = false)
    @Column(name = "num_rue_entrepot")
    private int numRueEntrepot;
    @Basic(optional = false)
    @Column(name = "nom_rue_entrepot")
    private String nomRueEntrepot;
    @Basic(optional = false)
    @Column(name = "cp_entrepot")
    private int cpEntrepot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntrepot")
    private Collection<Produit> produitCollection;
    @JoinColumn(name = "id_fournisseur", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Utilisateur idFournisseur;

    public Entrepot() {
    }

    public Entrepot(Integer idEntrepot) {
        this.idEntrepot = idEntrepot;
    }

    public Entrepot(Integer idEntrepot, String libelleEntrepot, int numRueEntrepot, String nomRueEntrepot, int cpEntrepot) {
        this.idEntrepot = idEntrepot;
        this.libelleEntrepot = libelleEntrepot;
        this.numRueEntrepot = numRueEntrepot;
        this.nomRueEntrepot = nomRueEntrepot;
        this.cpEntrepot = cpEntrepot;
    }

    public Integer getIdEntrepot() {
        return idEntrepot;
    }

    public void setIdEntrepot(Integer idEntrepot) {
        this.idEntrepot = idEntrepot;
    }

    public String getLibelleEntrepot() {
        return libelleEntrepot;
    }

    public void setLibelleEntrepot(String libelleEntrepot) {
        this.libelleEntrepot = libelleEntrepot;
    }

    public int getNumRueEntrepot() {
        return numRueEntrepot;
    }

    public void setNumRueEntrepot(int numRueEntrepot) {
        this.numRueEntrepot = numRueEntrepot;
    }

    public String getNomRueEntrepot() {
        return nomRueEntrepot;
    }

    public void setNomRueEntrepot(String nomRueEntrepot) {
        this.nomRueEntrepot = nomRueEntrepot;
    }

    public int getCpEntrepot() {
        return cpEntrepot;
    }

    public void setCpEntrepot(int cpEntrepot) {
        this.cpEntrepot = cpEntrepot;
    }

    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    public Utilisateur getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Utilisateur idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrepot != null ? idEntrepot.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrepot)) {
            return false;
        }
        Entrepot other = (Entrepot) object;
        if ((this.idEntrepot == null && other.idEntrepot != null) || (this.idEntrepot != null && !this.idEntrepot.equals(other.idEntrepot))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Entrepot[ idEntrepot=" + idEntrepot + " ]";
    }
    
}
