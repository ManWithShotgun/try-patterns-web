package ru.patterns.behavioral.template;

/**
 * Created by Lenovo-PC on 27.10.2016.
 */
public class ConcretMaker3 extends AbstractMaker {
    public void step1() {
        System.out.println("step1 from CM_3");
    }

    public void step2() {
        System.out.println("step2 from CM_3");
    }

    @Override
    public boolean forHookCondiments() {
        return true;
    }
}
