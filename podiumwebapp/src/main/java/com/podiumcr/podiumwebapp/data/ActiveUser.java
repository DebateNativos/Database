/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumwebapp.data;

import com.podiumcr.jpa.entities.User;

/**
 *
 * @author Soler
 */
public class ActiveUser {

    private long idUsers;
    private String name;
    private String lastName;
    private String lastName2;
    private String email;
    private String phone;
    private String idToken;
    private int idUniversity;
    private String address;

    public ActiveUser() {

    }

    public ActiveUser(long idUsers, String name, String lastName, String lastName2, String email, String phone, String idToken, int idUniversity, String address) {
        this.idUsers = idUsers;
        this.name = name;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.email = email;
        this.phone = phone;
        this.idToken = idToken;
        this.idUniversity = idUniversity;
        this.address = address;
    }
    
    public ActiveUser(User u){
        this.idUsers = u.getIdUsers();
        this.name = u.getName();
        this.lastName = u.getLastName();
        this.lastName2 = u.getLastName2();
        this.email = u.getEmail();
        this.phone = u.getPhone();
        this.idToken = u.getIdToken();
        this.idUniversity = u.getIdUniversity();
        this.address = u.getAddress();
    }
    
    public long getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(long idUsers) {
        this.idUsers = idUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
