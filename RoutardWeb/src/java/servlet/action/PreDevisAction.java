package servlet.action;

import javax.servlet.http.HttpServletRequest;
import metier.modele.Voyage;
import metier.service.ServiceVoyage;

/**
 *
 * @author Slifer
 */
public class PreDevisAction extends Action{

    @Override
    public void execute(HttpServletRequest request) {
       String id = request.getParameter("todo");
       Voyage reponse = ServiceVoyage.obtenirVoyageParCode(id);
       request.setAttribute("voyageDevis",reponse);
    }
    
}
