/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.DebateTypeData;
import com.podiumcr.jpa.entities.DebateSection;
import com.podiumcr.jpa.entities.DebateType;
import static com.podiumcr.podiumwebapp.common.EntityListener.em;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

/**
 *
 * @author Soler
 */
@ManagedBean(name = "debatetypeBean")
@SessionScoped


public class DebateTypeView implements Serializable{
    
   @ManagedProperty(value = "#{login}")
    private LoginAdmin login; 
    
    private EntityManager em = null;
    private int idDebateTypes;
    private String description;
    private String name;
    private String rules;
    private int totalTimeInMinutes;
    private List<DebateSection> sections;
    
    private List<DebateType> types;
    private DebateType typeD;

    public DebateTypeView() {
    }
    
    public DebateTypeView(int idDebateTypes, String description, String name, String rules, int totalTimeInMinutes, List<DebateSection> sections) {
        this.idDebateTypes = idDebateTypes;
        this.description = description;
        this.name = name;
        this.rules = rules;
        this.totalTimeInMinutes = totalTimeInMinutes;
        this.sections = sections;
    }
    
    @PostConstruct
    public void init() {
          if (this.em==null) {
             this.em = login.em;
        }
        if (this.types == null) {
        DebateTypeData dtd = new DebateTypeData(em);
        this.types = dtd.getAll();      
        }
        if (this.typeD == null) {
        this.typeD = new DebateType();
           
        }
    }
    
    public int getIdDebateTypes() {
        return idDebateTypes;
    }

    public void setIdDebateTypes(int idDebateTypes) {
        this.idDebateTypes = idDebateTypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public int getTotalTimeInMinutes() {
        return totalTimeInMinutes;
    }

    public void setTotalTimeInMinutes(int totalTimeInMinutes) {
        this.totalTimeInMinutes = totalTimeInMinutes;
    }

    public List<DebateSection> getSections() {
        return sections;
    }

    public void setSections(List<DebateSection> sections) {
        this.sections = sections;
    }

    public List<DebateType> getTypes() {
        return types;
    }

    public void setTypes(List<DebateType> types) {
        this.types = types;
    }

    public DebateType getTypeD() {
        return typeD;
    }

    public void setTypeD(DebateType typeD) {
        this.typeD = typeD;
    }
    
    
}
