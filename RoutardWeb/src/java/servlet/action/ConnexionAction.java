package servlet.action;

import javax.servlet.http.HttpServletRequest;
import metier.modele.Client;
import metier.service.ServiceClient;

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
        request.setAttribute("Validation", "true");  // OK
        }
       }
       else
       {
        request.setAttribute("Validation", "false");
       }
    }
    
    
    
}