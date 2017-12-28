/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.models.entity;

/**
 *
 * @author arief
 */
public class Courses {
    private String id;
    private String name;

    public Courses() {
    }

    public Courses(String id, String name) {
        this.id = id;
        this.name = name;
    }

    
    
    
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    
}
