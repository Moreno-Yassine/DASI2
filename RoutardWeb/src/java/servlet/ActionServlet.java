/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.action.Action;
import servlet.action.InscriptionAction;

/**
 *
 * @author Slifer
 */
public class ActionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperer la requete HTTP
        String tache = request.getParameter("todo");
        // identification de la tâche
        Action actionCourante = this.getAction(tache);
        
        if (actionCourante!=null)
        {
        actionCourante.execute(request);
        }
        
        String vue = this.setVue(tache);
        
        request.getRequestDispatcher(vue).forward(request,response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Action getAction(String todo) {
        Action action = null;
        if ("Inscription".equals(todo))
        {
           // Redirection vers Inscription.html (vue)
        }
        else if ("Connexion".equals(todo))
        {
           //action = new ConnexionAction();
        }
        else if ("Retour".equals(todo))
        {
            //NOTHING
        }
        else if ("Validation".equals(todo))
        {
            action = new InscriptionAction();
        }
        return action;
    }

    private String setVue(String todo) {
        String vue = null;
        if ("Inscription".equals(todo))
        {
           // Redirection vers Inscription.html (vue)
            vue = "/InscriptionVue";
        }
        else if ("Connexion".equals(todo))
        {
           
        }
        else if ("Retour".equals(todo))
        {
            vue = "index.html";
        }
        else if ("Validation".equals(todo))
        {
            vue = "index.html";
        }
        return vue;
    }

}
