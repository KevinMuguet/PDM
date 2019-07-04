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
@Table(name = "Avis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avis.findAll", query = "SELECT a FROM Avis a"),
    @NamedQuery(name = "Avis.findByIdAvis", query = "SELECT a FROM Avis a WHERE a.idAvis = :idAvis"),
    @NamedQuery(name = "Avis.findByCommentaires", query = "SELECT a FROM Avis a WHERE a.commentaires = :commentaires"),
    @NamedQuery(name = "Avis.findByNote", query = "SELECT a FROM Avis a WHERE a.note = :note")})
public class Avis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_avis")
    private Integer idAvis;
    @Basic(optional = false)
    @Column(name = "commentaires")
    private String commentaires;
    @Basic(optional = false)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit")
    @ManyToOne(optional = false)
    private Produit idProduit;
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Utilisateur idClient;

    public Avis() {
    }

    public Avis(Integer idAvis) {
        this.idAvis = idAvis;
    }

    public Avis(Integer idAvis, String commentaires, String note) {
        this.idAvis = idAvis;
        this.commentaires = commentaires;
        this.note = note;
    }

    public Integer getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(Integer idAvis) {
        this.idAvis = idAvis;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Produit getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Produit idProduit) {
        this.idProduit = idProduit;
    }

    public Utilisateur getIdClient() {
        return idClient;
    }

    public void setIdClient(Utilisateur idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvis != null ? idAvis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avis)) {
            return false;
        }
        Avis other = (Avis) object;
        if ((this.idAvis == null && other.idAvis != null) || (this.idAvis != null && !this.idAvis.equals(other.idAvis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Avis[ idAvis=" + idAvis + " ]";
    }
    
}
