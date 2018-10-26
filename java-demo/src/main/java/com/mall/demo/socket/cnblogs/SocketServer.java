package com.mall.demo.socket.cnblogs;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-10-26 15:18.
 *
 * 只能监听一个客户端的服务端............
 *
 */
public class SocketServer {

    public static final int SOCKET_PORT = 8089;

    public static void main(String[] args) throws IOException {

        //服务器端开启端口，监听服务
        ServerSocket server = new ServerSocket(SOCKET_PORT);
        System.out.println("服务端开始，等待客户端进行连接........server=【" + server.toString() + "】");
        Socket client = server.accept();
        System.out.println("客户端已经连接............client=【" + client.toString() + "】");
        InputStream is = client.getInputStream();
        byte[] bytes = new byte[1024];
        StringBuilder sb = new StringBuilder();
        int len = 0 ;
        while ((len = is.read(bytes)) != -1) {
            sb.append(new String(bytes,0,len,"utf-8"));
        }
        System.out.println("客户端说：" + sb.toString());
        is.close();
        client.close();
        server.close();
    }

}
