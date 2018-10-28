package com.mall.demo.socket.talksocket;

import com.mall.demo.socket.twowaysocket.LogUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 超
 * Create by fengc on  2018/10/27 00:26
 */
public class Client {

    public static final String IP = "127.0.0.1";
    public static final int PORT = 8081;
    public static final String END = "end";

    public static void main(String[] args) throws IOException {

        Socket server = new Socket(IP,PORT);
        LogUtils.println("客户端连接上服务端了......");
        PrintWriter writer = new PrintWriter(server.getOutputStream()) ;

        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        if (!END.equals(message)) {
            writer.println(message);
            writer.flush();
            LogUtils.println("向服务器输入 ：" + message);
            message = sc.nextLine();
            LogUtils.println("下一行是 ：" + message);
        }
        sc.close();
        writer.close();
        server.close();

    }

}
