package ru.patterns.behavioral.chainofresponsibiliy.example2;

/**
 * Created by Lenovo-PC on 01.11.2016.
 */
public class Authentification extends AbstractHandler {
    public void handleRequest(Employee employee) {
        if(this.checkStatus(employee)){
//            some code
        }
    }

    private boolean checkStatus(Employee employee){
        employee.print();
        System.out.println("Authentification: checkStatus");
        return true;
    }
}
