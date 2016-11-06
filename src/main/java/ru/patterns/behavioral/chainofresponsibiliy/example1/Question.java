package ru.patterns.behavioral.chainofresponsibiliy.example1;

/**
 * Created by Lenovo-PC on 31.10.2016.
 */
public class Question implements BaseInterface {
    private String message;
    private SubTask root=null;

    public Question(String message, SubTask root) {
        this.message = message;
        this.root = root;
    }

    public String handleRequest() {
        System.out.println("message in Question "+message);
        if(root==null)
            return message;
        else
            return root.handleRequest();
    }
}
