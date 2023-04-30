/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:PublishingResource
 * [publishing]<br>
 * USAGE:
 * <pre>
 *        PublishingClient client = new PublishingClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Dell
 */
public class PublishingClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/PublishingApp/resources";

    public PublishingClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("publishing");
    }

    public void addCustomer(String fname, String lname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCustomer/{0}/{1}", new Object[]{fname, lname})).request().post(null);
    }

    public <T> T getCustomerById(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCustomerById/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addAddress(String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAddress/{0}", new Object[]{cid})).request().post(null);
    }

    public void updateCustomer(String cid, String fname, String lname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCustomer/{0}/{1}/{2}", new Object[]{cid, fname, lname})).request().post(null);
    }

    public void removeCustomer(String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeCustomer/{0}", new Object[]{cid})).request().delete();
    }

    public <T> T getAllCustomer(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getCustomers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
