package com.mycompany.hibirnate.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "realtor")
@NamedQueries({
    @NamedQuery(name = "Realtor.findAll", query = "SELECT r FROM Realtor r")})
public class Realtor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "realtor_id")
    private Integer realtorId;
    @JoinColumn(name = "email", referencedColumnName = "email")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "realtor", fetch = FetchType.LAZY)
    private List<Entry> entryList;

    public Realtor() {
    }

    public Realtor(Integer realtorId) {
        this.realtorId = realtorId;
    }

    public Integer getRealtorId() {
        return realtorId;
    }

    public void setRealtorId(Integer realtorId) {
        this.realtorId = realtorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (realtorId != null ? realtorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Realtor)) {
            return false;
        }
        Realtor other = (Realtor) object;
        if ((this.realtorId == null && other.realtorId != null) || (this.realtorId != null && !this.realtorId.equals(other.realtorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.hibirnate.model.Realtor[ realtorId=" + realtorId + " ]";
    }

}
