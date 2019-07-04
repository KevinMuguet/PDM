/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import java.util.List;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Joker
 */

@WebService(serviceName = "Produit")
public class ProduitService {
    
   
   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AmazonProjectPU");
   
   @PersistenceContext
   EntityManager em = entityManagerFactory.createEntityManager();
     
    
    @WebMethod(operationName = "GetAllProduit")
    public List<classBdd.Produit> getAllProduit() {
        
        return em.createNamedQuery("Produit.findAll").getResultList();
    
    }
    
    @WebMethod(operationName = "GetAllProduitByCat")
    public List<classBdd.Produit> getAllProduitByCat(@WebParam(name = "id") Integer id) {
        
        return em.createNamedQuery("Produit.findByCat").setParameter("idCategorie", id).getResultList();
    
    }
    
    
    @Resource
    UserTransaction utx;
    
    @WebMethod(operationName = "insertBrand")
    public boolean insertBrand (@WebParam(name = "name") String marque) {
         
         
        //EntityTransaction transac = em.getTransaction();
        try{
            utx.begin();
        
        classBdd.Marque newMarque = new classBdd.Marque();
        newMarque.setLibelleMarque(marque);
        em.persist(newMarque);
        utx.commit();
        em.close(); 
        entityManagerFactory.close();
        }catch(NullPointerException | IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException e){}
        return true;
    }
    @Resource
    UserTransaction utx2;
    
    @WebMethod(operationName = "insertUser")
    public boolean insertUser (@WebParam(name = "name") String nom, @WebParam(name = "pwd") String pwd, @WebParam(name = "email") String email) {
        
        try {
            utx2.begin();
            classBdd.Utilisateur newUser = new classBdd.Utilisateur();
            
            newUser.setNom(nom);
            newUser.setPwd(pwd);
            newUser.setLogin(email);
            newUser.setTypeUtilisateur(email);
            em.persist(newUser);
            utx2.commit();
            em.close(); 
            entityManagerFactory.close();
            
            
        }catch(NullPointerException | IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException e){}
        return true;
            
        
        
    }
    
    
    
}
