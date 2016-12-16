/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;


import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Joss
 */
@ManagedBean(name = "stageBean")
@SessionScoped
public class Stage implements Serializable {
    

    /**
     * Creates a new instance of Stage
     */
    public Stage() {
    }
    
}
