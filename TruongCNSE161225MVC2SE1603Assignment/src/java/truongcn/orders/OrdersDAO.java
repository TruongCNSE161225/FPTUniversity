/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongcn.orders;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import truongcn.utils.DBHelper;

/**
 *
 * @author Chau Nhat Truong
 */
public class OrdersDAO implements Serializable {

    public int addToOrders(String username, String total)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        long milis = System.currentTimeMillis();
        Date date = new Date(milis);
        float totalBill = Float.parseFloat(total);
        int key = 0;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Insert Into Orders("
                        + " dateBuy, username, total"
                        + ") "
                        + "Values("
                        + " ?, ?, ?"
                        + ")";
                //3. Create statement
                stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stm.setDate(1, date);
                stm.setString(2, username);
                stm.setFloat(3, totalBill);
                //4. ExecuteQuery
                int effectedRows = stm.executeUpdate();
                rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    key = rs.getInt(1);
                }
                //5. Process result
                while (effectedRows > 0) {
                    return key;
                }//end of order is inserted
            }//end con is available
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return key;
    }
}
