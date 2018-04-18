/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.test.it;

import com.nrs.vehicle.dao.VehicleDao;
import com.nrs.vehicle.dao.VehicleDaoInterface;
import com.nrs.vehicle.entity.Engine;
import com.nrs.vehicle.entity.Manufacturer;
import com.nrs.vehicle.entity.Motorcycle;
import com.nrs.vehicle.entity.Store;
import com.nrs.vehicle.entity.StoreVehicleInterim;
import com.nrs.vehicle.entity.Vehicle;
import com.nrs.vehicle.entity.MotorCar;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author root
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-vehicle-dao-context.xml"})
public class VehicleDaoTest {
    @Autowired
    VehicleDaoInterface<Vehicle,Integer> dao;
    Process database;
    Engine engine;
    Store store;
    Manufacturer manufacturer;
    Vehicle vehicle;
    Motorcycle motorcycle;
    MotorCar motorcar;
    
    @Before
    public void setUp() throws IOException{
        File db = new File("src/test/resources/h2-1.4.197.jar");
        database = Runtime.getRuntime().exec(new String[]{"java","-jar",db.getAbsolutePath()});
        prepareData();
    }
    
    @Test
    public void testInsert(){
        
        Assert.assertNotEquals(dao.findById(1),null);
        Assert.assertEquals(dao.findById(1).getManufacturer().equals(manufacturer), true);
        Assert.assertEquals(dao.findById(1).getEngine().equals(engine), true);
        System.out.println("idmf" + dao.findById(1).getId());
    }
    @Test
    public void testUpdate(){
        vehicle.setCost(9000);
        System.out.println("idmf2" + vehicle.getId());
        dao.update(vehicle);
        Assert.assertEquals(new Float(dao.findById(1).getCost()), new Float(vehicle.getCost()));
    }
    @After
    public void destroy(){
        database.destroy();
    }
    
    public void prepareData(){
        vehicle = new Motorcycle();
        vehicle.setCost(200);
        vehicle.setHeight(500);
        vehicle.setLength(20000);
        vehicle.setMaxSpeed(1200);
        vehicle.setWeight(400);
        
        manufacturer = new Manufacturer();
        manufacturer.setCountry("China");
        manufacturer.setName("IDK");
        manufacturer.setSiteUrl("http://not-exist.com");
        vehicle.setManufacturer(manufacturer);
        
        engine = new Engine();
//        engine.setTransmissionType(transmissionType);
        vehicle.setEngine(engine);
        
        store = new Store();
        store.setAddress("some address");
        store.setName("some name");
        HashSet<StoreVehicleInterim> set = new HashSet<>();
        StoreVehicleInterim svi = new StoreVehicleInterim();
        svi.setStore(store);
        svi.setVehicle(vehicle);
        set.add(svi);
        vehicle.setStores(set);
        
        dao.persist(vehicle);
    }
}
