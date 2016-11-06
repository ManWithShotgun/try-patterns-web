package ru.patterns.behavioral.chainofresponsibiliy.example1;

/**
 * Created by Lenovo-PC on 31.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Task task=new Task("taskMsg");
        SubTask subTask=new SubTask("subTaskMsg",task);
        Question question=new Question("questionMsg",subTask);

        System.out.println("Question msg "+question.handleRequest());
    }
}
