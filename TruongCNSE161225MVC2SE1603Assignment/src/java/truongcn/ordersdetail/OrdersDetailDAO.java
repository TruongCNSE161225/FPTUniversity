/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongcn.ordersdetail;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.naming.NamingException;
import truongcn.cart.CartObject;
import truongcn.utils.DBHelper;

/**
 *
 * @author Chau Nhat Truong
 */
public class OrdersDetailDAO implements Serializable {

    public boolean addToOrdersDetail(CartObject cart, int key)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm1 = null;
        PreparedStatement stm2 = null;
        ResultSet rs = null;
        int effectedRows = 0;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String (For selected price)
                String sql1 = "Select sku, price "
                        + "From Product "
                        + "Where sku = ?";
                stm1 = con.prepareStatement(sql1);
                Map<String, Integer> items = cart.getItems();
                for (String sku : items.keySet()) {
                    stm1.setString(1, sku);
                    rs = stm1.executeQuery();
                    if (rs.next()) {
                        float price = rs.getFloat("price");
                        float total = price * items.get(sku);
                        String sql2 = "Insert into OrdersDetail("
                                + " orderID, sku, quantity, price, total"
                                + ") "
                                + "Values("
                                + " ?, ?, ?, ?, ?"
                                + ")";
                        stm2 = con.prepareStatement(sql2);
                        stm2.setInt(1, key);
                        stm2.setString(2, sku);
                        stm2.setInt(3, items.get(sku));
                        stm2.setFloat(4, price);
                        stm2.setFloat(5, total);
                        effectedRows = stm2.executeUpdate();
                    }//end of insert cart on DB
                }//end of traverse cart
                if (effectedRows > 0) {
                    return true;
                }//end of return result
            }//end of order is inserted
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm1 != null) {
                stm1.close();
            }
            if (stm2 != null) {
                stm2.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
