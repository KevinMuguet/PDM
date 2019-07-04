/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Marque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marque.findAll", query = "SELECT m FROM Marque m"),
    @NamedQuery(name = "Marque.findByIdMarque", query = "SELECT m FROM Marque m WHERE m.idMarque = :idMarque"),
    @NamedQuery(name = "Marque.findByLibelleMarque", query = "SELECT m FROM Marque m WHERE m.libelleMarque = :libelleMarque")})
public class Marque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_marque")
    private Integer idMarque;
    @Basic(optional = false)
    @Column(name = "libelle_marque")
    private String libelleMarque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarque")
    private Collection<Produit> produitCollection;

    public Marque() {
    }

    public Marque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public Marque(Integer idMarque, String libelleMarque) {
        this.idMarque = idMarque;
        this.libelleMarque = libelleMarque;
    }

    public Integer getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public String getLibelleMarque() {
        return libelleMarque;
    }

    public void setLibelleMarque(String libelleMarque) {
        this.libelleMarque = libelleMarque;
    }

    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarque != null ? idMarque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marque)) {
            return false;
        }
        Marque other = (Marque) object;
        if ((this.idMarque == null && other.idMarque != null) || (this.idMarque != null && !this.idMarque.equals(other.idMarque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Marque[ idMarque=" + idMarque + " ]";
    }
    
}
