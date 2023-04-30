/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Subscription;
import entity.Customer;
import entity.Address;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Maitrayee
 */
@Local
public interface PublishingBeanLocal {

    void createCustomer(String fname, String lname);

    void updateCustomer(Integer id, String fname, String lname);

    void removeCustomer(Integer id);

    Collection<Customer> getAllCustomer();

    Customer getCustomerById(Integer id);

    Collection<Customer> getCustomerByfname(String fname);

    Collection<Customer> getCustomerBylname(String lname);

    void addAddresstoCustomer(String street, String city, String state, String zip, Integer cid);

    void removeAddressofCustomer(Integer addressid, Integer customerid);

    void updateAddresstoCustomer(String street, String city, String state, String zip, Integer cid);

    Collection<Address> getAddressofCustomer(Integer id);

    Collection<Address> getAdressesbycity(String city);

    Collection<Address> getAdressesbystate(String state);

    Collection<Address> getAdressesbyzip(String zip);

    Collection<Address> getAdresses(String city, String state);

    void addSubscription(String title, String type);

    void updateSubscription(String title, String type);

    void removeSubscription(Integer id);

    void addSubscriptiontoCustomer(Integer cid, Collection<Integer> sid);

    void removeSubscriptionFromCustomer(Integer cid, Integer sid);

    Collection<Subscription> getSubscriptionOfCustomer (Integer cid);

    Collection<Subscription> getAllSubscriptionByType (String type);

    Collection<Subscription> getAllSubscriptionByTitle (String title);

}
