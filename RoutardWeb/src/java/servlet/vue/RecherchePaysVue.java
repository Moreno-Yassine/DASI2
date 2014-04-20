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
import metier.modele.Circuit;
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
                    "  </head>\n"+
                    
                    
            "  <body background=\"im.jpg\">\n"+
                    "<div class=\"navbar navbar-inverse\" role=\"navigation\">\n" +
"		  <div class=\"container\">\n" +
"			<div class=\"navbar-header\">\n" +
"			<p class=\"navbar-brand\">IF'ROUTARD</p>\n" +
"			<ul class=\"nav navbar-nav\">\n" +
"			 <li><a href=\"javascript:history.go(-1)\">Precedent</a></li>\n" +
"			</ul>\n" +
"			</div>\n" +
"		  </div>\n" +
"		</div>\n"
                    
                +"<div class=\"container\">\n" +
"		<h3><span class=\"label label-Success\">Recherche</span></h3>\n"    
                    + "<form action =\"./ActionServlet\" method =\"POST\">\n" +"<p class=\"lead\">"+

                "  <h3> Voyages en "+p.getNom()+"</h3> \n" +
                " <table class=\"table\">\n" +
                " \n" +
                " <tr>\n" +
                "  <td>\n" +
                " <table class=\"table table-striped\">\n" +
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
                "	\n" +
                "\n" +
                "\n" +
                "<div class=\"well\">\n");
            for (Voyage v : list){
                out.println("<table class=\"table\" border =1> "
                        + " <tr> <td>" +v.getTitre() +"<br>" +identifier(v)+"<br>" +v.getNbJours()+" jours"+"<br>" 
                        +v.getDescription()+"</td></tr>"
                        +"</table>"
                        + "<button class=\"btn btn-default\" type =\"submit\" name=\"todo\" value="+v.getCode()+">En Savoir Plus</button>\n");
            }
            out.println("</div>\n");
            out.println("</p>");
            out.println("</div>");
            out.println(" <div id=\"footer\">\n" +
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
    protected static String identifier (Voyage v)
    {
       if(v instanceof Circuit)
       {
           return "Circuit";
       }
       else
       {
           return "Séjour";
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
