/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author nrs
 */
@Entity
public class MotorCar extends Vehicle{
    
    @Column(nullable = false, name = "is_public")
    private boolean isPublic;
    @Column(name = "auto_bodywork_type", nullable = false)
    private boolean automotiveBodyworkType;

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public boolean isAutomotiveBodyworkType() {
        return automotiveBodyworkType;
    }

    public void setAutomotiveBodyworkType(boolean automotiveBodyworkType) {
        this.automotiveBodyworkType = automotiveBodyworkType;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 79 * hash + (this.isPublic ? 1 : 0);
        hash = 79 * hash + (this.automotiveBodyworkType ? 1 : 0);
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
        final MotorCar other = (MotorCar) obj;
        if (this.isPublic != other.isPublic) {
            return false;
        }
        if (this.automotiveBodyworkType != other.automotiveBodyworkType) {
            return false;
        }
        return super.equals(obj);
    }
    
    
}