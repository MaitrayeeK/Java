/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Department;
import entities.Employee;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maitrayee
 */
@Stateless
public class EmployeeBean implements EmployeeBeanLocal {

    @PersistenceContext(unitName = "EmployeePU")
    EntityManager em;

    @Override
    public void addEmployee(String name, String salary, Integer department) {
        Department dept = em.find(Department.class, department);
        Collection<Employee> emps = dept.getEmployeeCollection();

        Employee emp = new Employee();
        emp.setName(name);
        emp.setSalary(salary);
        emp.setDepartment(dept);

        emps.add(emp);
        em.persist(emp);
        em.merge(dept);
    }

    @Override
    public void editEmployee(Integer id, String name, String salary, Integer department) {
        Department dept = em.find(Department.class, department);
        Collection<Employee> emps = dept.getEmployeeCollection();

        Employee emp = em.find(Employee.class, id);
        emp.setName(name);
        emp.setSalary(salary);
        emp.setDepartment(dept);

        em.merge(dept);
    }

    @Override
    public void removeEmployee(Integer id, Integer deptId) {
        Department dept = em.find(Department.class, deptId);
        Collection<Employee> emps = dept.getEmployeeCollection();

        Employee emp = em.find(Employee.class, id);
        emps.remove(emp);
        em.remove(emp);

    }

    @Override
    public Employee getEmployeeByid(Integer id) {
        return em.createNamedQuery("Employee.findById", Employee.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Department> getAllDept() {
        return em.createNamedQuery("Department.findAll", Department.class).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Employee> getAllEmps() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }
}
