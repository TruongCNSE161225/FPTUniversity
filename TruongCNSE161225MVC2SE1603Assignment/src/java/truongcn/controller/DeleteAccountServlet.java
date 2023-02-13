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
import truongcn.registration.RegistrationDAO;
import truongcn.registration.RegistrationDTO;
import truongcn.registration.RegistrationDeleteError;
import truongcn.utils.MyApplicationConstants;

/**
 *
 * @author Chau Nhat Truong
 */
@WebServlet(name = "DeleteAccountServlet", urlPatterns = {"/DeleteAccountServlet"})
public class DeleteAccountServlet extends HttpServlet {

//    private final String ERROR_PAGE = "errors.html";
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
                MyApplicationConstants.DeleteAccountServlet.ERROR_PAGE);
        String username = request.getParameter("pk");
        String searchValue = request.getParameter("lastSearchValue");
        HttpSession session = request.getSession(false);
//        String url = ERROR_PAGE;
        boolean result = false;
        boolean errorFound = false;
        RegistrationDeleteError error = new RegistrationDeleteError();
        try {
            //1. Check validation
            if (session != null) {
                RegistrationDTO dto = (RegistrationDTO) session.getAttribute("USER");
                if (username.equals(dto.getUsername())) {
                    errorFound = true;
                    error.setDeleteCurrentAccount("Cannot delete current account");
                }//end if delete current account
                if (errorFound) {
                    request.setAttribute("DELETE_ERROR", error);
                    url = "SearchLastnameServlet"
                            + "?txtSearchValue=" + searchValue;
                } else {
                    //2. Call DAO
                    RegistrationDAO dao = new RegistrationDAO();
                    result = dao.deleteAccount(username);
//                    result = true;
                }//end of check validation
                //3. refresh data grid --> call search
                if (result) {
                    url = "SearchLastnameServlet"
                            + "?txtSearchValue=" + searchValue; //apply url rewriting of session tracking
                }//end delete is successful
            }//end if session existed
        } catch (SQLException ex) {
//            ex.printStackTrace();
            log("DeleteAccountServlet _ SQL _ " + ex.getMessage());
        } catch (NamingException ex) {
//            ex.printStackTrace();
            log("DeleteAccountServlet _ Naming _ " + ex.getMessage());
        } finally {
//            response.sendRedirect(url);//Dùng forward thì lỗi 408
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
