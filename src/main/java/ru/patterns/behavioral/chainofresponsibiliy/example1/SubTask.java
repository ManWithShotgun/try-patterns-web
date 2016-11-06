package ru.patterns.behavioral.chainofresponsibiliy.example1;

/**
 * Created by Lenovo-PC on 31.10.2016.
 */
public class SubTask implements BaseInterface {
    private String message;
    private Task root=null;

    public SubTask(String message, Task root) {
        this.message = message;
        this.root = root;
    }

    public String handleRequest() {
        System.out.println("message in SubTask "+message);
        if(root==null)
            return message;
        else
            return root.handleRequest();
    }
}
