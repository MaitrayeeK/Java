/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Maitrayee
 */
@Entity
@Table(name = "projecttb")
@NamedQueries({
    @NamedQuery(name = "Projecttb.findAll", query = "SELECT p FROM Projecttb p"),
    @NamedQuery(name = "Projecttb.findByProjectId", query = "SELECT p FROM Projecttb p WHERE p.projectId = :projectId"),
    @NamedQuery(name = "Projecttb.findByTitle", query = "SELECT p FROM Projecttb p WHERE p.title = :title"),
    @NamedQuery(name = "Projecttb.findByDatetime", query = "SELECT p FROM Projecttb p WHERE p.datetime = :datetime"),
    @NamedQuery(name = "Projecttb.findByDuration", query = "SELECT p FROM Projecttb p WHERE p.duration = :duration")})
public class Projecttb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "projectId")
    private Integer projectId;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Column(name = "datetime")
    @Temporal(TemporalType.DATE)
    private Date datetime;
    @Column(name = "duration")
    private Integer duration;
    @ManyToMany(mappedBy = "projecttbCollection")
    private Collection<Employeetb> employeetbCollection;

    public Projecttb() {
    }

    public Projecttb(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projecttb)) {
            return false;
        }
        Projecttb other = (Projecttb) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Projecttb[ projectId=" + projectId + " ]";
    }

}
