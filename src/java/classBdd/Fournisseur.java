/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classBdd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joker
 */
@Entity
@Table(name = "Fournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f"),
    @NamedQuery(name = "Fournisseur.findByIdFournisseur", query = "SELECT f FROM Fournisseur f WHERE f.idFournisseur = :idFournisseur"),
    @NamedQuery(name = "Fournisseur.findByCptValide", query = "SELECT f FROM Fournisseur f WHERE f.cptValide = :cptValide"),
    @NamedQuery(name = "Fournisseur.findByScoreQualite", query = "SELECT f FROM Fournisseur f WHERE f.scoreQualite = :scoreQualite"),
    @NamedQuery(name = "Fournisseur.findBySiret", query = "SELECT f FROM Fournisseur f WHERE f.siret = :siret"),
    @NamedQuery(name = "Fournisseur.findByTauxInteret", query = "SELECT f FROM Fournisseur f WHERE f.tauxInteret = :tauxInteret")})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fournisseur")
    private Integer idFournisseur;
    @Column(name = "cpt_valide")
    private String cptValide;
    @Column(name = "score_qualite")
    private Integer scoreQualite;
    @Column(name = "siret")
    private String siret;
    @Column(name = "taux_interet")
    private Integer tauxInteret;

    public Fournisseur() {
    }

    public Fournisseur(Integer idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public Integer getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Integer idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getCptValide() {
        return cptValide;
    }

    public void setCptValide(String cptValide) {
        this.cptValide = cptValide;
    }

    public Integer getScoreQualite() {
        return scoreQualite;
    }

    public void setScoreQualite(Integer scoreQualite) {
        this.scoreQualite = scoreQualite;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public Integer getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Integer tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFournisseur != null ? idFournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.idFournisseur == null && other.idFournisseur != null) || (this.idFournisseur != null && !this.idFournisseur.equals(other.idFournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Fournisseur[ idFournisseur=" + idFournisseur + " ]";
    }
    
}
