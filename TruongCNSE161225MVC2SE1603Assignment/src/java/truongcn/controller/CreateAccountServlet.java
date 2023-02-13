/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongcn.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import truongcn.registration.RegistrationCreateError;
import truongcn.registration.RegistrationDAO;
import truongcn.registration.RegistrationDTO;
import truongcn.utils.MyApplicationConstants;

/**
 *
 * @author Chau Nhat Truong
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {
//    private final String ERROR_PAGE = "createNewAccount.jsp";
//    private final String LOGIN_PAGE = "login.html";

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

//        String url = ERROR_PAGE;
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(
                MyApplicationConstants.CreateAccountServlet.ERROR_PAGE);
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");
        boolean errorFound = false;
        RegistrationCreateError errors = new RegistrationCreateError();

        try {
            //1. Check all user error
            if (username.trim().length() < 6 || username.trim().length() > 20) {
                errorFound = true;
                errors.setUsernameLengthError(
                        "Username is required input from 6 to 20 characters");
            }
            if (password.trim().length() < 6 || password.trim().length() > 30) {
                errorFound = true;
                errors.setPasswordLengthError(
                        "Password is required input from 6 to 30 characters");
            } else if (!password.trim().equals(confirm.trim())) {
                errorFound = true;
                errors.setConfirmNotMatched("Confirm must be matched password");
            }
            if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                errorFound = true;
                errors.setFullnameLengthError(
                        "Full Name is required input from 2 to 50 characters");
            }
            if (errorFound) {
                //1.1 catch error
                request.setAttribute("CREATE_ERROR", errors);
                //1.2 transfer to inform users
            } else {
                //2. Call DAO to insert DB
                RegistrationDAO dao = new RegistrationDAO();
                RegistrationDTO dto
                        = new RegistrationDTO(username, password, fullname, false);
                boolean result = dao.createAccount(dto);
                if (result) {
//                    url = LOGIN_PAGE;
                    url = siteMaps.getProperty(
                            MyApplicationConstants.CreateAccountServlet.LOGIN_PAGE);
                }
                //3. Process & check system error --> transfer to login or error page
            }//end checking user errors
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("Create Account _ SQL _ " + msg);
            if (msg.contains("duplicate")) {
                errors.setUsernameIsExisted(username + " is existed!!!!");
                request.setAttribute("CREATE_ERROR", errors);
            }
        } catch (NamingException ex) {
            log("Create Account _ Naming _ " + ex.getMessage());
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
