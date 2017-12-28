/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arief
 */
public class MyLoggerApp {
    private final String className;
    private final Logger logger;
    
    public MyLoggerApp(String className) {
        this.className = className;
        logger = Logger.getLogger(className);
    }
    
    
    public void doLogInfo(String message,String methodName,String outputVal){
        logger.log(Level.INFO,"'{0}' {1} : {2}",new Object[]{methodName,message,outputVal});
    }
    public void doLogError(String message,String methodName,String outputVal){
        logger.log(Level.SEVERE,"'{0}' {1} : {2} ",new Object[]{methodName,message,outputVal});
    }
}
