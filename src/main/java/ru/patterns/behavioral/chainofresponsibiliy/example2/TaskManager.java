package ru.patterns.behavioral.chainofresponsibiliy.example2;

/**
 * Created by Lenovo-PC on 01.11.2016.
 */
public class TaskManager extends AbstractHandler {
    public void handleRequest(Employee employee) {
        this.assignTask();
    }

    private void assignTask(){
        System.out.println("TaskManager: assign task");
    }
}
