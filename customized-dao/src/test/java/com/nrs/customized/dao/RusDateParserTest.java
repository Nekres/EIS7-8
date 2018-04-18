/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.customized.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author nrs
 */
public class RusDateParserTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    public void testGetWeek() throws ParseException{
        final RusDateParser parser = new RusDateParser();
        final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        final Date sunday = format.parse("18-03-2018");
        
        Assert.assertEquals(parser.getWeek(sunday),"Воскресенье");
        
        final Date monday = format.parse("19-03-2018");
        Assert.assertEquals(parser.getWeek(monday), "Понедельник");
        
        final Date tuesday = format.parse("20-03-2018");
        Assert.assertEquals(parser.getWeek(tuesday), "Вторник");
        final Date wednesday = format.parse("21-03-2018");
        Assert.assertEquals(parser.getWeek(wednesday), "Среда");
        
        final Date thursday = format.parse("22-03-2018");
        Assert.assertEquals(parser.getWeek(thursday), "Четверг");
        
        final Date friday = format.parse("23-03-2018");
        Assert.assertEquals(parser.getWeek(friday), "Пятница");
        
        final Date saturday = format.parse("24-03-2018");
        Assert.assertEquals(parser.getWeek(saturday), "Суббота");
        
    }
    @Test
    public void testGetWeekOnNull(){
        thrown.expect(NullPointerException.class);
        RusDateParser parser = new RusDateParser();
        parser.getWeek(null);
    }
}
