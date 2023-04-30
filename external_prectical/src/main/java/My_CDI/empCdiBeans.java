/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package My_CDI;

import benas.emp_beansLocal;
import entity.Employees;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import java.util.Properties;
import javax.jms.Queue;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Query;

/**
 *
 * @author jenis
 */
@Named(value = "empCdiBeans")
@RequestScoped
public class empCdiBeans implements Serializable {

    /**
     * Creates a new instance of empCdiBeans
     */
    @EJB
    emp_beansLocal ejb;
    Collection<Employees> employeeList;
    Integer empid;
    String empname;
    String email;
    String phoneno;
    String designation;
    String address;
    Employees employee;
    
    

    public emp_beansLocal getEjb() {
        return ejb;
    }

    public void setEjb(emp_beansLocal ejb) {
        this.ejb = ejb;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empnam) {
        this.empname = empnam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public Collection<Employees> getEmployeeList() {
        return ejb.getEmp();
    }

    public void setEmployeeList(Collection<Employees> employeeList) {
        this.employeeList = employeeList;
    }

    public empCdiBeans() {
        employee = new Employees();
    }

    public String onsubmit() {
        try {
            Properties p = new Properties();
            p.setProperty(Context.PROVIDER_URL, "mq://localhost:7676");

            InitialContext ic = new InitialContext();
            ConnectionFactory cf = (ConnectionFactory) ic.lookup("myfq");
            Queue queue = (Queue) ic.lookup("jmsd");

            Connection con = cf.createConnection();
            Session session = con.createSession();

            MessageProducer mp = session.createProducer(queue);
            String message;
            System.out.println(employee);
            if(employee.getEmpid() == 0) {
                 message = "insert;Employee;empname:" + employee.getEmpname() + ";email:" + employee.getEmail()
                    + ";phoneno:" + employee.getPhoneno()+ ";designation:" + employee.getDesignation()
                    + ";address:" + employee.getAddress();
            } else {
                  message = "update;Employee;empid:" + employee.getEmpid() + ";empname:" + employee.getEmpname() + ";email:" + employee.getEmail()
                    + ";phoneno:" + employee.getPhoneno()+ ";designation:" + employee.getDesignation()
                    + ";address:" + employee.getAddress();
            }
            TextMessage msg = session.createTextMessage(message);
            mp.send(msg);

        } catch (Exception e) {
                    e.printStackTrace();
        }
        return "empJSF?faces-redirect=true";
    }
    
    public String addpage(){
        return "empForm.jsf";
    }
    public String onEdit(Employees emp){
       employee = emp;
       return "empForm.jsf";
    }
}
