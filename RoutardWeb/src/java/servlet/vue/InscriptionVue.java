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
            out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>INSCRIPTION</title>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <!-- Bootstrap -->\n" +
                "    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n" +
                "	<link href=\"sticky-footer-navbar.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\n" +
                "    <!--[if lt IE 9]>\n" +
                "      <script src=\"http://getbootstrap.com/docs-assets/js/html5shiv.js\"></script>\n" +
                "      <script src=\"http://getbootstrap.com/docs-assets/js/respond.min.js\"></script>\n" +
                "    <![endif]-->\n" +
                "  </head>\n" +
                "  <body background=\"im.jpg\">\n" +
                "  \n" +
                "		<!-- Fixed navbar -->\n" +
                "		<div class=\"navbar navbar-inverse\" role=\"navigation\">\n" +
                "		  <div class=\"container\">\n" +
                "			<div class=\"navbar-header\">\n" +
                "			  <p class=\"navbar-brand\">IF'ROUTARD</p>\n" +
                "			</div>\n" +
                "		  </div>\n" +
                "		</div>\n" +
                "\n" +
                "		<!-- Begin page content -->\n" +
                "		\n" +
                "		\n" +
                "		<div class=\"container\">\n" +
                "		<h3><span class=\"label label-success\">Inscription</span></h3>\n" +
                "		\n" +
                "		  <p class=\"lead\">\n" +
                "		  <form action =\"http://localhost:8080/RoutardWeb/ActionServlet\" method =\"POST\">\n" +
                "			\n" +
                "			\n" +
                "			<table class =\"table\">\n" +
                "			<tr> <td>Civilite :</td> <td> <select name=\"civilite\" size=><option value=M>MR</option><option value=MME>MME</option></select> </td> </tr>\n" +
                "			<tr> <td>Nom :</td> <td><input required type =\"text\" name=\"nom\" size = \"20\" maxlength = \"20\" /> </td> </tr>\n" +
                "			<tr> <td>Prenom :</td> <td><input required type =\"text\" name=\"prenom\" size = \"20\"/> </td> </tr>\n" +
                "			<tr> <td>Adresse :</td> <td><input required type =\"text\" name=\"adresse\" size = \"40\"/> </td> </tr>\n" +
                "			<tr> <td>Mail :</td> <td><input required type =\"text\" name=\"mail\" size = \"20\" maxlength = \"200\" /> </td> </tr>\n" +
                "			<tr> <td>Tel :</td> <td><input required type =\"text\" name=\"tel\" size = \"20\"/>  </td> </tr>\n" +
                "			<tr> <td>Date de Naissance (JJ/MM/AAAA) :</td> <td><input required type =\"text\" name=\"jour\" size = \"2\" maxlength = \"2\" />\n" +
                "							<input required type =\"text\" name=\"mois\" size = \"2\" maxlength = \"2\" />\n" +
                "							<input required type =\"text\" name=\"annee\" size = \"4\" maxlength = \"4\" /> </td> </tr>\n" +
                "			<tr> <td>Mot de Passe :</td> <td><input required type =\"password\" name=\"mdp\" size = \"20\" maxlength = \"20\" /> </td> </tr>\n" +
                "			<tr> <td>Confirmer Mot de Passe :</td> <td><input required type =\"password\" name=\"conf_mdp\" size = \"20\" maxlength = \"20\" /> </td> </tr>\n" +
                "			</table>\n" +
                "			<button type=\"submit\" class=\"btn btn-default\" name=\"todo\" value=\"Validation\">Valider</button>\n" +
                "			<button type=\"submit\" class=\"btn btn-default\" name=\"todo\" value=\"Retour\">Retour</button>\n" +
                "		  </form>\n" +
                "		  </p>\n" +
                "		</div>\n" +
                "		\n" +
                "\n" +
                "    <div id=\"footer\">\n" +
                "      <div class=\"container\">\n" +
                "        <p class=\"text-muted\">Developpe par Moreno Yassine</p>\n" +
                "      </div>\n" +
                "    </div\n" +
                "\n" +
                "    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
                "    <script src=\"//code.jquery.com/jquery.js\"></script>\n" +
                "    <!-- Include all compiled plugins (below), or include individual files as needed -->\n" +
                "    <script src=\"js/bootstrap.min.js\"></script>\n" +
                "  </body>\n" +
                "</html>");
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
