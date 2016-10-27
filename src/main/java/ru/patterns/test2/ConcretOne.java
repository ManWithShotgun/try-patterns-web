package ru.patterns.test2;

/**
 * Created by Lenovo-PC on 24.10.2016.
 */
public class ConcretOne implements  Any {
    public void method() {
        this.concretOne();
    }

    private void concretOne(){
        System.out.println("concret1");
    }
}
