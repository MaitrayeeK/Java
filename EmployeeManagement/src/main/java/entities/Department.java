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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Maitrayee
 */
@Entity
@Table(name = "department")
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDeptID", query = "SELECT d FROM Department d WHERE d.deptID = :deptID"),
    @NamedQuery(name = "Department.findByDeptName", query = "SELECT d FROM Department d WHERE d.deptName = :deptName")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deptID")
    private Integer deptID;
    @Size(max = 100)
    @Column(name = "deptName")
    private String deptName;
    @OneToMany(mappedBy = "deptId")
    private Collection<Employeetb> employeetbCollection;

    public Department() {
    }

    public Department(Integer deptID) {
        this.deptID = deptID;
    }

    public Integer getDeptID() {
        return deptID;
    }

    public void setDeptID(Integer deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Collection<Employeetb> getEmployeetbCollection() {
        return employeetbCollection;
    }

    public void setEmployeetbCollection(Collection<Employeetb> employeetbCollection) {
        this.employeetbCollection = employeetbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptID != null ? deptID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.deptID == null && other.deptID != null) || (this.deptID != null && !this.deptID.equals(other.deptID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Department[ deptID=" + deptID + " ]";
    }

}
