/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author Joker
 */
@WebService(serviceName = "Utilisateur")
public class Utilisateur {
    
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AmazonProjectPU");
    EntityManager emUtilidateur = entityManagerFactory.createEntityManager();

    
    @WebMethod(operationName = "connexionUser")
    public boolean connexionUser(@WebParam(name = "email") String email, @WebParam(name = "pwd") String pwd ){
        classBdd.Utilisateur user = null;
        try{
           user = (classBdd.Utilisateur) emUtilidateur.createNamedQuery("Utilisateur.connexion").setParameter("email", email).setParameter("pwd", pwd).getSingleResult();
        }catch(NoResultException e){}
        if(user != null)
           return true;
       
        else return false;
       
    }
}
