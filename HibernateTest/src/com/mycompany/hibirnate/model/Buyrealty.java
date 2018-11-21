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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "buyrealty")
public class Buyrealty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bay_id")
    private Integer bayId;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "phone")
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyrealty", fetch = FetchType.LAZY)
    private List<Contract> contractList;
    @JoinColumn(name = "client", referencedColumnName = "email")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
    @JoinColumn(name = "entry_id", referencedColumnName = "entry_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Entry entry;

    public Buyrealty() {
    }

    public Buyrealty(Integer bayId) {
        this.bayId = bayId;
    }

    public Integer getBayId() {
        return bayId;
    }

    public void setBayId(Integer bayId) {
        this.bayId = bayId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bayId != null ? bayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buyrealty)) {
            return false;
        }
        Buyrealty other = (Buyrealty) object;
        if ((this.bayId == null && other.bayId != null) || (this.bayId != null && !this.bayId.equals(other.bayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Buyrealty[ bayId=" + bayId + " ]";
    }

}
