/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joker
 */
public class Connexion extends HttpServlet {
    
        WebService.Utilisateur wsUtilisateur = new WebService.Utilisateur();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // permet de décoder les paramètres en UTF-8
        request.setCharacterEncoding("UTF-8") ;

        RequestDispatcher rd = request.getRequestDispatcher("/valider.jsp") ;

        String login = request.getParameter("Email") ;
        String Password = request.getParameter("Password") ;

        request.setAttribute("connexionSuccess",wsUtilisateur.connexionUser(login, Password)) ;

        rd.forward(request, response) ;
    }

}
