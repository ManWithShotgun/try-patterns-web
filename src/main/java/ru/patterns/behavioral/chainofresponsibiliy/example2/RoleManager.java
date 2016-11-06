package ru.patterns.behavioral.chainofresponsibiliy.example2;

/**
 * Created by Lenovo-PC on 01.11.2016.
 */
public class RoleManager extends AbstractHandler {

    public void handleRequest(Employee employee) {
        this.checkPermission(employee);
    }
    private void checkPermission(Employee employee){
        System.out.println("RoleManager: check role");
    }
}
