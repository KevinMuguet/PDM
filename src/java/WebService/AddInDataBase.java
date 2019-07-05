/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import SessionBean.Insert.UtilisateurFacade;
import classBdd.Utilisateur;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import transaction.InsertEntity;

/**
 *
 * @author Joker
 */
@WebService(serviceName = "AddInDataBase")
public class AddInDataBase {

   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AmazonProjectPU");
   EntityManager em = entityManagerFactory.createEntityManager();
 
       
    @WebMethod(operationName = "addUser")
    public boolean addUser(){
       InsertEntity insert = new InsertEntity();
       return insert.createUser();
    }
}
