/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package com.arief.models.databases;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

//asdasd    

/**
 *
 * @author arief
 */
public class ConnectionFactory {
    private final BasicDataSource bsd;

    public ConnectionFactory() {
        bsd = new BasicDataSource();
        bsd.setDriverClassName("com.mysql.jdbc.Driver");
        bsd.setUsername("arief");
        bsd.setPassword("arief");
        bsd.setUrl("jdbc:mysql://localhost:3306/dbcp_db2");
        
        bsd.setMaxTotal(100);
        bsd.setMaxIdle(80);
    }
    
    public Connection getConnectionInstance()throws SQLException {
        return this.bsd.getConnection();
    }
}
