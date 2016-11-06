package ru.patterns.behavioral.chainofresponsibiliy.example2;

/**
 * Created by Lenovo-PC on 01.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Employee employee=new Employee(20,"admin", "passAdm");
        Authentification authentification=new Authentification();
        RoleManager roleManager=new RoleManager();
        TaskManager taskManager=new TaskManager();

        authentification.setSuccessor(roleManager);
        roleManager.setSuccessor(taskManager);
        System.out.println("--start chain--");
        authentification.chain(employee);
    }
}
