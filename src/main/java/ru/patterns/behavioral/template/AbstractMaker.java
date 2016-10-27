package ru.patterns.behavioral.template;

/**
 * Created by Lenovo-PC on 27.10.2016.
 */
public abstract class AbstractMaker {

    public void templateMathod(){
        this.step0();
        this.step1();
        this.step2();
        this.step3();
        this.concretStep();
        if(forHookCondiments())
            this.hook();
    }

    public void step0(){/*default realization*/
        System.out.println("step0 from AbstractMaker");
    }

    public abstract void step1();
    public abstract void step2();
    public void step3(){/*default realization*/
        System.out.println("step3 from AbstractMaker");
    }

    final public void concretStep(){/*Конкретная реализация абстракного класса; нельзя изменить*/
        System.out.println("concretStep from AbstractMaker");
    }

    /*условие для перехватчика. По дефолту отключено*/
    /*Можно убрать это условие включив hook в шаблонный метод без if,
     но необходимо сделать реализацию hook пустой*/
    public boolean forHookCondiments(){
        return false;
    }

    public void hook(){
        System.out.println("Default realiz. hook");
    }
}
