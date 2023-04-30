/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package benas;

import entity.Employees;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author jenis
 */
@Local
public interface emp_beansLocal {

    Collection<Employees> getEmp();
    Employees getEmpById(Integer empId);
    
}
