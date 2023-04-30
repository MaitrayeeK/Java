/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maitrayee
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
   
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
        try ( PrintWriter out = response.getWriter()) {
        //RequestDispatcher rd = request.getRequestDispatcher("index.html");
        //rd.include(request, response);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title><link rel='stylesheet' href='webjars/bootstrap/5.2.3/css/bootstrap.min.css'>\n"
                    + "        <script src='webjars/jquery/3.6.2/dist/jquery.min.js'></script>\n"
                    + "        <script src='webjars/bootstrap/5.2.3/js/bootstrap.min.js'></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"card text-center w-50\">\n"
                    + "  <div class=\"card-header\">\n"
                    + "    Login\n"
                    + "  </div>\n"
                    + "  <div class=\"card-body\">\n"
                    + "    <div class=\"mb-3 row\">\n"
                    + "    <label for=\"staticEmail\" class=\"col-sm-2 col-form-label\">Email</label>\n"
                    + "    <div class=\"col-sm-10\">\n"
                    + "      <input type=\"text\" class=\"form-control\" id=\"inputEmail\">\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "  <div class=\"mb-3 row\">\n"
                    + "    <label for=\"inputPassword\" class=\"col-sm-2 col-form-label\">Password</label>\n"
                    + "    <div class=\"col-sm-10\">\n"
                    + "      <input type=\"password\" class=\"form-control\" id=\"inputPassword\">\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "    <a href=\"#\" class=\"btn btn-primary\">Login</a>\n"
                    + "  </div>\n"
                    + "</div>");
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
