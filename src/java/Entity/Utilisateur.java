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
@Table(name = "Utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findById", query = "SELECT u FROM Utilisateur u WHERE u.id = :id"),
    @NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login"),
    @NamedQuery(name = "Utilisateur.findByPwd", query = "SELECT u FROM Utilisateur u WHERE u.pwd = :pwd"),
    @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom"),
    @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email"),
    @NamedQuery(name = "Utilisateur.findByNumMobile", query = "SELECT u FROM Utilisateur u WHERE u.numMobile = :numMobile"),
    @NamedQuery(name = "Utilisateur.findByNumRue", query = "SELECT u FROM Utilisateur u WHERE u.numRue = :numRue"),
    @NamedQuery(name = "Utilisateur.findByNomRue", query = "SELECT u FROM Utilisateur u WHERE u.nomRue = :nomRue"),
    @NamedQuery(name = "Utilisateur.findByCodePostal", query = "SELECT u FROM Utilisateur u WHERE u.codePostal = :codePostal"),
    @NamedQuery(name = "Utilisateur.findByPays", query = "SELECT u FROM Utilisateur u WHERE u.pays = :pays"),
    @NamedQuery(name = "Utilisateur.findByAdmin", query = "SELECT u FROM Utilisateur u WHERE u.admin = :admin"),
    @NamedQuery(name = "Utilisateur.findByDateCreation", query = "SELECT u FROM Utilisateur u WHERE u.dateCreation = :dateCreation"),
    @NamedQuery(name = "Utilisateur.findByClefSb", query = "SELECT u FROM Utilisateur u WHERE u.clefSb = :clefSb"),
    @NamedQuery(name = "Utilisateur.findByCptBloque", query = "SELECT u FROM Utilisateur u WHERE u.cptBloque = :cptBloque"),
    @NamedQuery(name = "Utilisateur.findByNumRueLiv", query = "SELECT u FROM Utilisateur u WHERE u.numRueLiv = :numRueLiv"),
    @NamedQuery(name = "Utilisateur.findByNomRueLiv", query = "SELECT u FROM Utilisateur u WHERE u.nomRueLiv = :nomRueLiv"),
    @NamedQuery(name = "Utilisateur.findByCpLiv", query = "SELECT u FROM Utilisateur u WHERE u.cpLiv = :cpLiv"),
    @NamedQuery(name = "Utilisateur.findByPaysLiv", query = "SELECT u FROM Utilisateur u WHERE u.paysLiv = :paysLiv"),
    @NamedQuery(name = "Utilisateur.findBySiret", query = "SELECT u FROM Utilisateur u WHERE u.siret = :siret"),
    @NamedQuery(name = "Utilisateur.findByCptValide", query = "SELECT u FROM Utilisateur u WHERE u.cptValide = :cptValide"),
    @NamedQuery(name = "Utilisateur.findByScoreQualite", query = "SELECT u FROM Utilisateur u WHERE u.scoreQualite = :scoreQualite"),
    @NamedQuery(name = "Utilisateur.findByTypeUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.typeUtilisateur = :typeUtilisateur")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "pwd")
    private String pwd;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "num_mobile")
    private String numMobile;
    @Basic(optional = false)
    @Column(name = "num_rue")
    private String numRue;
    @Basic(optional = false)
    @Column(name = "nom_rue")
    private String nomRue;
    @Basic(optional = false)
    @Column(name = "code_postal")
    private int codePostal;
    @Basic(optional = false)
    @Column(name = "pays")
    private String pays;
    @Basic(optional = false)
    @Column(name = "admin")
    private String admin;
    @Basic(optional = false)
    @Column(name = "date_creation")
    private String dateCreation;
    @Basic(optional = false)
    @Column(name = "clef_sb")
    private String clefSb;
    @Basic(optional = false)
    @Column(name = "cpt_bloque")
    private boolean cptBloque;
    @Column(name = "num_rue_liv")
    private String numRueLiv;
    @Column(name = "nom_rue_liv")
    private String nomRueLiv;
    @Column(name = "cp_liv")
    private Integer cpLiv;
    @Column(name = "pays_liv")
    private String paysLiv;
    @Column(name = "siret")
    private String siret;
    @Column(name = "cpt_valide")
    private String cptValide;
    @Column(name = "score_qualite")
    private Integer scoreQualite;
    @Basic(optional = false)
    @Column(name = "type_utilisateur")
    private String typeUtilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<Avis> avisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Evenement> evenementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<Commande> commandeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFournisseur")
    private Collection<Entrepot> entrepotCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
    private Collection<CompteBancaire> compteBancaireCollection;

    public Utilisateur() {
    }

    public Utilisateur(Integer id) {
        this.id = id;
    }

    public Utilisateur(Integer id, String login, String pwd, String nom, String prenom, String email, String numMobile, String numRue, String nomRue, int codePostal, String pays, String admin, String dateCreation, String clefSb, boolean cptBloque, String typeUtilisateur) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numMobile = numMobile;
        this.numRue = numRue;
        this.nomRue = nomRue;
        this.codePostal = codePostal;
        this.pays = pays;
        this.admin = admin;
        this.dateCreation = dateCreation;
        this.clefSb = clefSb;
        this.cptBloque = cptBloque;
        this.typeUtilisateur = typeUtilisateur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumMobile() {
        return numMobile;
    }

    public void setNumMobile(String numMobile) {
        this.numMobile = numMobile;
    }

    public String getNumRue() {
        return numRue;
    }

    public void setNumRue(String numRue) {
        this.numRue = numRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getClefSb() {
        return clefSb;
    }

    public void setClefSb(String clefSb) {
        this.clefSb = clefSb;
    }

    public boolean getCptBloque() {
        return cptBloque;
    }

    public void setCptBloque(boolean cptBloque) {
        this.cptBloque = cptBloque;
    }

    public String getNumRueLiv() {
        return numRueLiv;
    }

    public void setNumRueLiv(String numRueLiv) {
        this.numRueLiv = numRueLiv;
    }

    public String getNomRueLiv() {
        return nomRueLiv;
    }

    public void setNomRueLiv(String nomRueLiv) {
        this.nomRueLiv = nomRueLiv;
    }

    public Integer getCpLiv() {
        return cpLiv;
    }

    public void setCpLiv(Integer cpLiv) {
        this.cpLiv = cpLiv;
    }

    public String getPaysLiv() {
        return paysLiv;
    }

    public void setPaysLiv(String paysLiv) {
        this.paysLiv = paysLiv;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
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

    public String getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(String typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

    @XmlTransient
    public Collection<Avis> getAvisCollection() {
        return avisCollection;
    }

    public void setAvisCollection(Collection<Avis> avisCollection) {
        this.avisCollection = avisCollection;
    }

    @XmlTransient
    public Collection<Evenement> getEvenementCollection() {
        return evenementCollection;
    }

    public void setEvenementCollection(Collection<Evenement> evenementCollection) {
        this.evenementCollection = evenementCollection;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @XmlTransient
    public Collection<Entrepot> getEntrepotCollection() {
        return entrepotCollection;
    }

    public void setEntrepotCollection(Collection<Entrepot> entrepotCollection) {
        this.entrepotCollection = entrepotCollection;
    }

    @XmlTransient
    public Collection<CompteBancaire> getCompteBancaireCollection() {
        return compteBancaireCollection;
    }

    public void setCompteBancaireCollection(Collection<CompteBancaire> compteBancaireCollection) {
        this.compteBancaireCollection = compteBancaireCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Utilisateur[ id=" + id + " ]";
    }
    
}
