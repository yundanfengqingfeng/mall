package com.mall.demo.socket.talksocket;

import com.mall.demo.socket.twowaysocket.LogUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 超
 * Create by fengc on  2018/10/27 00:26
 */
public class Server {

    private final static int PORT = 8081;

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(PORT);
        LogUtils.println("服务端监听开始..........");
        while (true) {
            Socket client = server.accept();
            LogUtils.println("客户端连接上.................");
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            LogUtils.println(br.readLine());
            br.close();
        }

    }

}
