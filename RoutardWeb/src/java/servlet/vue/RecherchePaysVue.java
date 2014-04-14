/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.vue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.modele.Pays;
import metier.modele.Voyage;

/**
 *
 * @author Slifer
 */
public class RecherchePaysVue extends HttpServlet {

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
            Pays p = (Pays)request.getAttribute("Pays");
            List<Voyage> list = (List<Voyage>)request.getAttribute("List");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>recherche/pays/"+p.getNom()+"</title>\n" +
         
            "  </head>\n" +
            "  <body>\n" +
            "  <input type =\"submit\" name=\"retour\" value=\"Retour\">\n" +
            "  <h1> Voyages en "+p.getNom()+" \n" +
            "  <h2>\n" +
            " <table>\n" +
            " \n" +
            " <tr>\n" +
            " <td>\n" +
            " <img src=\"http://www.lyonmag.com/medias/images/lyon_saint-ex_aeroport.jpg\" alt=\"frame\" />\n" +
            "  </td>\n" +
            "  <td>\n" +
            " <table>\n" +
            "	 <tr>\n" +
            "		<td>Capitale</td>\n" +
            "		<td>"+p.getCapitale()+"</td>\n" +
            "	  </tr>\n" +
            "	  <tr>\n" +
            "		<td>Population</td>\n" +
            "		<td>"+p.getPopulation()+" habitants </td>\n" +
            "	  </tr>\n" +
            "	  <tr>\n" +
            "		<td>Superficie</td>\n" +
            "		<td>"+p.getSuperficie()+" km² </td>\n" +
            "	  </tr>\n" +
            "	  <tr>\n" +
            "		<td>Langue officielle</td>\n" +
            "		<td>"+p.getLangue()+"</td>\n" +
            "	  </tr>\n" +
            "	</table>\n" +
            "	\n" +
            "	</td>\n" +
            "	</table>\n" +
            "	</h2>\n" +
            "	\n" +
            "	<p>\n" +
            "	Liste de voyages\n" +
            "	</p>\n" +
            "\n" +
            "\n" +
            "<p>\n");
            for (Voyage v : list){
                out.println("<table border =1> "
                        + " <tr> <td>" +v.getTitre() +"<br>" +v.getClass()+"<br>" +v.getNbJours()+" jours"+"<br>" 
                        +v.getDescription()+"</td></tr>"
                        +"</table>"
                        + "<input type =\"submit\" name=\"retour\" value=\"En savoir plus\">\n");
            }
            out.println("</p>\n");
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
