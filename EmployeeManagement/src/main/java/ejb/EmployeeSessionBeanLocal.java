/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */

package ejb;

import entities.Employeetb;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Maitrayee
 */
@Local
public interface EmployeeSessionBeanLocal {
    void addEmployee(Employeetb emp);
    Collection<Employeetb> getAllEmployee();
}
