/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */

package ejb;

import entities.Department;
import entities.Employee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maitrayee
 */
@Local
public interface EmployeeBeanLocal {
    void addEmployee(String name, String salary, Integer department);
    void editEmployee(Integer id, String name, String salary, Integer department);
    void removeEmployee(Integer id, Integer deptId);
    Employee getEmployeeByid(Integer id);
    List<Employee> getAllEmps();
    
    List<Department> getAllDept();
}
