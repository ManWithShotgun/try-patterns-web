package ru.patterns.behavioral.chainofresponsibiliy.example2;

/**
 * Created by Lenovo-PC on 01.11.2016.
 */
public class DefaultHandleRequest extends AbstractHandler{
    private static DefaultHandleRequest handle=new DefaultHandleRequest();

    private DefaultHandleRequest() {
    }

    public static DefaultHandleRequest getHandleRequest() {
        return handle;
    }

    @Override
    public void chain(Employee employee) {
//        super.chain(employee);
    }

    public void handleRequest(Employee employee) {
        System.out.println("Default handleRequest");
    }
}
