/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.entities.DebateSection;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Soler
 */
@ManagedBean(name = "debatetype")
@SessionScoped
public class DebateTypeView implements Serializable{
    
    private int idDebateTypes;
    private String description;
    private String name;
    private String rules;
    private int totalTimeInMinutes;
    private List<DebateSection> sections;

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
    
    
}
