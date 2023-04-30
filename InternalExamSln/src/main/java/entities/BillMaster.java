/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Maitrayee
 */
@Entity
@Table(name = "bill_master")
@NamedQueries({
    @NamedQuery(name = "BillMaster.findAll", query = "SELECT b FROM BillMaster b"),
    @NamedQuery(name = "BillMaster.findById", query = "SELECT b FROM BillMaster b WHERE b.id = :id"),
    @NamedQuery(name = "BillMaster.findByGrosstotal", query = "SELECT b FROM BillMaster b WHERE b.grosstotal = :grosstotal")})
public class BillMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "grosstotal")
    private Integer grosstotal;
    @OneToMany(mappedBy = "bill")
    private Collection<BillDetail> billDetailCollection;
    @JoinColumn(name = "customer", referencedColumnName = "id")
    @ManyToOne
    private Customer customer;

    public BillMaster() {
    }

    public BillMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrosstotal() {
        return grosstotal;
    }

    public void setGrosstotal(Integer grosstotal) {
        this.grosstotal = grosstotal;
    }

    public Collection<BillDetail> getBillDetailCollection() {
        return billDetailCollection;
    }

    public void setBillDetailCollection(Collection<BillDetail> billDetailCollection) {
        this.billDetailCollection = billDetailCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillMaster)) {
            return false;
        }
        BillMaster other = (BillMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BillMaster[ id=" + id + " ]";
    }

}
