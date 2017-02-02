package ru.nio.test1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ILIA on 01.02.2017.
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {

        InetSocketAddress addr = new InetSocketAddress("localhost", 1111);
        SocketChannel client = SocketChannel.open(addr);

        log("Connecting to Server on port 1111...");

        boolean next=true;
        Scanner scanner=new Scanner(System.in);
        String text;
        while (next){
            log("Enter any words...");
            text=scanner.next();
            log("send "+text);
            ByteBuffer buffer=ByteBuffer.wrap(text.getBytes());
            client.write(buffer);
            buffer.clear();
        }
        client.close();
    }

    private static void log(String str) {
        System.out.println(str);
    }
}
