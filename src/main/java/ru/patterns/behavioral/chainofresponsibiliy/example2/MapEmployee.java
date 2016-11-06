package ru.patterns.behavioral.chainofresponsibiliy.example2;

import java.util.HashMap;

/**
 * Created by Lenovo-PC on 01.11.2016.
 */
public class MapEmployee {
    private HashMap<Integer,Employee> users=new HashMap<Integer, Employee>();

    public MapEmployee() {
        users.put(1,new Employee(20,"admin","passAdm"));
        users.put(2,new Employee(30,"moder","passModer"));
        users.put(3,new Employee(40,"user","passUser"));
    }

    public HashMap<Integer, Employee> getUsers() {
        return users;
    }

    public boolean containsUser(Employee employee){
        return users.containsValue(employee);
    }
}
