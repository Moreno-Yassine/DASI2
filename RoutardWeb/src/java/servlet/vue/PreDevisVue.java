package servlet.vue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.modele.Depart;
import metier.modele.Voyage;
import metier.service.ServiceVoyage;
import static servlet.vue.RecherchePaysVue.identifier;

/**
 *
 * @author Slifer
 */
public class PreDevisVue extends HttpServlet {

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
            Voyage v = (Voyage)request.getAttribute("voyageDevis");
            List<Depart> list = ServiceVoyage.obtenirDeparts(v);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head>\n" +
            "    <title>DEVIS</title>\n" +
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
            "  </head>");
            out.println("<body background=\"im.jpg\">");
            out.println("<!-- Fixed navbar -->\n" +
        "		<div class=\"navbar navbar-inverse\" role=\"navigation\">\n" +
        "		  <div class=\"container\">\n" +
        "			<div class=\"navbar-header\">\n" +
        "			<p class=\"navbar-brand\">IF'ROUTARD</p>\n" +
        "			<ul class=\"nav navbar-nav\">\n" +
        "			 <li><a href=\"javascript:history.go(-1)\">Precedent</a></li>\n" +
        "			</ul>\n" +
        "			</div>\n" +
        "		  </div>\n" +
        "		</div>");
            out.println("<div class=\"container\">\n" +
"		<h3><span class=\"label label-success\">Devis</span></h3>\n" +
"		\n" +
"		  <p class=\"lead\">");
            out.println("<table class=\"table\" border =1>" 
                        + " <tr> <td>" +v.getTitre() +"<br>" +identifier(v)+"<br>" +v.getNbJours()+" jours"+"<br>" 
                        +v.getDescription()+"</td></tr>"
                        +"</table>");
            out.println("<form action =\"./ActionServlet\" method =\"POST\">");
            out.println("<table class=\"table\"> ");
             for (Depart d : list){
                out.println("<tr><div class=\"radio\">\n" +
                "  <label>\n" +
                "    <input type=\"radio\" name=\"Depart\" value=\""+d.getId()+"\">\n" +
                d.getDateDeDepart()+"Compagnie: "+d.getDescription()+" Ville: "+d.getVille()+ "  Prix: " +d.getPrix()+"€" +
                "  </label>\n" +
                "</div></tr>");
            }
            
            out.println("</table>");
            out.println("<br>");
            out.println("<input required type =\"text\" name=\"Personnes\" size = \"2\" maxlength =\"2\">Personne(s) </input>");
            
            out.println("<button class=\"btn btn-default\" type =\"submit\" name=\"todo\" value=\"Valider\"/> Demander Devis </button>");
            out.println("</p>");
            out.println("</div>");
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
