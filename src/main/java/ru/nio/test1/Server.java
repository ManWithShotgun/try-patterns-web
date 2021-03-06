package ru.nio.test1;

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
 * Created by ILIA on 01.02.2017.
 */
public class Server {
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
                    client.register(selector, SelectionKey.OP_WRITE);
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
                        String result = new String(buffer.array()).trim();
//                        String str="Hello";
//                        client.write(ByteBuffer.wrap(str.getBytes()));
                        log("received: " + result);
                        String str="Hello";
                        ByteBuffer buffer2=ByteBuffer.wrap(str.getBytes());
                        client.write(buffer2);
                        buffer2.clear();
//                        client.register(selector, SelectionKey.OP_WRITE);
//                        myKey.interestOps(SelectionKey.OP_WRITE);

                        if (result.equals("exit")) {
                            client.close();
                            log("recv exit");
                        }
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
