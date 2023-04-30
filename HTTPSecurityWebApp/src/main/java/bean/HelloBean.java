/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import ejb.SecureBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author maitr
 */
@Named(value = "helloBean")
@RequestScoped
public class HelloBean {
    
    SecureBean ejb;
    String securehello;
    String message;
    
    /**
     * Creates a new instance of HelloBean
     */
    public HelloBean() {
    }

    public String getSecurehello() {
        try {
            securehello = ejb.sayhello();
            return securehello;
        } catch (Exception e) {
            message = "You are forbidden";
        }
        return null;
    }

    public void setSecurehello(String securehello) {
        this.securehello = securehello;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
  
    
    
}
