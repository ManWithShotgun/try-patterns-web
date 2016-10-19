package ru.patterns.test1;

/**
 * Created by Lenovo-PC on 13.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Stupid stupid=new Stupid();
        VeryStupid veryStupid=new VeryStupid();
//        VeryStupid veryStupid1= (VeryStupid) new Stupid(); ClassCastException
//        ((VeryStupid)stupid).show(); ClassCastException
        Stupid stupid1=new VeryStupid();
//        Object obj=new Stupid();
//        VeryStupid veryStupid1=(VeryStupid) obj;
//        veryStupid1.show();
        Stupid stupid2=new VeryStupid();
        if(stupid2 instanceof VeryStupid)
            stupid2.show();

    }
}
