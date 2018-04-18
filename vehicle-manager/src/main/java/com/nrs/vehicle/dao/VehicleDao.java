/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.dao;

import com.nrs.vehicle.entity.Vehicle;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author nrs
 */
@Transactional
public class VehicleDao implements VehicleDaoInterface<Vehicle, Integer>{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void persist(Vehicle entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Vehicle entity) {
        entityManager.merge(entity);
    }

    @Override
    public Vehicle findById(Integer id) {
        Vehicle v = entityManager.find(Vehicle.class, id);
        return v;
    }

    @Override
    public void delete(Vehicle entity) {
        entityManager.remove(entity);
    }

    
}
