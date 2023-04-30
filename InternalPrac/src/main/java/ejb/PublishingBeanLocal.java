/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */

package ejb;

import entities.Address;
import entities.Customer;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maitrayee
 */
@Local
public interface PublishingBeanLocal {
    void addCustomer(String fname, String lname);
    List<Customer> getAllCustomers();
    void editCustomer(Integer id, String fname, String lname);
    void deleteCustomer(Integer id);
    
    void addAddress(String street, String city, String state, String zip, Integer customerId);
    Collection<Address> getAddressByCustomer(Integer custId);
    void editAddress(Integer id, String street, String city, String state, String zip, Integer customerId);
    void deleteAddress(Integer id, Integer customerId);
    
}
