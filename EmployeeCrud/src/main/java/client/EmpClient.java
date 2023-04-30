/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:EmpResource [emp]<br>
 * USAGE:
 * <pre>
 *        EmpClient client = new EmpClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maitr
 */
public class EmpClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/EmployeeCrud/resources";

    public EmpClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("emp");
    }

    public <T> T getAllDepts(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getalldepts");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void editEmp(String id, String name, String salary, String dept) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("editemp/{0}/{1}/{2}/{3}", new Object[]{id, name, salary, dept})).request().post(null);
    }

    public void removeEmp(String id, String dept) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeemp/{0}/{1}", new Object[]{id, dept})).request().delete();
    }

    public <T> T getAllEmps(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallemp");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addEmployee(String name, String salary, String dept) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addemp/{0}/{1}/{2}", new Object[]{name, salary, dept})).request().post(null);
    }

    public <T> T getEmpbyId(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getempbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
