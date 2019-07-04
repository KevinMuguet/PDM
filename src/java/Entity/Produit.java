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
@Table(name = "Produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findByIdProduit", query = "SELECT p FROM Produit p WHERE p.idProduit = :idProduit"),
    @NamedQuery(name = "Produit.findByNom", query = "SELECT p FROM Produit p WHERE p.nom = :nom"),
    @NamedQuery(name = "Produit.findByDescription", query = "SELECT p FROM Produit p WHERE p.description = :description"),
    @NamedQuery(name = "Produit.findByCaracteristiques", query = "SELECT p FROM Produit p WHERE p.caracteristiques = :caracteristiques"),
    @NamedQuery(name = "Produit.findByPrix", query = "SELECT p FROM Produit p WHERE p.prix = :prix"),
    @NamedQuery(name = "Produit.findByProduitImg", query = "SELECT p FROM Produit p WHERE p.produitImg = :produitImg"),
    @NamedQuery(name = "Produit.findByQteStock", query = "SELECT p FROM Produit p WHERE p.qteStock = :qteStock"),
    @NamedQuery(name = "Produit.findByEnLigne", query = "SELECT p FROM Produit p WHERE p.enLigne = :enLigne"),
    @NamedQuery(name = "Produit.findByTypeProduit", query = "SELECT p FROM Produit p WHERE p.typeProduit = :typeProduit")})
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produit")
    private Integer idProduit;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "caracteristiques")
    private String caracteristiques;
    @Basic(optional = false)
    @Column(name = "prix")
    private String prix;
    @Basic(optional = false)
    @Column(name = "produit_img")
    private String produitImg;
    @Basic(optional = false)
    @Column(name = "qte_stock")
    private int qteStock;
    @Basic(optional = false)
    @Column(name = "en_ligne")
    private String enLigne;
    @Basic(optional = false)
    @Column(name = "type_produit")
    private String typeProduit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduit")
    private Collection<Avis> avisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<Evenement> evenementCollection;
    @JoinColumn(name = "id_marque", referencedColumnName = "id_marque")
    @ManyToOne(optional = false)
    private Marque idMarque;
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie")
    @ManyToOne(optional = false)
    private Categorie idCategorie;
    @JoinColumn(name = "id_entrepot", referencedColumnName = "id_entrepot")
    @ManyToOne(optional = false)
    private Entrepot idEntrepot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<ProduitCommande> produitCommandeCollection;

    public Produit() {
    }

    public Produit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Produit(Integer idProduit, String nom, String description, String caracteristiques, String prix, String produitImg, int qteStock, String enLigne, String typeProduit) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.description = description;
        this.caracteristiques = caracteristiques;
        this.prix = prix;
        this.produitImg = produitImg;
        this.qteStock = qteStock;
        this.enLigne = enLigne;
        this.typeProduit = typeProduit;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(String caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getProduitImg() {
        return produitImg;
    }

    public void setProduitImg(String produitImg) {
        this.produitImg = produitImg;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public String getEnLigne() {
        return enLigne;
    }

    public void setEnLigne(String enLigne) {
        this.enLigne = enLigne;
    }

    public String getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(String typeProduit) {
        this.typeProduit = typeProduit;
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

    public Marque getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Marque idMarque) {
        this.idMarque = idMarque;
    }

    public Categorie getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Categorie idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Entrepot getIdEntrepot() {
        return idEntrepot;
    }

    public void setIdEntrepot(Entrepot idEntrepot) {
        this.idEntrepot = idEntrepot;
    }

    @XmlTransient
    public Collection<ProduitCommande> getProduitCommandeCollection() {
        return produitCommandeCollection;
    }

    public void setProduitCommandeCollection(Collection<ProduitCommande> produitCommandeCollection) {
        this.produitCommandeCollection = produitCommandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduit != null ? idProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Produit[ idProduit=" + idProduit + " ]";
    }
    
}
