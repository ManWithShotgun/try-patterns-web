package ru.patterns.behavioral.composite;

/**
 * Created by Lenovo-PC on 15.10.2016.
 */
public class MenuItem extends MenuComponent {

    String name;
    double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.printf("I: %s %.1f\n",name,price);
    }
}
