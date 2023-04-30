/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:PublishingRest [rest]<br>
 * USAGE:
 * <pre>
 *        RestClient client = new RestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maitr
 */
public class RestClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/InternalPrac/resources";

    public RestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("rest");
    }

    public void putJson(Object requestEntity, String street, String city, String state, String zip, String custId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addaddress/{0}/{1}/{2}/{3}/{4}", new Object[]{street, city, state, zip, custId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getCustomers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallcustomer");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addcust(Object requestEntity, String fname, String lname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addcustomer/{0}/{1}", new Object[]{fname, lname})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void UpdateAddress(Object requestEntity, String id, String street, String city, String state, String zip, String custId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateaddress/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{id, street, city, state, zip, custId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateCustomer(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletecustomer/{0}", new Object[]{id})).request().delete();
    }

    public void deleteAddress(String id, String custId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteaddress/{0}/{1}", new Object[]{id, custId})).request().delete();
    }

    public <T> T getJson(Class<T> responseType, String custId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getalladdressbycustomer/{0}", new Object[]{custId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
