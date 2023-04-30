/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dell
 */
@Stateless
public class PublishingBean implements PublishingBeanLocal {

    @PersistenceContext(unitName = "PublishingPU")
    EntityManager em;

    @Override
    public void addCustomer(String fname, String lname) {
        Customer c = new Customer();
        c.setFirstName(fname);
        c.setLastName(lname);
        em.persist(c);

    }

    @Override
    public void updateCustomer(Integer cid, String fname, String lname) {
        Customer c = (Customer) em.find(Customer.class, cid);
        c.setFirstName(fname);
        c.setLastName(lname);
        em.merge(c);
    }

    @Override
    public void removeCustomer(Integer customerid) {
        Customer c = (Customer) em.find(Customer.class, customerid);
        em.remove(c);
    }

    @Override
    public Collection<Customer> getAllCustomer() {
        return em.createNamedQuery("Customer.findAll").getResultList();
    }

    @Override
    public Customer getCustomerById(Integer cid) {
        return (Customer) em.find(Customer.class, cid);
    }

    @Override
    public Collection<Customer> getCustomerByFirstName(String fname) {
        Collection<Customer> customers = em.createNamedQuery("Customer.findByFirstName").setParameter("firstName", fname).getResultList();
        return customers;
    }

    @Override
    public Collection<Customer> getCustomerByLastName(String lname) {
        Collection<Customer> customers = em.createNamedQuery("Customer.findByLastName").setParameter("lastName", lname).getResultList();
        return customers;
    }

    @Override
    public void addAddressToCustomer(Address address, Integer customerId) {
        Customer c = (Customer) em.find(Customer.class, customerId);
        Collection<Address> addresses = c.getAddressCollection();

        address.setCustomer(c);
        
        addresses.add(address);
        c.setAddressCollection(addresses);
        
        em.persist(address);
        em.merge(c);
    }

    @Override
    public void updateAddressToCustomer(Address address, Integer customerId) {
        
        Customer c = (Customer) em.find(Customer.class, customerId);
        Collection<Address> addresses = c.getAddressCollection();
        
//        Address a = (Address) em.find(Address.class, address.getAddressID());
        
        address.setCustomer(c);
        c.setAddressCollection(addresses);
        
        em.merge(address);
    }

    @Override
    public void removeAddressOfCustomer(Integer aid, Integer cid) {
        Customer c = (Customer) em.find(Customer.class, cid);
        Address a = (Address) em.find(Address.class, aid);
        Collection<Address> addresses = c.getAddressCollection();
        
        if(addresses.contains(a)){
            addresses.remove(a);
            c.setAddressCollection(addresses);
            em.remove(a);
        }
    }

    @Override
    public Collection<Address> getAddressesOfCustomer(Integer cid) {
        Customer c = (Customer) em.find(Customer.class, cid);
        return c.getAddressCollection();
    }

    @Override
    public Collection<Address> getAddressesByState(String state) {
        Collection<Address> addresses = em.createNamedQuery("Address.findByState").setParameter("state", state).getResultList();
        return addresses;
    }

    @Override
    public Collection<Address> getAddressesByCity(String city) {
        Collection<Address> addresses = em.createNamedQuery("Address.findByCity").setParameter("city", city).getResultList();
        return addresses;
    }

    @Override
    public Collection<Address> getAddress(String state, String city) {
        Collection<Address> addresses = em.createNamedQuery("Address.findByStateAndCity").setParameter("state", state).setParameter("city", city).getResultList();
        return addresses;
    }

    @Override
    public void addSubscription(String title, String type) {
        Subscription s = new Subscription();
        s.setTitle(title);
        s.setType(type);
        em.persist(s);
    }

    @Override
    public void updateSubscription(Integer sid, String title, String type) {
        Subscription s = (Subscription) em.find(Subscription.class, sid);
        s.setTitle(title);
        s.setType(type);
        em.merge(s);
    }

    @Override
    public void removeSubscription(Integer sid) {
        Subscription s = (Subscription) em.find(Subscription.class, sid);
        em.remove(s);
    }

    @Override
    public void addSubscriptionsToCustomer(Integer cid, Collection<Integer> sids) {
        Customer c = (Customer) em.find(Customer.class, cid);
        Collection<Subscription> subscriptions = c.getSubscriptionCollection();
        
        for(Integer sid : sids)
        {
            Subscription s = (Subscription) em.find(Subscription.class, sid);
            if(!subscriptions.contains(s))
            {
                Collection<Customer> customers = s.getCustomerCollection();
                subscriptions.add(s);
                customers.add(c);
                
                c.setSubscriptionCollection(subscriptions);
                s.setCustomerCollection(customers);
                
                em.merge(s);
            }
        }
    }

    @Override
    public void removeSubscriptionsFromCustomer(Integer cid, Collection<Integer> sids) {
        Customer c = (Customer) em.find(Customer.class, cid);
        Collection<Subscription> subscriptions = c.getSubscriptionCollection();
        
        for(Integer sid : sids)
        {
            Subscription s = (Subscription) em.find(Subscription.class, sid);
            if(subscriptions.contains(s))
            {
                Collection<Customer> customers = s.getCustomerCollection();
                subscriptions.remove(s);
                customers.remove(c);
                
                c.setSubscriptionCollection(subscriptions);
                s.setCustomerCollection(customers);
                
                em.merge(s);
            }
        }
    }

    @Override
    public Collection<Subscription> getSubscriptionsOfCustomer(Integer cid) {
        Customer c = (Customer) em.find(Customer.class, cid);
        return c.getSubscriptionCollection();
    }

    @Override
    public Collection<Subscription> getAllSubscriptions() {
        Collection<Subscription> subscriptions = em.createNamedQuery("Subscription.findAll").getResultList();
        return subscriptions;
    }

    @Override
    public Collection<Subscription> getAllSubscriptionsByType(String type) {
        Collection<Subscription> subscriptions = em.createNamedQuery("Subscription.findByType").setParameter("type", type).getResultList();
        return subscriptions;
    }

    @Override
    public Subscription getSubscriptionByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
