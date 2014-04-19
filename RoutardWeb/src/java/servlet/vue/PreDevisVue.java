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
            out.println("<head>");
            out.println("<title>Devis</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"javascript:history.go(-1)\">Page précedente</a>" );
            out.println("<table border =1>" 
                        + " <tr> <td>" +v.getTitre() +"<br>" +identifier(v)+"<br>" +v.getNbJours()+" jours"+"<br>" 
                        +v.getDescription()+"</td></tr>"
                        +"</table>");
            out.println("<h1> DEVIS </h1>");
            out.println("<select name = Depart> ");
             for (Depart d : list){
                out.println("<option value =" +d.getId()+">"+ d.getDateDeDepart()+" Compagnie : "+d.getDescription()+" Ville : "+d.getVille()+ "  Prix : " +d.getPrix()+"€ </option>");
            }
            out.println("<input type =\"text\" name=\"Nb de Personnes\" size = \"2\" maxlength =\"2\" />");
            out.println("</select>");
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
