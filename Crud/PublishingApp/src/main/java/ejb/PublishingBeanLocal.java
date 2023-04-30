/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface PublishingBeanLocal {
    
    //Customer Method
    
//    void addCustomer(String fname, String lname);
    void addCustomer(String fname, String lname);
    void updateCustomer(Integer cid, String fname, String lname);
    void removeCustomer(Integer customerid);
    
    Collection<Customer> getAllCustomer();
    Customer getCustomerById(Integer cid);
    Collection<Customer> getCustomerByFirstName(String fname);
    Collection<Customer> getCustomerByLastName(String lname);
    
    //Address Method
    
    void addAddressToCustomer(Address address, Integer customerId);
    void updateAddressToCustomer(Address address, Integer customerId);
    void removeAddressOfCustomer(Integer aid, Integer cid);
    
    Collection<Address> getAddressesOfCustomer(Integer cid);
    Collection<Address> getAddressesByState(String state);
    Collection<Address> getAddressesByCity(String city);
    Collection<Address> getAddress(String state, String city);
    
    //Subscription Mehtod
    
    void addSubscription(String title, String type);
    void updateSubscription(Integer sid, String title, String type);
    void removeSubscription(Integer sid);
    
    void addSubscriptionsToCustomer(Integer cid, Collection<Integer> sids);
    void removeSubscriptionsFromCustomer(Integer cid, Collection<Integer> sids);
    
    Collection<Subscription> getSubscriptionsOfCustomer(Integer cid);
    Collection<Subscription> getAllSubscriptions();
    Collection<Subscription> getAllSubscriptionsByType(String type);
    Subscription getSubscriptionByTitle(String title);
}
