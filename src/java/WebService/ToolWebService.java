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
@WebService(serviceName = "ToolWebService")
public class ToolWebService {
    
   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AmazonProjectPU");
   EntityManager em = entityManagerFactory.createEntityManager();
 
    @WebMethod(operationName = "GetAllUser")
    public List<classBdd.Utilisateur> getAllUser() {
        
        return em.createNamedQuery("Utilisateur.findAll").getResultList();
    
    }
}
