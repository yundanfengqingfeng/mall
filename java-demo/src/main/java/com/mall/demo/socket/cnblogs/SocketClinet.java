package com.mall.demo.socket.cnblogs;

import javafx.print.Printer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-10-26 15:18.
 * 连接到服务器的客户端
 */
public class SocketClinet {

    public final static String SOCKET_IP = "127.0.0.1";
    public final static int SOCKET_PORT = 8089;

    public static void main(String[] args) throws IOException {

        Socket server = new Socket(SOCKET_IP,SOCKET_PORT);
        System.out.println("连接上了服务端，相信信息 server = " + server.toString());
        String message = "你好，服务器，我来了!";
        OutputStream os = server.getOutputStream();
        os.write(message.getBytes("utf-8"));
        os.flush();
        os.close();
        server.close();
    }

}
