/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.PublishingBeanLocal;
import entities.Address;
import entities.Customer;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author maitr
 */
@Path("rest")
@RequestScoped
public class PublishingRest {

    @Context
    private UriInfo context;
    
    @EJB PublishingBeanLocal ejb; 
    /**
     * Creates a new instance of PublishingRest
     */
    public PublishingRest() {
    }

    /**
     * Retrieves representation of an instance of rest.PublishingRest
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getallcustomer")
    @Produces("application/json")
    public List<Customer> getCustomers() {
       return ejb.getAllCustomers();
    }

    /**
     * PUT method for updating or creating an instance of PublishingRest
     * @param content representation for the resource
     */
    @POST
    @Path("addcustomer/{fname}/{lname}")
    @Consumes("application/json")
    public void addcust(@PathParam("fname") String fname, @PathParam("lname") String lname) {
        ejb.addCustomer(fname, lname);
    }
    
    @PUT
    @Path("updatecustomer/{id}/{fname}/{lname}")
    @Consumes("application/json")
    public void updateCustomer(@PathParam("id") Integer id,@PathParam("fname") String fname, @PathParam("lname") String lname) {
        ejb.editCustomer(id, fname, lname);
    }
    
    @DELETE
    @Path("deletecustomer/{id}")
    public void updateCustomer(@PathParam("id") Integer id) {
        ejb.deleteCustomer(id);
    }
    
    @GET
    @Path("getalladdressbycustomer/{custId}")
    @Produces("application/json")
    public Collection<Address> getJson(@PathParam("custId") Integer id) {
       return ejb.getAddressByCustomer(id);
    }
    
    @POST
    @Path("addaddress/{street}/{city}/{state}/{zip}/{custId}")
    @Consumes("application/json")
    public void putJson(@PathParam("street") String street, @PathParam("city") String city, @PathParam("state") String state, @PathParam("zip") String zip, @PathParam("custId") Integer customerId) {
        ejb.addAddress(street, city, state, zip, customerId);
    }
    
    @PUT
    @Path("updateaddress/{id}/{street}/{city}/{state}/{zip}/{custId}")
    @Consumes("application/json")
    public void UpdateAddress(@PathParam("id") Integer id, @PathParam("street") String street, @PathParam("city") String city, @PathParam("state") String state, @PathParam("zip") String zip, @PathParam("custId") Integer customerId) {
        ejb.editAddress(id, street, city, state, zip, customerId);
    }
    
    @DELETE
    @Path("deleteaddress/{id}/{custId}")
    public void deleteAddress(@PathParam("id") Integer id, @PathParam("custId") Integer custId) {
        ejb.deleteAddress(id, custId);
    }
}
