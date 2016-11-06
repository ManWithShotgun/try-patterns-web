package ru.patterns.behavioral.chainofresponsibiliy.example1;

/**
 * Created by Lenovo-PC on 31.10.2016.
 */
public class Task implements BaseInterface {
    private String message;

    public Task(String message) {
        this.message = message;
    }

    public String handleRequest() {
        System.out.println("message in Task "+message);
        return message;
    }
}
