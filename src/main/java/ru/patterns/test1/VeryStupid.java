package ru.patterns.test1;

/**
 * Created by Lenovo-PC on 13.10.2016.
 */
public class VeryStupid extends Stupid {
    @Override
    void show() {
        this.any();
        System.out.println("Very stupid");
    }

    private void any(){
        System.out.println("any");
    }
}
