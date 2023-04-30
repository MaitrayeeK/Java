/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

//import client.PublishingClient;
import ejb.PublishingBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dell
 */
@WebServlet(name = "Publishing", urlPatterns = {"/Publishing"})
public class Publishing extends HttpServlet {

    @EJB
    PublishingBeanLocal pbl;

//    PublishingClient pl;
//    Response res;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Publishing</title>");
            out.println("</head>");
            out.println("<body>");

//            Address a1 = new Address("abc", "def", "pqr", "395002");
//            pbl.addAddressToCustomer(a1, 5);

            Address a1 = new Address(5,"mno", "xyz", "pqr", "395007");
            pbl.updateAddressToCustomer(a1, 5);

//            pbl.addCustomer(new Customer("Krish", "Parekh"));
//            pbl.addCustomer("Riya", "Parekh");
//            pbl.addCustomer("Kush", "Parekh");
//            pbl.addAddressToCustomer("Sagrampura", "Gujarat", "Surat", "395002", 1);
//            pbl.addAddressToCustomer("Salabatpura", "Gujarat", "Surat", "395003", 1);
//            pbl.addAddressToCustomer("vesu", "Gujarat", "Surat", "395007", 3);
//            pbl.updateAddressToCustomer(3, "abcd", "Gujarat", "Surat", "395000", 3);
//            pbl.removeAddressOfCustomer(2, 1);
//            pbl.addSubscription("Times of India", "Magazine");
//            pbl.addSubscription("India Today", "Magazine");
//            pbl.addSubscription("Vogue", "Magazine");
            Collection<Integer> sids = new ArrayList<>();
            sids.add(1);

//            pbl.addSubscriptionsToCustomer(1, sids);
//            pbl.addSubscriptionsToCustomer(3, sids);
//            pbl.removeSubscriptionsFromCustomer(3, sids);
//            Customer c = pbl.getCustomerById(1);
//            out.println("<br/> ID: " + c.getCustomerID() + " Name: " + c.getFirstName() + " " + c.getLastName());
            Collection<Customer> customers = pbl.getAllCustomer();
            for (Customer c : customers) {
                out.println("<br/> ID: " + c.getCustomerID() + " Name: " + c.getFirstName() + " " + c.getLastName());

                Collection<Address> addresses = pbl.getAddressesOfCustomer(c.getCustomerID());
                for (Address a : addresses) {
                    out.println("<br/> AddressID: " + a.getAddressID() + ", Street: " + a.getStreet() + ", State: " + a.getState() + ", City: " + a.getCity() + ", Zip: " + a.getZip());
                }

                Collection<Subscription> subscriptions = pbl.getSubscriptionsOfCustomer(c.getCustomerID());
                for (Subscription s : subscriptions) {
                    out.println("<br/> SubscriptionID: " + s.getSubscriptionID() + ", Title: " + s.getTitle() + ", Type: " + s.getType());
                }

                out.println("<br/>-------------------------------------------------------------------------------------------------------------<br/>");
            }

//            Collection<Address> addresses = pbl.getAddress("Gujarat", "Surat");
//            for (Address a : addresses) {
//                out.println("<br/> AddressID: " + a.getAddressID() + ", Street: " + a.getStreet() + ", State: " + a.getState() + ", City: " + a.getCity() + ", Zip: " + a.getZip());
//            }
//
//            Collection<Subscription> subscriptions = pbl.getAllSubscriptionsByType("Magazine");
//            for (Subscription s : subscriptions) {
//                out.println("<br/> SubscriptionID: " + s.getSubscriptionID() + ", Title: " + s.getTitle() + ", Type: " + s.getType());
//            }
//
//            Subscription s = pbl.getSubscriptionByTitle("Vogue");
//            out.println("<br/> SubscriptionID: " + s.getSubscriptionID() + ", Title: " + s.getTitle() + ", Type: " + s.getType());
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
