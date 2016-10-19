package ru.patterns.behavioral.composite;

/**
 * Created by Lenovo-PC on 15.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        /*In new version create Iterator*/
        MenuComponent diner=new Menu();
        MenuComponent cafe=new Menu();
        MenuComponent pancake=new Menu();
        MenuComponent startMenu=new Menu();
        startMenu.add(diner);
        startMenu.add(cafe);
        startMenu.add(pancake);
        diner.add(new MenuItem("abc1",234));
        diner.add(new MenuItem("abc2",4));
        diner.add(new MenuItem("abc3",34));
        cafe.add(new MenuItem("cafe1",55));
        pancake.add(new MenuItem("cake1",78));
        pancake.add(new MenuItem("cake2",7));
        pancake.add(new MenuItem("cake3",8));

        Waitress waitress=new Waitress(startMenu);
        waitress.printMenu();
    }
}
