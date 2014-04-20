package servlet.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import metier.modele.Client;
import metier.modele.Pays;
import metier.service.ServiceClient;
import metier.service.ServiceVoyage;

/**
 *
 * @author Administrateur
 */
public class ConnexionAction extends Action{

    @Override
    public void execute(HttpServletRequest request) {
       String id = request.getParameter("Identifiant");
       String pw = request.getParameter("MotdePasse");
       Client client = ServiceClient.obtenirClientParEmail(id);
       if (client != null)
       {
        if(ServiceClient.testerMotDePasse(client, pw) == false){
        request.setAttribute("Validation", "false"); // ERREUR
        }
        else if (ServiceClient.testerMotDePasse(client, pw) == true) {
        HttpSession session = request.getSession(true);
        session.setAttribute("loggedUser", client);
        request.setAttribute("Validation", "true");  // OK
        List<Pays> affichePays = ServiceVoyage.obtenirPays();
        request.setAttribute("AffichagePays",affichePays);
        }
       }
       else
       {
        request.setAttribute("Validation", "false");
       }
    }
    
    
    
}