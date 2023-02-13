<%-- 
    Document   : viewCart
    Created on : Oct 13, 2022, 8:26:56 AM
    Author     : Chau Nhat Truong
--%>
<%--<%@page import="java.util.Map"%>--%>
<%--<%@page import="truongcn.cart.CartObject"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Mart</title>
    </head>
    <body>
        <h1>Web Mart</h1>
        <h2>Your cart includes</h2>

        <%--<%
            //1. Cust goes to his/her cart place
            if (session != null) {
                //2. Cust takes his/her cart
                CartObject cart = (CartObject) session.getAttribute("CART");
                if (cart != null) {
                    //3. Cust takes items
                    Map<String, Integer> items = cart.getItems();
                    if (items != null) {
                        //4. Cust traverse each item
        %>--%>

        <c:set var="cart" value="${sessionScope.CART.items}"/>
        <c:if test="${not empty cart}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Sku</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>

                    <%--<%
                        int count = 0;
                        for (String key : items.keySet()) {
                            int value = items.get(key);
                    %>--%>

                    <c:forEach var="item" items="${cart}" varStatus="counter">
                    <form action="removeItemsFromCartController" method="POST">
                        <tr>
                            <td>
                                ${counter.count}
                                .</td>
                            <td>
                                ${item.key}
                            </td>
                            <td>
                                ${item.value}
                            </td>
                            <td>
                                <input type="checkbox" name="chkItem" 
                                       value="${item.key}" />
                            </td>
                        </tr>

                        <%--<%
                            }//end travese map
                        %>--%>

                    </c:forEach>
                    <tr>
                        <td colspan="3">
                            <%--<a href="shopping.html">Add More Items to Cart</a>--%>
                            <a href="showItemsController">Add More Items to Cart</a>
                        </td>
                        <td>
                            <input type="submit" value="Remove Selected Items" name="btAction" />
                        </td>
                    </tr>
                </form>
            </tbody>
        </table>
                            
        <form action="checkoutController">
            <input type="submit" value="Check out" name="btAction" />
        </form>

        <%--<%
                return;
            }//end items has been existed
        }//end cart has been existed
        }//end session has been existed
        %>--%>

    </c:if>
    <c:if test="${empty cart}">
        <h2>
            No Cart is not found!!!!
        </h2>
        <a href="showItemsController">Click here to buy</a>
    </c:if>
</body>
</html>
