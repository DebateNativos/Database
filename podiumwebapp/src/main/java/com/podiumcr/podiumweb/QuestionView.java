/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import com.podiumcr.jpa.data.QuestionData;
import com.podiumcr.jpa.entities.Question;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

/**
 *
 * @author Joss
 */

@ManagedBean(name = "questionBean")
@SessionScoped
public class QuestionView implements Serializable {
@ManagedProperty(value = "#{login}")
    private LoginAdmin login;

    EntityManager em = null;
    
    
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
   
   

    @PostConstruct
    public void init() {
        
        if (this.questions == null) {
         QuestionData p = new QuestionData(em);
         this.questions = p.getQuestions();      
        }    
    }

    
    
    
}
