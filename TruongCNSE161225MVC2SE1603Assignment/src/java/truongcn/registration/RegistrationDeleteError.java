/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongcn.registration;

import java.io.Serializable;

/**
 *
 * @author Chau Nhat Truong
 */
public class RegistrationDeleteError implements Serializable {

    private String deleteCurrentAccount;

    /**
     * @return the deleteCurrentAccount
     */
    public String getDeleteCurrentAccount() {
        return deleteCurrentAccount;
    }

    /**
     * @param deleteCurrentAccount the deleteCurrentAccount to set
     */
    public void setDeleteCurrentAccount(String deleteCurrentAccount) {
        this.deleteCurrentAccount = deleteCurrentAccount;
    }
}
