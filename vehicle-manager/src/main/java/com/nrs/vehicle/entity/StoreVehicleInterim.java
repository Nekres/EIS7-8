/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author nrs
 */
@Entity
public class StoreVehicleInterim {
    
    @EmbeddedId
    private StoreVehiclePK pk;
    @ManyToOne
    @MapsId("vehicleId")
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @MapsId("storeId")
    @JoinColumn(name = "store_id")
    private Store store;

    public StoreVehicleInterim(Vehicle vehicle, Store store) {
        this.vehicle = vehicle;
        this.store = store;
    }

    public StoreVehicleInterim() {
    }

    public StoreVehiclePK getPk() {
        return pk;
    }

    public void setPk(StoreVehiclePK pk) {
        this.pk = pk;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    
    
    
}
