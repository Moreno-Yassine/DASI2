/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.action;

import javax.servlet.http.HttpServletRequest;
import metier.service.ServiceClient;

/**
 *
 * @author Slifer
 */
public class InscriptionAction extends Action {
    protected ServiceClient service;
    @Override
    public void execute(HttpServletRequest request)
    {
        String var = (String) request.getAttribute("todo");
        if ("Inscription".equals(var)) // ActionServlet => PageInscription
        {
            // RAS
        }
        else if("Validation".equals(var)) //<= PageInscription
        {
            // Créer Client
        }
    }
    
}
