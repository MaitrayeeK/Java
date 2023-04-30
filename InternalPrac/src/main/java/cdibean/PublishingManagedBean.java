/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdibean;

import client.RestClient;
import entities.Customer;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author maitr
 */
@Named(value = "publishingManagedBean")
@RequestScoped
public class PublishingManagedBean {
    
        
    Integer cutomerid, addressid;
    String fname, lname;
    Collection<Customer> customers;
    GenericType<Collection<Customer>> gcustomers;
    Response res;
    Customer customer;
    GenericType<Customer> gcustomer;
    String street, city, state, zip;
    
    RestClient client = new RestClient();
    
    public PublishingManagedBean() {
        customers = new ArrayList<Customer>();
        gcustomers = new GenericType<Collection<Customer>>(){};
    }
    
    public Integer getCutomerid() {
        return cutomerid;
    }

    public void setCutomerid(Integer cutomerid) {
        this.cutomerid = cutomerid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    
    public Collection<Customer> getCustomers() {
        res = client.getCustomers(Response.class);
        customers = res.readEntity(gcustomers);
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }
    
    public String add() {
        client.addcust(cutomerid, fname, lname);
        return "customersdjsf.jsf";
    }
    
    public String addAddress() {
        client.putJson(addressid, street, city, state, zip, city);
        
        for(Customer customer : customers) {
            System.out.println(customers);
        }
        return "customersdjsf.jsf";
    }
    
    
}
