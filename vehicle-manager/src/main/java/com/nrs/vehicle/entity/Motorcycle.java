/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author nrs
 */
@Table
@Entity
public class Motorcycle extends Vehicle{
    
    @Column(nullable = false,name = "is_one_man_type")
    private boolean isOneManType;
    @Column(nullable = false,name = "has_side_car")
    private boolean hasSidecar;

    public boolean isIsOneManType() {
        return isOneManType;
    }

    public void setIsOneManType(boolean isOneManType) {
        this.isOneManType = isOneManType;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 79 * hash + (this.isOneManType ? 1 : 0);
        hash = 79 * hash + (this.hasSidecar ? 1 : 0);
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
        final Motorcycle other = (Motorcycle) obj;
        if (this.isOneManType != other.isOneManType) {
            return false;
        }
        if (this.hasSidecar != other.hasSidecar) {
            return false;
        }
        
        return super.equals(obj);
    }
    
    
   
    
    
    
}
