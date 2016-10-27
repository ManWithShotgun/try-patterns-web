package ru.patterns.behavioral.template;

/**
 * Created by Lenovo-PC on 27.10.2016.
 */
public class ConcretMaker2 extends AbstractMaker {

    @Override
    public void step0() {
        System.out.println("override: step0 from CM_1");
    }

    public void step1() {
        System.out.println("step1 from CM_2");
    }

    public void step2() {
        System.out.println("step2 from CM_2");
    }
}
