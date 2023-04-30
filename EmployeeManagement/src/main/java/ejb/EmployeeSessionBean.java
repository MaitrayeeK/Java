/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */

package ejb;

import entities.Employeetb;
import java.util.Collection;
import javax.ejb.Stateless;

/**
 *
 * @author Maitrayee
 */
@Stateless
public class EmployeeSessionBean implements EmployeeSessionBeanLocal {

    @Override
    public void addEmployee(Employeetb emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Employeetb> getAllEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
