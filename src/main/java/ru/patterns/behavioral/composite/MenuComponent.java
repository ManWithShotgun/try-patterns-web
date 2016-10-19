package ru.patterns.behavioral.composite;

/**
 * Created by Lenovo-PC on 15.10.2016.
 */
public abstract class MenuComponent {
    public String getName(){
        throw new UnsupportedOperationException();
    }

    public double getPrice(){
        throw new UnsupportedOperationException();
    }

    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int index){
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }
}
