/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joker
 */
@Entity
@Table(name = "Compte_Bancaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompteBancaire.findAll", query = "SELECT c FROM CompteBancaire c"),
    @NamedQuery(name = "CompteBancaire.findByIdCompte", query = "SELECT c FROM CompteBancaire c WHERE c.idCompte = :idCompte"),
    @NamedQuery(name = "CompteBancaire.findByBic", query = "SELECT c FROM CompteBancaire c WHERE c.bic = :bic"),
    @NamedQuery(name = "CompteBancaire.findByIban", query = "SELECT c FROM CompteBancaire c WHERE c.iban = :iban"),
    @NamedQuery(name = "CompteBancaire.findByNomTitulaireCompte", query = "SELECT c FROM CompteBancaire c WHERE c.nomTitulaireCompte = :nomTitulaireCompte"),
    @NamedQuery(name = "CompteBancaire.findByPrenomTitulaireCompte", query = "SELECT c FROM CompteBancaire c WHERE c.prenomTitulaireCompte = :prenomTitulaireCompte")})
public class CompteBancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compte")
    private Integer idCompte;
    @Basic(optional = false)
    @Column(name = "bic")
    private int bic;
    @Basic(optional = false)
    @Column(name = "iban")
    private int iban;
    @Basic(optional = false)
    @Column(name = "nom_titulaire_compte")
    private String nomTitulaireCompte;
    @Basic(optional = false)
    @Column(name = "prenom_titulaire_compte")
    private String prenomTitulaireCompte;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Utilisateur idUtilisateur;

    public CompteBancaire() {
    }

    public CompteBancaire(Integer idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBancaire(Integer idCompte, int bic, int iban, String nomTitulaireCompte, String prenomTitulaireCompte) {
        this.idCompte = idCompte;
        this.bic = bic;
        this.iban = iban;
        this.nomTitulaireCompte = nomTitulaireCompte;
        this.prenomTitulaireCompte = prenomTitulaireCompte;
    }

    public Integer getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Integer idCompte) {
        this.idCompte = idCompte;
    }

    public int getBic() {
        return bic;
    }

    public void setBic(int bic) {
        this.bic = bic;
    }

    public int getIban() {
        return iban;
    }

    public void setIban(int iban) {
        this.iban = iban;
    }

    public String getNomTitulaireCompte() {
        return nomTitulaireCompte;
    }

    public void setNomTitulaireCompte(String nomTitulaireCompte) {
        this.nomTitulaireCompte = nomTitulaireCompte;
    }

    public String getPrenomTitulaireCompte() {
        return prenomTitulaireCompte;
    }

    public void setPrenomTitulaireCompte(String prenomTitulaireCompte) {
        this.prenomTitulaireCompte = prenomTitulaireCompte;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompte != null ? idCompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire other = (CompteBancaire) object;
        if ((this.idCompte == null && other.idCompte != null) || (this.idCompte != null && !this.idCompte.equals(other.idCompte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CompteBancaire[ idCompte=" + idCompte + " ]";
    }
    
}
