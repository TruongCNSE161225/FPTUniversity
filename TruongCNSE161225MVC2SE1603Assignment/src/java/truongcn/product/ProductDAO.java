/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongcn.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import truongcn.registration.RegistrationDTO;
import truongcn.utils.DBHelper;

/**
 *
 * @author Chau Nhat Truong
 */
public class ProductDAO {

    private List<ProductDTO> itemsList;

    public List<ProductDTO> getItemsList() {
        return itemsList;
    }

    public void showProduct()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string
                String sql = "Select sku, name, description, quantity, price, status "
                        + "From Product "
                        + "Where status = 1";
                //3. Create statement
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String sku = rs.getString("sku");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getInt("price");
                    boolean status = rs.getBoolean("status");
                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(sku, name, description,
                            quantity, price, status);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void getProductForCheckOut(String id)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string
                String sql = "Select sku, name, description, quantity, price, status "
                        + "From Product "
                        + "Where sku = ?";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    String sku = rs.getString("sku");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getInt("price");
                    boolean status = rs.getBoolean("status");
                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(sku, name, description,
                            quantity, price, status);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
