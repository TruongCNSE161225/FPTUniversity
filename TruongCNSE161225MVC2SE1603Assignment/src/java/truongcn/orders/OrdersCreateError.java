/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongcn.orders;

import java.io.Serializable;

/**
 *
 * @author Chau Nhat Truong
 */
public class OrdersCreateError implements Serializable {

    private String quantityError;
    private String usernameError;

    /**
     * @return the quantityError
     */
    public String getQuantityError() {
        return quantityError;
    }

    /**
     * @param quantityError the quantityError to set
     */
    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    /**
     * @return the usernameError
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * @param usernameError the usernameError to set
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }
    
    
}
