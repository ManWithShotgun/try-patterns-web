package ru.nio.test3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by ILIA on 02.02.2017.
 */
public class Client3 {
     static public void main(String[] args) throws IOException {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("localhost", 1999));

            Selector sel = Selector.open();
            channel.register(sel, SelectionKey.OP_CONNECT);
            while (true) {
                if (sel.isOpen()) {
                    int keys = sel.select();
                    if (keys > 0) {
                        Set<SelectionKey> selectedKeys = sel.selectedKeys();
                        for (SelectionKey sk : selectedKeys) {
                            if (!sk.isValid()) {
                                break;
                            }
                            if (sk.isConnectable()) {
                                System.out.println("accepting");
                                channel.finishConnect();
                                channel.register(sel, SelectionKey.OP_WRITE);
                                sk.interestOps(SelectionKey.OP_WRITE);
                            }
                            if (sk.isWritable()) {
                                SocketChannel ch = (SocketChannel) sk.channel();
                                System.out.println("writing");
                                String send="aasddsaadsqqqq";
                                ByteBuffer buffer = ByteBuffer.wrap(send.getBytes());
                                System.out.println("wrote " + send);
                                ch.write(buffer);
                                buffer.clear();
                                //sk.interestOps(SelectionKey.OP_READ);
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
