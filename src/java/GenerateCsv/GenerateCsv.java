/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenerateCsv;

import classBdd.Utilisateur;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Joker
 */
public class GenerateCsv {
    
    public void createCsvClient() {
        try {
          PrintWriter pw = new PrintWriter(new File("C:\\Users\\Joker\\Documents\\ClientAmazon.csv"));
          
          WebService.ToolWebService wsTool = new WebService.ToolWebService();
          List<Utilisateur> listUser = wsTool.getAllUser();
          
          StringBuilder sb = new StringBuilder();
                sb.append("Nom");
                sb.append(",");
                sb.append("Prenom");
                sb.append(",");
                sb.append("Email");
                sb.append(",");
                sb.append("Telephone");
                sb.append("\r\n"); 
            for(Utilisateur u : listUser){
                sb.append(u.getNom());
                sb.append(",");
                sb.append(u.getPrenom());
                sb.append(",");
                sb.append(u.getEmail());
                sb.append(",");
                sb.append(u.getNumMobile());
                sb.append("\r\n");
            }
          
          pw.write(sb.toString());
          pw.close();
          System.out.println("finished");
          } catch (Exception e) {
             e.getStackTrace();
          }
       }
}

