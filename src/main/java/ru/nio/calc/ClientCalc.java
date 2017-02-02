package ru.nio.calc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ILIA on 02.02.2017.
 */
public class ClientCalc {
    public static boolean next=true;

    public static void main(String[] args) throws IOException, InterruptedException {

        SocketChannel socket=SocketChannel.open();
        InetSocketAddress addr = new InetSocketAddress("localhost", 1111);
        socket.configureBlocking(false);
        socket.connect(addr);

        Selector selector=Selector.open();

        socket.register(selector, SelectionKey.OP_CONNECT);

        log("Connecting to Server on port 1111...");

        Scanner scanner=new Scanner(System.in);
        String text;
        while (ClientCalc.next) {
            if (selector.isOpen()) {
                log("selector open");
                int keys = selector.select();
                log("Keys: "+keys);
                if (keys > 0) {
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    for (SelectionKey sk : selectedKeys) {
                        if (!sk.isValid()) {
                            break;
                        }
                        if (sk.isConnectable()) {
                            ClientCalc.accepting(sk,socket,selector);
                        }
                        if (sk.isWritable()) {
                            ClientCalc.write(sk);
                        }
                        if(sk.isReadable()){
                            ClientCalc.read(sk);
                        }
                    }
                }
            }
        }
    }

    /*Разница между ch.register(selector, SelectionKey.OP_READ) и sk.interestOps(SelectionKey.OP_READ), и с register происходит read*/
    private static void accepting(SelectionKey sk, SocketChannel ch, Selector selector) throws IOException, InterruptedException {
        System.out.println("ACCEPT");
        ch.finishConnect();
//        channel.register(selector, SelectionKey.OP_WRITE);
        ch.register(selector, SelectionKey.OP_WRITE);
//        sk.interestOps(SelectionKey.OP_READ);
    }

    private static void read(SelectionKey sk) throws IOException {
        log("READ");
        SocketChannel ch= (SocketChannel) sk.channel();
        ByteBuffer buffer = ByteBuffer.allocate(256);
        ch.read(buffer);
        String recv=new String(buffer.array()).trim();
        log("recv: "+recv);
        sk.interestOps(SelectionKey.OP_WRITE);
    }

    private static void write(SelectionKey sk) throws IOException {
        log("WRITE");
        SocketChannel ch = (SocketChannel) sk.channel();
        String text=menu();
        ByteBuffer buffer=ByteBuffer.wrap(text.getBytes());
        ch.write(buffer);
        buffer.clear();
        if(text.equals("exit")){
//            ch.close();
//            sk.selector().close();
            ClientCalc.next=false;
            return;
        }
        /*Нельзя сделать, SelectionKey не изменив своего состояния не перейдет на след. этерацию  sk.interestOps(SelectionKey.OP_WRITE);*/
        sk.interestOps(SelectionKey.OP_READ);

    }

    private static String menu(){
        Scanner scanner=new Scanner(System.in);
        log("Enter...");
        log("1 - sin(x)");
        log("2 - cos(x)");
        log("3 - tg(x)");
        log("4 - sqrt(x,y)");
        log("5 - pow(x,y)");
        log("==================");
        String text=scanner.next();
        log("query "+text);
        if(text.equals("1") || text.equals("2") || text.equals("3")){
            text+=";";
            log("x:");
            text+=scanner.next();
            log("send "+text);
            return text;
        }
        if(text.equals("4") || text.equals("5")){
            text+=";";
            log("x:");
            text+=scanner.next()+";";
            log("send "+text);
            log("y:");
            text+=scanner.next();
            log("send2 "+text);
            return text;
        }

        return "exit";
    }

    private static void log(String str) {
        System.out.println(str);
    }
}
