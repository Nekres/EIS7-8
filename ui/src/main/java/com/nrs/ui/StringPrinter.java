/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.ui;

import com.nrs.cacheable.CacheManager;
import com.nrs.cacheable.LeastRecentlyUsed;
import com.nrs.cacheable.exceptions.NonCacheableException;
import com.nrs.service.BaseWeekDayChecker;
import com.nrs.service.WeekDayChecker;
import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author root
 */
public class StringPrinter {

    public static final Logger logger = LoggerFactory.getLogger(StringPrinter.class);

    public static void main(String[] args) throws NonCacheableException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath*:*-context.xml"});
        
        CacheManager<BaseWeekDayChecker> manager = (CacheManager<BaseWeekDayChecker>)ctx.getBean("lruCache");
        BaseWeekDayChecker weekChecker = manager.buildProxy((WeekDayChecker)ctx.getBean("dayChecker"));

        String argument = null;
        if (args == null || args.length != 1) {
            System.err.println("Pass an argument, please. Format must be dd-MM-yyyy");
            return;
        } else {
            argument = args[0];
        }
        try {
            long start = System.currentTimeMillis();
            String result = weekChecker.parseWeek(argument);
            long end = System.currentTimeMillis() - start;
            logger.info("Method execution time without caching: " + end + " ms");
            System.out.println("The day of week is " + result);
        } catch (ParseException ex) {
            System.err.println("Wrong date format. Format must be \"dd-MM-yyyy\"");
            return;
        }
        try {
            long startAgain = System.currentTimeMillis();
            final String sameValue = weekChecker.parseWeek(argument);
            logger.info("Result: " + sameValue);
            logger.info("Method execution time with caching " + (System.currentTimeMillis() - startAgain) + " ms");
        } catch (ParseException ex) {
            System.err.println("Wrong date format. Format must be \"dd-MM-yyyy\"");
        }

    }
}
