/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import classBdd.Utilisateur;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;


public class InsertEntity {
   
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AmazonProjectPU");
    EntityManager em = entityManagerFactory.createEntityManager();

    @Resource    
    public UserTransaction utx;
    
   public InsertEntity(){}
   
   

   public boolean createUser(){
        try {
            
            Utilisateur newUser = new Utilisateur();
            
            newUser.setNom("Hitema11");
            newUser.setPwd("pwd");
            newUser.setEmail("email");
            newUser.setLogin("login");
            newUser.setTypeUtilisateur("supadmin");
            em.getTransaction().begin();
            em.persist(newUser);
            em.getTransaction().commit();
            
            
        }catch(Exception e){
         e.printStackTrace();
        }
        return true;
    }
    
}
