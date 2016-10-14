/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.data;

import com.riuldebates.data.UserData;
import com.riuldebates.entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chang
 */
public class Cliente {

    int id;
    String nombre;
    int edad;

    public Cliente() {
    }

    public Cliente(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Cliente> transformUsersFromJPA() {

        ArrayList<Cliente> ac = new ArrayList<>();
        Cliente c = new Cliente();
        UserData ud = new UserData();
        List<User> u = ud.getUsers();

        for (User user : u) {
            c.nombre = user.getName();
            c.id = user.getIdUsers();
            ac.add(c);
        }

        return ac;
    }

}
