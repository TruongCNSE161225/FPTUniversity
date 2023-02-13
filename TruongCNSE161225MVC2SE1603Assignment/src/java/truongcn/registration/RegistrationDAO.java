/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongcn.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import truongcn.utils.DBHelper;

/**
 *
 * @author Chau Nhat Truong
 */
public class RegistrationDAO implements Serializable {
    
    //public boolean checkLogin(String username, String password)
    public RegistrationDTO checkLogin(String username, String password)
            throws SQLException, /*ClassNotFoundException*/ NamingException {;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
//        boolean result = false;
        RegistrationDTO result = null;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select username, lastname "
                        + "From Registration "
                        + "Where username = ? And password = ?";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4. ExecuteQuery
                rs = stm.executeQuery();
                //5. Process result
                if (rs.next()) {
//                    result = true;
                    String fullname = rs.getString("lastname");
                    result = new RegistrationDTO(username, password, fullname, false);
                }
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
        return result;
    }

    private List<RegistrationDTO> accountList;

    public List<RegistrationDTO> getAccountList() {
        return accountList;
    }

    public void searchLastName(String searchValue)
            throws SQLException, /*ClassNotFoundException*/ NamingException {;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
//        boolean result = false;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select username, password, lastname, isAdmin "
                        + "From Registration "
                        + "Where lastname Like ?";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4. ExecuteQuery
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    //create DTO instance
                    RegistrationDTO dto = new RegistrationDTO(username,
                            password, lastname, role);
                    //add to account list
                    if (this.accountList == null) {
                        this.accountList = new ArrayList<>();
                    }//end account list is not existed
                    this.accountList.add(dto);
                }//end account list is traversed
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

    public boolean deleteAccount(String username)
            throws SQLException, /*ClassNotFoundException*/ NamingException {;
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Delete From Registration "
                        + "Where username = ?";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4. ExecuteQuery
                int effectedRows = stm.executeUpdate();
                //5. Process result
                if (effectedRows > 0) {
                    result = true;
                }
            }//end con is available
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean updateAccount(String username, String password, boolean role)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            //2. Create SQL String
            String sql = "Update Registration "
                    + "Set password = ?, isAdmin = ? "
                    + "Where username = ?";
            //3. Create statement
            stm = con.prepareStatement(sql);
            stm.setString(1, password);
            stm.setBoolean(2, role);
            stm.setString(3, username);
            //4. Execute query
            int effectedRows = stm.executeUpdate();
            //5. Process result
            if (effectedRows > 0) {
                result = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
    public boolean createAccount(RegistrationDTO dto)
            throws SQLException, /*ClassNotFoundException*/ NamingException {;
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Insert Into Registration("
                        + "username, password, lastname, isAdmin"
                        + ") "
                        + "Values(?, ?, ?, ?"
                        + ")";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getFullname());
                stm.setBoolean(4, dto.isRole());
                //4. ExecuteQuery
                int effectedRows = stm.executeUpdate();
                //5. Process result
                if (effectedRows > 0) {
                    result = true;
                }
            }//end con is available
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
