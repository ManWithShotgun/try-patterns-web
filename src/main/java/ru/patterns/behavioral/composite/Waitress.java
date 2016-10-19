package ru.patterns.behavioral.composite;

/**
 * Created by Lenovo-PC on 15.10.2016.
 */
public class Waitress {
    MenuComponent startMenu;

    public Waitress(MenuComponent startMenu) {
        this.startMenu = startMenu;
    }

    public void printMenu(){
        this.startMenu.print();
    }
}
