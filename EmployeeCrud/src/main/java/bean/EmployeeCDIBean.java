/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.EmpClient;
import entities.Department;
import entities.Employee;
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
@Named(value = "employeeCDIBean")
@RequestScoped
public class EmployeeCDIBean {

    String empId, deptId;
    String name, salary;
    
    Employee emp = new Employee();
    GenericType<Employee> gemp = new GenericType<Employee>(){};
    
    Collection<Employee> emps;
    GenericType<Collection<Employee>> gemps;
    
    Collection<Department> depts;
    GenericType<Collection<Department>> gdepts;
    
    EmpClient client;
    
    Response res;
    
    public EmployeeCDIBean() {
        client = new EmpClient();
        emps = new ArrayList<Employee>();
        gemps = new GenericType<Collection<Employee>>(){};
        
        depts = new ArrayList<Department>();
        gdepts = new GenericType<Collection<Department>>(){};
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmp(String empid) {
        System.out.println(empid);
        res = client.getEmpbyId(Response.class, empid);
        emp = res.readEntity(gemp);
        
        empId = emp.getId().toString();
        name = emp.getName();
        salary = emp.getSalary();
        System.out.print(empId);
        return "addempjsf.jsf";
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
    
    public Collection<Employee> getEmps() {
        res = client.getAllEmps(Response.class);
        emps = res.readEntity(gemps);
        return emps;
    }

    public void setEmps(Collection<Employee> emps) {
        this.emps = emps;
    }

    public Collection<Department> getDepts() {
        res = client.getAllDepts(Response.class);
        depts = res.readEntity(gdepts);
        return depts;
    }

    public void setDepts(Collection<Department> depts) {
        this.depts = depts;
    }
    
    public void addEmp() {
        client.addEmployee(name, salary, deptId);
    }
    
    public String removeEmp(String id, String deptid) {
        client.removeEmp(id, deptid);
        return "empsjsf.jsf";
    }
}
