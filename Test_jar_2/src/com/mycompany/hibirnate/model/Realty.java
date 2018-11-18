package com.mycompany.hibirnate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "realty")
public class Realty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "realty_id")
    private Integer realtyId;
    @Column(name = "rooms")
    private Integer rooms;
    @Column(name = "type_realty")
    private String typeRealty;
    @Column(name = "cost")
    private Long cost;
    @Lob
    @Column(name = "info")
    private String info;
    @Lob
    @Column(name = "image")
    private byte[] image;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "area")
    private Float area;
    @Column(name = "number_floors")
    private Integer numberFloors;
    @JoinColumn(name = "city_id", referencedColumnName = "City_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private City city;

    public Realty() {
    }

    public Realty(Integer realtyId) {
        this.realtyId = realtyId;
    }

    public Integer getRealtyId() {
        return realtyId;
    }

    public void setRealtyId(Integer realtyId) {
        this.realtyId = realtyId;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getTypeRealty() {
        return typeRealty;
    }

    public void setTypeRealty(String typeRealty) {
        this.typeRealty = typeRealty;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Integer getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(Integer numberFloors) {
        this.numberFloors = numberFloors;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (realtyId != null ? realtyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Realty)) {
            return false;
        }
        Realty other = (Realty) object;
        if ((this.realtyId == null && other.realtyId != null) || (this.realtyId != null && !this.realtyId.equals(other.realtyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.hibirnate.model.Realty[ realtyId=" + realtyId + " ]";
    }

}
