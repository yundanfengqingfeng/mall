package com.mall.demo.socket.ChatSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 超
 * Create by fengc on  2018/10/28 21:41
 */
public class Server extends Thread{

    public final static int PORT = 8081;
    ServerSocket server;
    BufferedReader br;
    PrintWriter pw;

    public static void main(String[] args){

        new Server().start();
    }

    @Override
    public void run(){

        while (true) {
            try {
                server = new ServerSocket(PORT);
                System.out.println("开始监听" + PORT + "端口......");
                server.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
