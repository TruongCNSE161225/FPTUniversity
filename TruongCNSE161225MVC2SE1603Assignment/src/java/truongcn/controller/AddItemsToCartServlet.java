/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongcn.controller;

import java.io.IOException;
import java.util.Properties;
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
import truongcn.utils.MyApplicationConstants;

/**
 *
 * @author Chau Nhat Truong
 */
@WebServlet(name = "AddItemsToCartServlet", urlPatterns = {"/AddItemsToCartServlet"})
public class AddItemsToCartServlet extends HttpServlet {
//    private final String SHOPPING_PAGE = "shopping.html";

//    private final String SHOPPING_CONTROLLER = "ShowItemsServlet";
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
//        String url = SHOPPING_CONTROLLER;
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(
                MyApplicationConstants.AddItemsToCartServlet.SHOPPING_CONTROLLER);
        OrdersCreateError error = new OrdersCreateError();
        boolean quantityError = false;
        try {
            //1. Cust goes to cart place
            HttpSession session = request.getSession(); //phải chọn true vì chưa có cũng phải tạo cho có
            //2. Cust take a cart
            CartObject cart = (CartObject) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartObject();
            }
            //3. Cust drop item to cart
//            String sku = request.getParameter("cboBook");
            String sku = request.getParameter("txtSku");
            String quantity = request.getParameter("txtQuantity");
            if (Integer.parseInt(quantity) < 1) {
                quantityError = true;
                String msg = "The quantity cannot less than 1";
                request.setAttribute("QUANTITY_ERROR", msg);
            } else if (sku != null && quantityError == false) {
                //4. Cust continutely goes to shopping
                cart.addItemsToCart(sku, Integer.parseInt(quantity));
                session.setAttribute("CART", cart);
            }//end if drop item to cart successfully
        } catch (NumberFormatException ex) {
            log("AddItemsToCartServlet _ Number _ " + ex.getMessage());
        } finally {
//            response.sendRedirect(url); //Không sài vì có requestScope đẩy lỗi ra view
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
