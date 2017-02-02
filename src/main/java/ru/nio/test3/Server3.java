package ru.nio.test3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ILIA on 02.02.2017.
 */
public class Server3 {
    private static Selector sel;

    public static void main(String[] args) throws IOException {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress(1999));


            sel = Selector.open();
            channel.register(sel, SelectionKey.OP_ACCEPT);
            while (true) {
                if (sel.isOpen()) {
                    int keys = sel.select();
                    if (keys > 0) {
                        Set<SelectionKey> selectedKeys = sel.selectedKeys();
                        Iterator<SelectionKey> iterator = selectedKeys.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey sk = iterator.next();
                            if (sk.isValid() && sk.isAcceptable()) {
                                accept(sk);
                            }
                            if (sk.isValid() && sk.isReadable()) {
                                read(sk);
                            }
                            if (sk.isValid() && sk.isWritable()) {
                            }
                        }
                        selectedKeys.clear();
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    private static void read(SelectionKey key) {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buff = ByteBuffer.allocate(8192);
        File f = new File("file");
        try (FileChannel fileChannel = new FileOutputStream(f, true).getChannel()) {
            int read;
            int totalRead = 0;
            while ((read = channel.read(buff)) > 0) {
                System.out.println("current read: " + read);
                totalRead += read;
                buff.flip();
                fileChannel.write(buff);
                buff.clear();
            }
            System.out.println("total server read: " + totalRead);
        } catch (IOException ex) {
            try {
                ex.printStackTrace();
                key.cancel();
                channel.close();
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }


    private static void accept(SelectionKey key) {
        try {
            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            SocketChannel acceptedClient = channel.accept();
            acceptedClient.configureBlocking(false);
            acceptedClient.register(sel, SelectionKey.OP_READ);
            //sel.wakeup();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
