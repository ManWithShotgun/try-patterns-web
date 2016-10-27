package ru.patterns.behavioral.template;

/**
 * Created by Lenovo-PC on 27.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        AbstractMaker maker=new ConcretMaker1();
        maker.templateMathod();
        System.out.println("=======================");
        maker=new ConcretMaker2();
        maker.templateMathod();
        System.out.println("=======================");
        maker=new ConcretMaker3();
        maker.templateMathod();
        System.out.println("=======================");
    }
}
