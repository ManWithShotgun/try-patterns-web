package ru.patterns.behavioral.observer;

import ru.patterns.behavioral.observer.my.OneObserver;
import ru.patterns.behavioral.observer.my.SubjectImpl;
import ru.patterns.behavioral.observer.my.TwoObserver;

import java.util.Enumeration;

/**
 * Created by Lenovo-PC on 17.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Subject subject=new Subject();
        new ObserverOne(subject);
        new ObserverTwo(subject);
        subject.setUpdate(4,8);
    }

    private static void myObsorver(){
        SubjectImpl subject=new SubjectImpl();
        subject.add(new OneObserver());
        subject.notifyObserves(1);
        subject.add(new TwoObserver());
        subject.add(new OneObserver());
        subject.add(new TwoObserver());
        subject.notifyObserves(123);
    }
}
