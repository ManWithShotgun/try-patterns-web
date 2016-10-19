package ru.patterns.behavioral.observer.my;

import java.util.ArrayList;

/**
 * Created by Lenovo-PC on 17.10.2016.
 */
public class SubjectImpl implements Subject {
    ArrayList<Observer> observers;

    public SubjectImpl() {
        observers=new ArrayList<Observer>();
    }

    public void add(Observer o) {
        observers.add(o);
    }

    public void remove(Observer o) {
        observers.remove(o);
    }

    public void notifyObserves(int i) {
        for(Observer o : observers)
            o.update(i);
    }
}
