package entity;

import entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-30T15:12:56")
@StaticMetamodel(Subscription.class)
public class Subscription_ { 

    public static volatile CollectionAttribute<Subscription, Customer> customerCollection;
    public static volatile SingularAttribute<Subscription, Integer> subscriptionID;
    public static volatile SingularAttribute<Subscription, String> title;
    public static volatile SingularAttribute<Subscription, String> type;

}