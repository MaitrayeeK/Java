package entity;

import entity.Address;
import entity.Subscription;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-30T15:12:56")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile CollectionAttribute<Customer, Subscription> subscriptionCollection;
    public static volatile CollectionAttribute<Customer, Address> addressCollection;
    public static volatile SingularAttribute<Customer, Integer> customerID;

}