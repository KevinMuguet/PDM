/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import classBdd.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joker
 */
public class singleProduitServlet extends HttpServlet {


   
WebService.ProduitService wsProduit = new WebService.ProduitService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            int idProduit = Integer.parseInt(request.getParameter("idProduit"));

            RequestDispatcher rd = request.getRequestDispatcher("/single.jsp") ;
            List<Produit> produit = wsProduit.getProduitById(idProduit);
            request.setAttribute("singleResultat",produit);
            
            rd.forward(request, response) ;

        
    }
}