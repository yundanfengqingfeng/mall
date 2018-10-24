package com.mall.demo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 超
 * Create by fengc on  2018/10/24 23:18
 */
public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(8080);

        System.out.println("SocketServer 服务端启动.............");
        while (true) {
            System.out.println("等待客户连接..................");
            Socket clinet = socket.accept();
            //可防止在发送的时候黏包
            clinet.setTcpNoDelay(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(clinet.getInputStream()));
            System.out.println("客户连接成功.....,详细信息是：" + clinet.toString());
        }


    }

}
