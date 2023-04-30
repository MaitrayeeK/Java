/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.EmployeeBeanLocal;
import entities.Department;
import entities.Employee;
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
@Path("emp")
@RequestScoped
public class EmpResource {

    @Context
    private UriInfo context;
    @EJB EmployeeBeanLocal empbean;
    
    public EmpResource() {
    }
    
    @POST
    @Path("addemp/{name}/{salary}/{dept}")
    public void addEmployee(@PathParam("name") String name, @PathParam("salary") String salary, @PathParam("dept") Integer dept) {
       empbean.addEmployee(name, salary, dept);
    }
   
    @GET
    @Path("getallemp")
    @Produces("application/json")
    public List<Employee> getAllEmps() {
        return empbean.getAllEmps();
    }
    
    @GET
    @Path("getempbyid/{id}")
    @Produces("application/json")
    public Employee getEmpbyId(@PathParam("id") Integer id) {
        return empbean.getEmployeeByid(id);
    }
    
    @PUT
    @Path("editemp/{id}/{name}/{salary}/{dept}")
    public void editEmp(@PathParam("id") Integer id, @PathParam("name") String name, @PathParam("salary") String salary, @PathParam("dept") Integer dept) {
       empbean.editEmployee(id, name, salary, dept);
    }
    
    @DELETE
    @Path("removeemp/{id}/{dept}")
    public void removeEmp(@PathParam("id") Integer id, @PathParam("dept") Integer dept) {
       empbean.removeEmployee(id, dept);
    }
    
    @GET
    @Path("getalldepts")
    @Produces("application/json")
    public List<Department> getAllDepts() {
        return empbean.getAllDept();
    }
    
    
}
