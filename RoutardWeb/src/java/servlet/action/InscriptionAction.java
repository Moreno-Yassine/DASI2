/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.action;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import metier.service.ServiceClient;
import metier.modele.Client;
import util.LectureDonneesCsv;

/**
 *
 * @author Slifer
 */
public class InscriptionAction extends Action {
    @Override
    public void execute(HttpServletRequest request)
    {
        String civ = request.getParameter("civilite");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");
        String mail = request.getParameter("mail");
        String tel = request.getParameter("tel");
        String mdp = request.getParameter("mdp");
        Date dateDeNaissance = LectureDonneesCsv.parseDate(request.getParameter("annee")+"-"+request.getParameter("mois")+"-"+request.getParameter("jour"));
        Client c = new Client(nom,prenom,Client.Civilite.fromString(civ),dateDeNaissance,tel,mail,adresse,mdp);
        System.out.println(c.getNom());
        
        ServiceClient.creerClient(c);  
    }
    
}
