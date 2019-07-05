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

/**
 *
 * @author Joker
 */
@WebService(serviceName = "NewWebService")
@Stateless()
public class NewWebService {
    
    @EJB
    private UtilisateurFacade userFacade;
    
    @WebMethod(operationName = "hello")
    public int hello() {
        try {
            
            Utilisateur newUser = new Utilisateur();
            
            newUser.setNom("Hitema11");
            newUser.setPwd("pwd");
            newUser.setEmail("email");
            newUser.setLogin("login");
            newUser.setTypeUtilisateur("supadmin");
            userFacade.create(newUser);
            /*UtilisateurFacade user.c
            user.create(newUser);
            return user.count();*/
            
            
        }catch(Exception e){
         e.printStackTrace();
        }
        return 0;
    }
}
