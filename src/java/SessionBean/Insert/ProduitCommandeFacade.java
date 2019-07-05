/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean.Insert;

import classBdd.ProduitCommande;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Joker
 */
@Stateless
public class ProduitCommandeFacade extends AbstractFacade<ProduitCommande> {

    @PersistenceContext(unitName = "AmazonProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitCommandeFacade() {
        super(ProduitCommande.class);
    }
    
}
