/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import metier.modele.Client;
import metier.modele.Conseiller;
import metier.modele.Depart;
import metier.modele.Devis;
import metier.modele.Voyage;
import metier.service.ServiceDevis;
import metier.service.ServiceEmploye;
import metier.service.ServiceVoyage;

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
        
        Depart d = ServiceVoyage.obtenirDepartId(idDepart);
        Voyage v = d.getVoyage();
        HttpSession session = request.getSession(false);
        Client c = (Client)session.getAttribute("loggedUser");
        Conseiller cons = ServiceEmploye.obtenirSpecialiste(v.getDestination());
        
        Devis devisCourant = new Devis(c,d,nbPersonnes,cons);// Création du DEVIS
        request.setAttribute("devis",devisCourant);
        request.setAttribute("voyage", v);
        ServiceDevis.creerDevis(devisCourant);
    }
}
