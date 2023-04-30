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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Maitrayee
 */
@Entity
@Table(name = "employeetb")
@NamedQueries({
    @NamedQuery(name = "Employeetb.findAll", query = "SELECT e FROM Employeetb e"),
    @NamedQuery(name = "Employeetb.findByEmpId", query = "SELECT e FROM Employeetb e WHERE e.empId = :empId"),
    @NamedQuery(name = "Employeetb.findByName", query = "SELECT e FROM Employeetb e WHERE e.name = :name"),
    @NamedQuery(name = "Employeetb.findByEmail", query = "SELECT e FROM Employeetb e WHERE e.email = :email"),
    @NamedQuery(name = "Employeetb.findByPassword", query = "SELECT e FROM Employeetb e WHERE e.password = :password")})
public class Employeetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empId")
    private Integer empId;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 70)
    @Column(name = "email")
    private String email;
    @Size(max = 256)
    @Column(name = "password")
    private String password;
    @JoinTable(name = "project_employee", joinColumns = {
        @JoinColumn(name = "empId", referencedColumnName = "empId")}, inverseJoinColumns = {
        @JoinColumn(name = "projectId", referencedColumnName = "projectId")})
    @ManyToMany
    private Collection<Projecttb> projecttbCollection;
    @JoinColumn(name = "deptId", referencedColumnName = "deptID")
    @ManyToOne
    private Department deptId;

    public Employeetb() {
    }

    public Employeetb(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Projecttb> getProjecttbCollection() {
        return projecttbCollection;
    }

    public void setProjecttbCollection(Collection<Projecttb> projecttbCollection) {
        this.projecttbCollection = projecttbCollection;
    }

    public Department getDeptId() {
        return deptId;
    }

    public void setDeptId(Department deptId) {
        this.deptId = deptId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeetb)) {
            return false;
        }
        Employeetb other = (Employeetb) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Employeetb[ empId=" + empId + " ]";
    }

}
