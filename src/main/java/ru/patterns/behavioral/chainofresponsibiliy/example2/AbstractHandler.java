package ru.patterns.behavioral.chainofresponsibiliy.example2;

import ru.patterns.behavioral.template.AbstractMaker;

/**
 * Created by Lenovo-PC on 01.11.2016.
 */
abstract class AbstractHandler {
    protected MapEmployee db;
    protected AbstractHandler successor=DefaultHandleRequest.getHandleRequest();

    public AbstractHandler(AbstractHandler successor) {
        this.db=new MapEmployee();
        this.successor = successor;
    }

    public AbstractHandler() {
        this.db=new MapEmployee();
    }

    public void setSuccessor(AbstractHandler successor) {
        this.successor = successor;
    }

    abstract public void handleRequest(Employee employee);

    public void chain(Employee employee){
        if(db.containsUser(employee)){
            handleRequest(employee);
            successor.chain(employee);
        }else {
            System.out.println("user don't exist");
        }
    }
}
