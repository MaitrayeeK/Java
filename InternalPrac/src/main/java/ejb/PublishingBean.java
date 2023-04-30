/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */

package ejb;

import entities.Address;
import entities.Customer;
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
public class PublishingBean implements PublishingBeanLocal {
    
    @PersistenceContext(unitName = "PUBLISHINGPU")
    EntityManager em;
    
    @Override
    public void addCustomer(String fname, String lname) {
        Customer customer = new Customer();
        customer.setFirstName(fname);
        customer.setLastName(lname);
        em.persist(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    @Override
    public void editCustomer(Integer id, String fname, String lname) {
        Customer customer = em.find(Customer.class, id);
        customer.setFirstName(fname);
        customer.setLastName(lname);
        em.merge(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        Customer customer = em.find(Customer.class, id);
        em.remove(customer);
    }

    @Override
    public void addAddress(String street, String city, String state, String zip, Integer customerId) {
        Customer c = em.find(Customer.class, customerId);
        Collection<Address> addresses = c.getAddressCollection();
        
        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setState(state);
        address.setZip(zip);
        address.setCustomerId(c);
        
        addresses.add(address);
        
        em.persist(address);
        em.merge(c);
    }

    @Override
    public Collection<Address> getAddressByCustomer(Integer custId) {
        Customer c = em.find(Customer.class, custId);
        return c.getAddressCollection();
    }

    @Override
    public void editAddress(Integer id, String street, String city, String state, String zip, Integer customerId) {
        Customer c = em.find(Customer.class, customerId);
        Collection<Address> addresses = c.getAddressCollection();
        
        Address address = em.find(Address.class, id);
        address.setCity(city);
        address.setStreet(street);
        address.setState(state);
        address.setZip(zip);
        address.setCustomerId(c);
        
        
        em.merge(address);
    }

    @Override
    public void deleteAddress(Integer id, Integer customerId) {
        Customer c = em.find(Customer.class, customerId);
        Collection<Address> addresses = c.getAddressCollection();
        
        Address a = em.find(Address.class, id);
        
        addresses.remove(a);
        
        em.remove(a);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
