package ru.patterns.behavioral.observer.my;

/**
 * Created by Lenovo-PC on 17.10.2016.
 */
public class OneObserver implements Observer {

    public void update(int i) {
        System.out.println(this.getClass().getName()+" "+i);
    }
}
