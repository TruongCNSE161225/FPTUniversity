/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongcn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import truongcn.cart.CartObject;
import truongcn.orders.OrdersCreateError;
import truongcn.orders.OrdersDAO;
import truongcn.ordersdetail.OrdersDetailDAO;
import truongcn.utils.MyApplicationConstants;

/**
 *
 * @author Chau Nhat Truong
 */
@WebServlet(name = "PayingServlet", urlPatterns = {"/PayingServlet"})
public class PayingServlet extends HttpServlet {

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

        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(
                MyApplicationConstants.PayingServlet.VIEW_CHECKOUT_PAGE);
        String username = request.getParameter("txtUsername");
        String total = request.getParameter("txtTotal");
        int key;
        HttpSession session = request.getSession();
        CartObject cart = (CartObject) session.getAttribute("CART");
        OrdersCreateError error = new OrdersCreateError();
        boolean errorFound = false;
        try {
            //1. Check name validation
            if (username.trim().length() == 0) {
                errorFound = true;
                error.setUsernameError("Invalid input!");
                if (errorFound) {
                    request.setAttribute("ERROR", error);
                }//end if found error
            } else {
                //2. Insert to DB
                OrdersDAO dao1 = new OrdersDAO();
                key = dao1.addToOrders(username, total);
                if (key != 0) {
                    OrdersDetailDAO dao2 = new OrdersDetailDAO();
                    dao2.addToOrdersDetail(cart, key);
                }//end if key existed
                session.setAttribute("USERNAME", username);
                //3. System remove cart
                session.removeAttribute("CART");
                session.removeAttribute("CHECKOUT_RESULT");
            }//end of insert to DB successfully
        } catch (SQLException ex) {
            log("PayingServlet _ SQL _ " + ex.getMessage());
        } catch (NamingException ex) {
            log("PayingServlet _ Naming _ " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
