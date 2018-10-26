package com.mall.demo.socket.me;

import java.io.*;
import java.net.Socket;

/**
 * @author 超
 * Create by fengc on  2018/10/24 23:18
 */
public class Client {

    public static void main(String[] args) throws IOException {

        Socket server =new Socket("127.0.0.1",8080);
        System.out.println("连接上服务端，服务端的详细信息是：" + server.toString());
        Writer wr = new PrintWriter(server.getOutputStream());
        wr.write("服务器，我来了，嘿嘿......");
        wr.flush();
        server.shutdownOutput();
        InputStream in = server.getInputStream();
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[1024];
        int len = 0 ;
        while ((len = in.read(bytes)) != -1) {
            sb.append(new String(bytes,0,len,"utf-8"));
        }
        System.out.println("服务器端说:" + sb.toString());
        wr.close();
    }

}
