/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.modele.Circuit;
import metier.modele.Sejour;
import metier.service.ServiceVoyage;

/**
 *
 * @author Slifer
 */
public class RechercheVoyageAction extends Action{

    @Override
    public void execute(HttpServletRequest request) {
       
       String type = request.getParameter("RechercheVoyage");
       if ("circuit".equals(type))
       {
           List<Circuit> listeVoyage = ServiceVoyage.obtenirCircuits();
           request.setAttribute("List",listeVoyage);
       }
       else
       {
           List<Sejour> listeVoyage = ServiceVoyage.obtenirSejours();
           request.setAttribute("List",listeVoyage);
       }
    }
    
    
}
