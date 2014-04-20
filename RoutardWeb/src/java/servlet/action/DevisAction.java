/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.action;

import javax.servlet.http.HttpServletRequest;
import metier.modele.Depart;

/**
 *
 * @author Slifer
 */
public class DevisAction extends Action {

    @Override
    public void execute(HttpServletRequest request) {
        int nbPersonnes;
        nbPersonnes = Integer.parseInt(request.getParameter("Personnes"));
        int idDepart =  Integer.parseInt(request.getParameter("Depart"));    
    }
}
