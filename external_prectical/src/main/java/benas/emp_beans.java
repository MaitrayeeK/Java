/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package benas;

import entity.Employees;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jenis
 */
@Stateless
public class emp_beans implements emp_beansLocal {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;
   
   

   

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

   

    @Override
    public Collection<Employees> getEmp() {
        return em.createNamedQuery("Employees.findAll").getResultList(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Employees getEmpById(Integer empId) {
        return em.find(Employees.class, empId); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
