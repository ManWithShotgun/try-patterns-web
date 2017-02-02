package ru.nio.calc;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ILIA on 02.02.2017.
 */
public class ServerCalc {
    public static void main(String[] args) throws IOException, InterruptedException {
        Selector selector = Selector.open();

        ServerSocketChannel socket = ServerSocketChannel.open();
        InetSocketAddress addr = new InetSocketAddress("localhost", 1111);

        socket.bind(addr);

        socket.configureBlocking(false);

        int ops = socket.validOps();
        SelectionKey selectKy = socket.register(selector, ops, null);

        while (true) {
            log("wait connection...");
            selector.select();
//            Thread.sleep(2000);


            // token representing the registration of a SelectableChannel with a Selector
            Set<SelectionKey> keys = selector.selectedKeys();
            log("keys: "+keys.size());
            for (SelectionKey k : keys){
                log("k: "+k.readyOps());
            }
            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey myKey = iterator.next();

                // Tests whether this key's channel is ready to accept a new socket connection
                if (myKey.isAcceptable()) {
                    log("ACCEPTABLE");
                    SocketChannel client = socket.accept();

                    // Adjusts this channel's blocking mode to false
                    client.configureBlocking(false);

                    /*Обезательно надо регистрировать на клиента*/
                    client.register(selector, SelectionKey.OP_READ);
//                    myKey.interestOps(SelectionKey.OP_READ);
                    log("Connection Accepted: " + client.getLocalAddress() + "\n");

                    // Tests whether this key's channel is ready for reading
                } else if (myKey.isReadable()) {
                    try {
//                        Thread.sleep(10000);
                        log("READABLE");
                        SocketChannel client = (SocketChannel) myKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(256);
                        client.read(buffer);
                        String recv = new String(buffer.array()).trim();
                        log("received: " + recv);
                        if (recv.equals("exit")) {
                            client.close();
                            log("recv exit");
                            continue;
                        }
                        String sendText="";
                        String[] strings=recv.split(";");
//                        for (String str : strings){
//                            log("str "+str);
//                        }
                        if(strings[0].equals("1")){
                            double x=Double.parseDouble(strings[1]);
                            sendText+= Math.sin(x);
                        }
                        if(strings[0].equals("2")){
                            double x=Double.parseDouble(strings[1]);
                            sendText+= Math.cos(x);
                        }
                        if(strings[0].equals("3")){
                            double x=Double.parseDouble(strings[1]);
                            sendText+= Math.tan(x);

                        }
                        if(strings[0].equals("4")){
                            double x=Double.parseDouble(strings[1]);
                            double y=Double.parseDouble(strings[2]);
                            sendText+= Math.pow(x,1/y);
                        }
                        if(strings[0].equals("5")){
                            double x=Double.parseDouble(strings[1]);
                            double y=Double.parseDouble(strings[2]);
                            sendText+= Math.pow(x,y);
                        }
                        ByteBuffer buffer2=ByteBuffer.wrap(sendText.getBytes());
                        client.write(buffer2);
                        buffer2.clear();
//                        client.register(selector, SelectionKey.OP_WRITE);
//                        myKey.interestOps(SelectionKey.OP_WRITE);


                    }catch (IOException e){
                        System.err.println("Error writing back bytes");
//                        e.printStackTrace();
                        myKey.cancel();
                    }
                } else if (myKey.isWritable()){
                    log("WRITABLE");
                    SocketChannel client= (SocketChannel) myKey.channel();
                    String str="Hello";
                    ByteBuffer buffer=ByteBuffer.wrap(str.getBytes());
                    client.write(buffer);
                    buffer.clear();
                    myKey.interestOps(SelectionKey.OP_READ);
                }
                iterator.remove();
            }
        }
    }

    private static void log(String str) {
        System.out.println(str);
    }
}
