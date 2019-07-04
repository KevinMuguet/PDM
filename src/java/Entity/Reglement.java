/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joker
 */
@Entity
@Table(name = "Reglement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reglement.findAll", query = "SELECT r FROM Reglement r"),
    @NamedQuery(name = "Reglement.findByIdReglement", query = "SELECT r FROM Reglement r WHERE r.idReglement = :idReglement"),
    @NamedQuery(name = "Reglement.findByNumCarte", query = "SELECT r FROM Reglement r WHERE r.numCarte = :numCarte"),
    @NamedQuery(name = "Reglement.findByNumCryptogramme", query = "SELECT r FROM Reglement r WHERE r.numCryptogramme = :numCryptogramme"),
    @NamedQuery(name = "Reglement.findByDateFinValidite", query = "SELECT r FROM Reglement r WHERE r.dateFinValidite = :dateFinValidite")})
public class Reglement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reglement")
    private Integer idReglement;
    @Basic(optional = false)
    @Column(name = "num_carte")
    private int numCarte;
    @Basic(optional = false)
    @Column(name = "num_cryptogramme")
    private int numCryptogramme;
    @Basic(optional = false)
    @Column(name = "date_fin_validite")
    @Temporal(TemporalType.DATE)
    private Date dateFinValidite;
    @JoinColumn(name = "id_commande", referencedColumnName = "id_commande")
    @ManyToOne(optional = false)
    private Commande idCommande;

    public Reglement() {
    }

    public Reglement(Integer idReglement) {
        this.idReglement = idReglement;
    }

    public Reglement(Integer idReglement, int numCarte, int numCryptogramme, Date dateFinValidite) {
        this.idReglement = idReglement;
        this.numCarte = numCarte;
        this.numCryptogramme = numCryptogramme;
        this.dateFinValidite = dateFinValidite;
    }

    public Integer getIdReglement() {
        return idReglement;
    }

    public void setIdReglement(Integer idReglement) {
        this.idReglement = idReglement;
    }

    public int getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(int numCarte) {
        this.numCarte = numCarte;
    }

    public int getNumCryptogramme() {
        return numCryptogramme;
    }

    public void setNumCryptogramme(int numCryptogramme) {
        this.numCryptogramme = numCryptogramme;
    }

    public Date getDateFinValidite() {
        return dateFinValidite;
    }

    public void setDateFinValidite(Date dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }

    public Commande getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Commande idCommande) {
        this.idCommande = idCommande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReglement != null ? idReglement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reglement)) {
            return false;
        }
        Reglement other = (Reglement) object;
        if ((this.idReglement == null && other.idReglement != null) || (this.idReglement != null && !this.idReglement.equals(other.idReglement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Reglement[ idReglement=" + idReglement + " ]";
    }
    
}
