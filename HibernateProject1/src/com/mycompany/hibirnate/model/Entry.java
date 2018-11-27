package com.mycompany.hibirnate.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "entry")
@NamedQueries({
    @NamedQuery(name = "Entry.findAll", query = "SELECT e FROM Entry e")})
public class Entry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entry_id")
    private Integer entryId;
    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;
    @Column(name = "type_entry")
    private String typeEntry;
    @Column(name = "status_entry")
    private String statusEntry;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "adress")
    private String adress;
    @Column(name = "cost")
    private Long cost;
    @JoinColumn(name = "realtor", referencedColumnName = "email")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @JoinColumn(name = "realty_id", referencedColumnName = "realty_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Realty realty;
    @JoinColumn(name = "client", referencedColumnName = "email")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entry", fetch = FetchType.LAZY)
    private List<Contract> contractList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entry", fetch = FetchType.LAZY)
    private List<Buyrealty> buyrealtyList;

    public Entry() {
    }

    public Entry(Integer entryId) {
        this.entryId = entryId;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getTypeEntry() {
        return typeEntry;
    }

    public void setTypeEntry(String typeEntry) {
        this.typeEntry = typeEntry;
    }

    public String getStatusEntry() {
        return statusEntry;
    }

    public void setStatusEntry(String statusEntry) {
        this.statusEntry = statusEntry;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Realty getRealty() {
        return realty;
    }

    public void setRealty(Realty realty) {
        this.realty = realty;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public List<Buyrealty> getBuyrealtyList() {
        return buyrealtyList;
    }

    public void setBuyrealtyList(List<Buyrealty> buyrealtyList) {
        this.buyrealtyList = buyrealtyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entryId != null ? entryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entry)) {
            return false;
        }
        Entry other = (Entry) object;
        if ((this.entryId == null && other.entryId != null) || (this.entryId != null && !this.entryId.equals(other.entryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Entry[ entryId=" + entryId + " ]";
    }

}
