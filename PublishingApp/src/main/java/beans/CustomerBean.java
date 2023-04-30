/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.PublishingClient;
import entity.Customer;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dell
 */
@Named(value = "customer")
@RequestScoped
public class CustomerBean {
    
    PublishingClient pclient;
    Response res;
    
    String customerId;
    String firstName;
    String lastName;
    
    Collection<Customer> customers;
    GenericType<Collection<Customer>> gcustomers;
    
    Customer customer = new Customer();
    GenericType<Customer> gcustomer = new GenericType<Customer>(){};
    
    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
        pclient = new PublishingClient();
        customers = new ArrayList<Customer>();
        gcustomers = new GenericType<Collection<Customer>>(){};
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Customer> getCustomers() {
        res = pclient.getAllCustomer(Response.class);
        customers = res.readEntity(gcustomers);
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }
    
    public String toCustomerForm(String cid){
        System.out.println("CustID: " + cid);
        if(!cid.isEmpty()){
            System.out.println("Customer Id is not empty!!!");
            
            res = pclient.getCustomerById(Response.class, cid);
            customer = res.readEntity(gcustomer);
            
            customerId = customer.getCustomerID().toString();
            firstName = customer.getFirstName();
            lastName = customer.getLastName();
            
            System.out.println("CustID: " + customerId + " FirstName: " + firstName + " LastName: " + lastName);
        }
        return "CustomerForm.jsf";
    }
    
    public String addCustomer(){
        if(customerId.isEmpty()) {
            pclient.addCustomer(firstName, lastName);
        }
        else{
            pclient.updateCustomer(customerId, firstName, lastName);
        }
        
        return "DisplayCustomer.jsf";
    }
    
    public void deleteCustomer(String cid){
        pclient.removeCustomer(cid);
    }
}
