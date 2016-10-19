package ru.patterns.behavioral.composite;

import java.util.ArrayList;

/**
 * Created by Lenovo-PC on 15.10.2016.
 */
public class Menu extends MenuComponent {
    ArrayList<MenuComponent> menuComponents=new ArrayList<MenuComponent>();

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponents.get(index);
    }

    @Override
    public void print() {
        for(MenuComponent menuComponent : menuComponents){
            menuComponent.print();
        }
    }
}
