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
                 out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>ERREUR</title>\n" +
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
                "		<h3><span class=\"label label-warning\">Erreur</span></h3>\n" +
                "		\n" +
                "		  <p class=\"lead\">\n" +
                "		  <form action =\"http://localhost:8080/RoutardWeb/ActionServlet\" method =\"POST\">\n" +
                "			<p>Identifiant et/ou Mot de passe erronnes </p>\n" +
                "\n" +
                "			<button type=\"submit\" class=\"btn btn-default\" name=\"todo\" value=\"Retour\">Retour</button>\n" +
                "		  </form>\n" +
                "		  </p>\n" +
                "		</div>\n" +
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
            // Si la connexion s'est bien passée
            else{
            
            out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>BIENVENUE</title>\n" +
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
                "			<p class=\"navbar-brand\">IF'ROUTARD</p>\n" +
                "			<ul class=\"nav navbar-nav\">\n" +
                "			 <li><a href=\"#\">"+request.getParameter("Identifiant")+"</a></li>\n" +
                "			 <li><a href=\"http://localhost:8080/RoutardWeb\">Deconnexion</a></li>\n" +
                "			</ul>\n" +
                "			</div>\n" +
                "		  </div>\n" +
                "		</div>\n" +
                "\n" +
"		<!-- Begin page content -->\n" +
"		\n" +
"		\n" +
"		<div class=\"container\">\n" +
"		<h3><span class=\"label label-success\">Bienvenue</span></h3>\n" +
"		\n" +
"		  <p class=\"lead\">\n" +
"		  <form action =\"http://localhost:8080/RoutardWeb/ActionServlet\" method =\"POST\">\n" +
"			\n" +
"			<table class=\"table\">\n" +
"			\n" +
"			<tr> <td> Rechercher Pays </td> <td> Rechercher Type de circuit </td> </tr>\n" +
"			<tr> <td> <select name=\"RecherchePays\">");
            
                List<Pays> aff =  (List<Pays>)request.getAttribute("AffichagePays");
                for (Pays p : aff)
                {
                    out.println("<option value = "+ p.getNom()+">"+p.getNom()+"</option>");
                }
                out.println("</select></td>\n" +
"				<td><select name=\"RechercheVoyage\"> <option value=\"circuit\"> Circuit accompagné</option><option value=\"sejour\"> Séjour</option></select> </td> </tr>\n" +
"			<tr> <td> <button class=\"btn btn-default\"  type=\"submit\" value=\"RecherchePays\" name=\"todo\">Recherche</button> </td> <td> <button class=\"btn btn-default\" type=\"submit\" value=\"RechercheVoyage\" name=\"todo\">Recherche</button> </td> <tr>\n" +
            "		</table>\n" +
            "		</form>\n" +
            "		  </p>\n" +
            "		</div>\n" +
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
