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

/**
 *
 * @author Joker
 */
@Stateless
public class InsertEntity {
   
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AmazonProjectPU");
   
    @PersistenceContext
    EntityManager em = entityManagerFactory.createEntityManager();

    @Resource    
    public UserTransaction utx;
    
   public InsertEntity(){}
   
   

   public boolean createUser(){
   
        try {
            utx.begin();
            Utilisateur newUser = new Utilisateur();
            
            newUser.setNom("Hitema10");
            newUser.setPwd("pwd");
            newUser.setEmail("email");
            newUser.setLogin("login");
            newUser.setTypeUtilisateur("supadmin");
            em.persist(newUser);
            utx.commit();
            
            
        }catch(Exception e){
         e.printStackTrace();
        }
        return true;
    }
    
}
