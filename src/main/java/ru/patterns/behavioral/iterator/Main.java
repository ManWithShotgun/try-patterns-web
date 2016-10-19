package ru.patterns.behavioral.iterator;

/**
 * Created by Lenovo-PC on 15.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Waitress waitress=new Waitress(new PancakeHouseMenu(),new DinerMenu());
        waitress.printMenu();
    }
}
