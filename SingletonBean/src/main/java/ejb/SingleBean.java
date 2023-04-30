/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package ejb;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author maitr
 */

// 8 Feb
// Project for Singleton bean
// SingleServlet, SingletonBean, SecondBean, FirstBean 


// Only for singleton bean
// use to instantiated while deploy

@TransactionManagement(TransactionManagementType.BEAN)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@AccessTimeout(value = 30, unit = TimeUnit.SECONDS) // If methods are locked then how much time another thread or client will be wait.
@Startup 
@Singleton
@DependsOn({"FirstBean", "SecondBean"}) // This bean instantiated and also instantiated these two beans also
public class SingleBean {
    
    @Resource UserTransaction ut;

    String fname, lname;
    public SingleBean() {
    }
    
    @Lock(LockType.READ)
    public String getFname() {
        return fname;
    }
    
    @Lock(LockType.WRITE)
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    @Lock(LockType.READ)
    public String getLname() {
        return lname;
    }
    
    @Lock(LockType.WRITE)
    public void setLname(String lname) {    
        this.lname = lname;
    }

    @PostConstruct
    public void initialize() {
        fname = "";
        lname = "";
        
        System.out.println("Single bean instantiated");
    }
    
    public String getFullName(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        String fullname="";
        
        try {
            ut.begin();
            fullname = this.fname + " " + this.lname;
            ut.commit();
        } catch(Exception e) {
            try {
                ut.setRollbackOnly();
                
                e.printStackTrace();
            } catch (IllegalStateException ex) {
                Logger.getLogger(SingleBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(SingleBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fullname;
    }
}
