/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.modele.Pays;
import metier.modele.Voyage;
import metier.service.ServiceVoyage;

/**
 *
 * @author Slifer
 */
public class RecherchePaysAction extends Action {

    @Override
    public void execute(HttpServletRequest request) {
       String pays = request.getParameter("RecherchePays");
       Pays p = ServiceVoyage.obtenirPays(pays);
       if (p!=null)
       {
           request.setAttribute("Trouve","true");
           request.setAttribute("Pays",p);
           List<Voyage> listeVoyage = ServiceVoyage.obtenirVoyagesParDestination(p);
           request.setAttribute("List",listeVoyage);
       }
       else
       {
           request.setAttribute("Trouve","false");
       }
    }
    
}
