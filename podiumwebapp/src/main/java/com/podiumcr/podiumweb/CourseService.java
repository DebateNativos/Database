package com.podiumcr.podiumweb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.podiumcr.jpa.entities.Course;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "courseService")
@ApplicationScoped

public class CourseService {

 
    private final static String[] names;

    private final static String[] terms;

    private final static String[] codes;

    private final static String[] years;
     
    static {
        codes = new String[3];
        codes[0] = "1";
        codes[1] = "2";
        codes[2] = "3";
     
         
        names = new String[3];
        names[0] = "Mate";
        names[1] = "Química";
        names[2] = "Física";
        
        years = new String[3];
        years [0] = "ΩΩ";
        years [1] = "Mercedes";
        years [2] = "Volvo";
        
        terms = new String[3];
        terms [0] = "BMW";
        terms [1] = "Mercedes";
        terms [2] = "Volvo";
    }

     
    public List<Course> createCourses(int size) {
        List<Course> list = new ArrayList<>();
        for(int i = 0 ; i < size ; i++) {
            
        }
         
        return list;
    }
     
    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
     
    private String getRandomYear() {
        int year = (int)(Math.random() * 50 + 1960);
        String year2 = Integer.toString(year);
        return   year2;
    }
     
    private String getRandomCodes() {
        return codes[(int) (Math.random() * 3)];
    }
     
    private String getRandomNames() {
        return names[(int) (Math.random() * 3)];
    }

    public List<String> getCodes() {
        return Arrays.asList(codes);
    }
     
    public List<String> getNames() {
        return Arrays.asList(names);
    }
    
    
}
