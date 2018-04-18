/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.dao;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nrs
 */

public interface VehicleDaoInterface<E,K> {
    
    public void persist(E entity);
    public void update(E entity);
    public E findById(K id);
    public void delete(E entity);
    
    

    
}
