package com.zistrong.jakartaee.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * slf4j has some issues in glassfish 7.x, Junit is OK!
 */
public class JakartaEETest {


    @Test
    public void testSlf4j() {
        Logger logger = LoggerFactory.getLogger(JakartaEETest.class);
        logger.info("now = {}", new Date());
    }
}
