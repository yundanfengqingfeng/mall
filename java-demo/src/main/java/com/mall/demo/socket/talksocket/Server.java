package com.mall.demo.socket.talksocket;

import com.mall.demo.socket.twowaysocket.LogUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 超
 * Create by fengc on  2018/10/27 00:26
 */
public class Server {

    private final static int PORT = 8081;

    public static void main(String[] args) {

       ServerSocket server;
       BufferedReader reader;
       PrintWriter writer;

       try {
           server = new ServerSocket(PORT);
           Socket client = server.accept();
           writer = new PrintWriter(client.getOutputStream(),true);
           writer.println("客户端，你来了?");
           reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
           while (true) {
               String message = reader.readLine();
               System.out.println(message);
           }
       } catch (IOException ioe) {
           ioe.printStackTrace();
       }
    }

}
