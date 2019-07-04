/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Joker
 */
@WebService(serviceName = "Produit")
public class Produit {

   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AmazonProjectPU");
   EntityManager em = entityManagerFactory.createEntityManager();
     
    
    @WebMethod(operationName = "GetAllProduit")
    public List<classBdd.Produit> getAllProduit() {
        
        return em.createNamedQuery("Produit.findAll").getResultList();
    
    }
    
    @WebMethod(operationName = "GetAllProduitByCat")
    public List<classBdd.Produit> getAllProduitByCat(@WebParam(name = "id") Integer id) {
        
        return em.createNamedQuery("Produit.findByCat").setParameter("idCategorie", id).getResultList();
    
    }
}
