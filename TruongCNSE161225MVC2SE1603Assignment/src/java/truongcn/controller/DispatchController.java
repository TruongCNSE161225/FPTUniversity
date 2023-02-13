/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package truongcn.controller;
//
//import java.io.IOException;
//import java.util.Properties;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import truongcn.utils.MyApplicationConstants;
//
///**
// *
// * @author Chau Nhat Truong
// */
//@WebServlet(name = "DispatchController", urlPatterns = {"/DispatchController"})
//public class DispatchController extends HttpServlet {
//    
//////    private final String LOGIN_PAGE = "login.html";
////    private final String LOGIN_PAGE = "";
////    private final String LOGIN_CONTROLLER = "LoginServlet";
////    private final String LOGOUT_CONTROLLER = "LogoutServlet";
////    private final String SEARCH_LASTNAME_CONTROLLER = "SearchLastnameServlet";
////    private final String DELETE_ACCOUNT_CONTROLLER = "DeleteAccountServlet";
////    private final String UPDATE_ACCOUNT_CONTROLLER = "UpdateAccountServlet";
////    private final String FIRST_TIME_REQUEST = "FisrtTimeRequestServlet";
////    private final String ADD_ITEMS_TO_CART_CONTROLLER = "AddItemsToCartServlet";
////    private final String REMOVE_ITEMS_FROM_CART_CONTROLLER = "RemoveItemFromCartServlet";
////    private final String SHOW_ITEMS_CONTROLLER = "ShowItemsServlet";
////    private final String VIEW_CART_PAGE = "viewCart.jsp";
////    private final String CHECKOUT_CONTROLLER = "CheckOutServlet";
////    private final String CREATE_ACCOUNT_CONTROLLER = "CreateAccountServlet";
//    
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
////        String url = LOGIN_PAGE;
//
//        //which button did user click?
//        String button = request.getParameter("btAction");
//
//        ServletContext context = this.getServletContext();
//        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
////        String url = siteMaps.getProperty("SITE_MAP");
//        String url = siteMaps.getProperty(
//                MyApplicationConstants.DispatchController.LOGIN_PAGE);
//
//        try {
////            if (button == null) {
//////                url = FIRST_TIME_REQUEST;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.FIRST_TIME_REQUEST);
////            } else if (button.equals("Login")) {
////                //forward to functional Servlet
//////                url = LOGIN_CONTROLLER;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.LOGIN_CONTROLLER);
////            } else if (button.equals("Logout")) {
//////                url = LOGOUT_CONTROLLER;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.LOGOUT_CONTROLLER);
////            } else if (button.equals("Search")) {
//////                url = SEARCH_LASTNAME_CONTROLLER;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.SEARCH_LASTNAME_CONTROLLER);
////            } else if (button.equals("delete")) {
//////                url = DELETE_ACCOUNT_CONTROLLER;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.DELETE_ACCOUNT_CONTROLLER);
////            } else if (button.equals("Update")) {
//////                url = UPDATE_ACCOUNT_CONTROLLER;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.UPDATE_ACCOUNT_CONTROLLER);
////            } else if (button.equals("Add To Cart")) {
//////                url = ADD_ITEMS_TO_CART_CONTROLLER;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.ADD_ITEMS_TO_CART_CONTROLLER);
////            } else if (button.equals("View Your Cart")) {
//////                url = VIEW_CART_PAGE;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.VIEW_CART_PAGE);
////            } else if (button.equals("Remove Selected Items")) {
//////                url = REMOVE_ITEMS_FROM_CART_CONTROLLER;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.REMOVE_ITEMS_FROM_CART_CONTROLLER);
////            } else if (button.equals("Check out")) {
//////                url = CHECKOUT_CONTROLLER;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.CHECKOUT_CONTROLLER);
////            } else if (button.equals("Click here to buy book")) {
//////                url = SHOW_ITEMS_CONTROLLER;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.SHOW_ITEMS_CONTROLLER);
////            } else if (button.equals("Add More Items to Cart")) {
//////                url = SHOW_ITEMS_CONTROLLER;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.SHOW_ITEMS_CONTROLLER);
////            } else if (button.equals("Create New Account")) {
//////                url = CREATE_ACCOUNT_CONTROLLER;
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchController.CREATE_ACCOUNT_CONTROLLER);
//            }
//        } finally {
//            RequestDispatcher rd = request.getRequestDispatcher(url);
//            rd.forward(request, response);
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
