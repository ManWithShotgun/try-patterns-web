package ru.patterns.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Lenovo-PC on 17.10.2016.
 */
public class ObserverOne implements Observer{

    int a;

    public ObserverOne(Observable observable) {
        observable.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        if(o instanceof Subject){
            a=((Subject) o).getA();
            System.out.println(this.getClass().getName()+" a: "+a);
        }
    }
}
