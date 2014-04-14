/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.vue;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Slifer
 */
public class ConnexionVue extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Validation = (String) request.getAttribute("Validation");
            if ("false".equals(Validation)){ // en cas d'erreur
                 out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Erreur de Connexion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Connexion Impossible</h1>");
            out.println("<p>Identifiant et/ou Mot de passe erronnés </p>");
            out.println("<form action =\"http://localhost:8080/RoutardWeb\" method =\"POST\">\n" +
"<input type =\"submit\" name=\"todo\" value=\"Retour\"/>");
            out.println("</body>");
            out.println("</html>");
            }
            // Si la connexion s'est bien passée
            else{
            out.println("<!DOCTYPE html>"); 
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consultation</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<form action =\"./ActionServlet\" method =\"POST\">\n" +
"		\n" +
"		<table>\n" +
"		<tr> <td><h1>IF ROUTARD</h1></td> <td><h2>"+request.getParameter("Identifiant")+"</h2></td> <td><h2> <A HREF=\"http://localhost:8080/RoutardWeb\">Deconnexion</A></h2> </td>  </tr>\n" +
"		<tr> Recherche </tr>\n" +
"		<tr> <td> Rechercher Pays </td> <td> Rechercher Type de circuit </td> </tr>\n" +
"		<tr> <td> <input type =\"text\" name=\"RecherchePays\" value=\"Pays\"/> </td> <td> Liste: <select name=\"Type de voyage\"> <option value=\\\"circuit\\\"> Circuit accompagné</option><option value=\\\"Séjour\\\"> Séjour</option></select> </td> </tr>\n" +
"		<tr> <td> <input type=\"submit\" value=\"RecherchePays\" name=\"todo\"> </td> <td> <input type=\"submit\" value=\"RechercheVoyage\" name=\"todo\"> </td> <tr> \n" +
"		</table>\n" +
"		</form>");
            
            out.println("</body>");
            out.println("</html>");
            }
        }
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

}
