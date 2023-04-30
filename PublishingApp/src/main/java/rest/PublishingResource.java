/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.PublishingBeanLocal;
import entity.Address;
import entity.Customer;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("publishing")
@RequestScoped
public class PublishingResource {
    
    @EJB
    PublishingBeanLocal pbl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PublishingResource
     */
    public PublishingResource() {
    }
    
    @POST
    @Path("addCustomer/{fname}/{lname}")
    public void addCustomer(@PathParam("fname") String fname, @PathParam("lname") String lname){
        pbl.addCustomer(fname, lname);
    }
    
    @POST
    @Path("updateCustomer/{cid}/{fname}/{lname}")
    public void updateCustomer(@PathParam("cid") Integer cid, @PathParam("fname") String fname, @PathParam("lname") String lname) {
        pbl.updateCustomer(cid, fname, lname);
    }
    
    @DELETE
    @Path("removeCustomer/{cid}")
    public void removeCustomer(@PathParam("cid") Integer cid){
        pbl.removeCustomer(cid);
    }
    
    @GET
    @Produces("application/json")
    @Path("getCustomers")
    public Collection<Customer> getAllCustomer() {
        Collection<Customer> customers = pbl.getAllCustomer();
        return customers;
    }
    
    @GET
    @Produces("application/json")
    @Path("getCustomerById/{cid}")
    public Customer getCustomerById(@PathParam("cid") Integer cid){
        return pbl.getCustomerById(cid);
    }
    
    @POST
    @Path("addAddress/{cid}")
    public void addAddress(Address address, @PathParam("cid") Integer cid) {
        pbl.addAddressToCustomer(address, cid);
    }
    
}
