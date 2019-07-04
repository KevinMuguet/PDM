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
@Table(name = "Client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Client.findByCpLiv", query = "SELECT c FROM Client c WHERE c.cpLiv = :cpLiv"),
    @NamedQuery(name = "Client.findByNomRueLiv", query = "SELECT c FROM Client c WHERE c.nomRueLiv = :nomRueLiv"),
    @NamedQuery(name = "Client.findByNumRueLiv", query = "SELECT c FROM Client c WHERE c.numRueLiv = :numRueLiv")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client")
    private Integer idClient;
    @Column(name = "cp_liv")
    private Integer cpLiv;
    @Column(name = "nom_rue_liv")
    private String nomRueLiv;
    @Column(name = "num_rue_liv")
    private String numRueLiv;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getCpLiv() {
        return cpLiv;
    }

    public void setCpLiv(Integer cpLiv) {
        this.cpLiv = cpLiv;
    }

    public String getNomRueLiv() {
        return nomRueLiv;
    }

    public void setNomRueLiv(String nomRueLiv) {
        this.nomRueLiv = nomRueLiv;
    }

    public String getNumRueLiv() {
        return numRueLiv;
    }

    public void setNumRueLiv(String numRueLiv) {
        this.numRueLiv = numRueLiv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Client[ idClient=" + idClient + " ]";
    }
    
}
