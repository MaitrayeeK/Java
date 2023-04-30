/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import entity.Customer;
import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "subscription")
@NamedQueries({
    @NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s"),
    @NamedQuery(name = "Subscription.findBySubscriptionID", query = "SELECT s FROM Subscription s WHERE s.subscriptionID = :subscriptionID"),
    @NamedQuery(name = "Subscription.findByTitle", query = "SELECT s FROM Subscription s WHERE s.title = :title"),
    @NamedQuery(name = "Subscription.findByType", query = "SELECT s FROM Subscription s WHERE s.type = :type")})
public class Subscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SubscriptionID")
    private Integer subscriptionID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Type")
    private String type;
    @ManyToMany(mappedBy = "subscriptionCollection")
    private Collection<Customer> customerCollection;

    public Subscription() {
    }

    public Subscription(Integer subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public Subscription(Integer subscriptionID, String title, String type) {
        this.subscriptionID = subscriptionID;
        this.title = title;
        this.type = type;
    }

    public Integer getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(Integer subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonbTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subscriptionID != null ? subscriptionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) object;
        if ((this.subscriptionID == null && other.subscriptionID != null) || (this.subscriptionID != null && !this.subscriptionID.equals(other.subscriptionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.publishingapp.Subscription[ subscriptionID=" + subscriptionID + " ]";
    }
    
}
