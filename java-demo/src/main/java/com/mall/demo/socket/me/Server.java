package com.mall.demo.socket.me;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 超
 * Create by fengc on  2018/10/24 23:18
 */
public class Server {

    public static void main(String[] args) throws IOException{

        ServerSocket server = new ServerSocket(8080);
        System.out.println("向本机注册服务端口.......,详细信息是：" + server.toString());
        while (true) {
            Socket client = server.accept();
            System.out.println("客户端连接过来了，详细信息是：" + client.toString());
            InputStream in = client.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                sb.append(new String(bytes,0,len,"utf-8"));
            }
            System.out.println(client.getInetAddress() + " 说:" + sb.toString());
            Writer wr = new PrintWriter(client.getOutputStream());
            wr.write("客户端你过来了？嘿嘿......");
            wr.flush();
            wr.close();
        }
    }

}
