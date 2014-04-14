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
public class InscriptionVue extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ROUTARD'IF : VOTRE VOYAGE, SIMPLEMENT ... [Inscription]</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2> Inscription </h2>");
            out.println("<br>");
            out.println("<form action =\"./ActionServlet\" method =\"POST\">");
            out.println("<table>\n" +
"		<tr> <td>Civilité :</td> <td> <select name=\"civilite\" size=><option value=M>MR</option><option value=MME>MME</option></select> </td> </tr>\n" +
"		<tr> <td>Nom :</td> <td><input type =\"text\" name=\"nom\" size = \"20\" maxlength = \"20\" /> </td> </tr>\n" +
"		<tr> <td>Prenom :</td> <td><input type =\"text\" name=\"prenom\" size = \"20\"/> </td> </tr>\n" +
"		<tr> <td>Adresse :</td> <td><input type =\"text\" name=\"adresse\" size = \"40\"/> </td> </tr>\n" +
"		<tr> <td>Mail :</td> <td><input type =\"text\" name=\"mail\" size = \"20\" maxlength = \"20\" /> </td> </tr>\n" +
"		<tr> <td>Tel :</td> <td><input type =\"text\" name=\"tel\" size = \"20\"/>  </td> </tr>\n" +
"		<tr> <td>Date de Naissance (JJ/MM/AAAA) :</td> <td><input type =\"text\" name=\"jour\" size = \"2\" maxlength = \"2\" />\n" +
"							<input type =\"text\" name=\"mois\" size = \"2\" maxlength = \"2\" />\n" +
"							<input type =\"text\" name=\"annee\" size = \"4\" maxlength = \"4\" /> </td> </tr>\n" +
"		<tr> <td>Mot de Passe :</td> <td><input type =\"password\" name=\"mdp\" size = \"20\" maxlength = \"20\" /> </td> </tr>\n" +
"		<tr> <td>Confirmer Mot de Passe :</td> <td><input type =\"password\" name=\"conf_mdp\" size = \"20\" maxlength = \"20\" /> </td> </tr>\n" +
"		</table>\n" +
"		\n" +
"		 <input type =\"submit\" name=\"todo\" value=\"Validation\"/>\n" +
"		 <input type =\"submit\" name=\"todo\" value=\"Retour\"/>\n" +
"		\n" +
"		</form>");
            out.println("</body>");
            out.println("</html>");
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
