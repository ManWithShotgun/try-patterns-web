package ru.patterns.behavioral.observer.my;

/**
 * Created by Lenovo-PC on 17.10.2016.
 */
public interface Subject {
    void add(Observer o);
    void remove(Observer o);
    void notifyObserves(int i);
}
