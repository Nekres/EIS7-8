/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.entity;

import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nrs
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id", updatable = false, nullable = false)
    protected int id;
    @Column(nullable = false)
    protected float weight;
    @Column(nullable = false)
    protected float height;
    
    @Column(nullable = false)
    protected float length;
    
    @Column(name = "max_speed",nullable = false)
    protected float maxSpeed;
    
    @Column(nullable = false)
    protected float cost;
    
    @Column(name = "produce_date")
    @Temporal(TemporalType.DATE)
    protected Date produceDate;
    @ManyToOne(cascade = CascadeType.ALL)
    protected Manufacturer manufacturer;
    @OneToMany(mappedBy = "store",fetch = FetchType.EAGER)
    protected Set<StoreVehicleInterim> stores;
    @OneToOne(cascade = CascadeType.ALL)
    protected Engine engine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Set<StoreVehicleInterim> getStores() {
        return stores;
    }

    public void setStores(Set<StoreVehicleInterim> stores) {
        this.stores = stores;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Float.floatToIntBits(this.weight);
        hash = 73 * hash + Float.floatToIntBits(this.height);
        hash = 73 * hash + Float.floatToIntBits(this.length);
        hash = 73 * hash + Float.floatToIntBits(this.maxSpeed);
        hash = 73 * hash + Float.floatToIntBits(this.cost);
        hash = 73 * hash + Objects.hashCode(this.produceDate);
        hash = 73 * hash + Objects.hashCode(this.manufacturer);
        hash = 73 * hash + Objects.hashCode(this.stores);
        hash = 73 * hash + Objects.hashCode(this.engine);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(other.weight)) {
            return false;
        }
        if (Float.floatToIntBits(this.height) != Float.floatToIntBits(other.height)) {
            return false;
        }
        if (Float.floatToIntBits(this.length) != Float.floatToIntBits(other.length)) {
            return false;
        }
        if (Float.floatToIntBits(this.maxSpeed) != Float.floatToIntBits(other.maxSpeed)) {
            return false;
        }
        if (Float.floatToIntBits(this.cost) != Float.floatToIntBits(other.cost)) {
            return false;
        }
        if (!Objects.equals(this.produceDate, other.produceDate)) {
            return false;
        }
        if (!Objects.equals(this.manufacturer, other.manufacturer)) {
            return false;
        }
        if (!Objects.equals(this.stores, other.stores)) {
            return false;
        }
        if (!Objects.equals(this.engine, other.engine)) {
            return false;
        }
        return true;
    }
   
    
    
}
