package ru.patterns.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Lenovo-PC on 17.10.2016.
 */
public class ObserverTwo implements Observer {
    int b;

    public ObserverTwo(Observable observable) {
        observable.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        if(o instanceof Subject){
            b=((Subject) o).getB();
            System.out.println(this.getClass().getName()+" b: "+b);
        }
    }
}
