package ru.patterns.behavioral.observer;

import java.util.Observable;

/**
 * Created by Lenovo-PC on 17.10.2016.
 */
public class Subject extends Observable {
    private int a,b;

    public void setUpdate(int a, int b){
        this.a=a;
        this.b=b;
        setChanged();
        notifyObservers();
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
