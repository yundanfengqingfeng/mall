package com.mall.demo.socket.me;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 超
 * Create by fengc on  2018/10/24 23:18
 */
public class Server extends Thread {

    ServerSocket server;
    List<Socket> sockets;

    public static void main(String[] args) {

        new Server().start();
    }

    @Override
    public void run() {

        try {
            server = new ServerSocket(8081);
            sockets = new ArrayList<>(16);
            System.out.println("服务器启动................");
            while (true) {
                System.out.println("开始等待客户连接....................");
                Socket clinet = server.accept();
                sockets.add(clinet);
                System.out.println("客户端连接成功.......");
                new ListenerMessage(clinet,sockets);
            }
        } catch (IOException ioe) {
            System.out.println("服务启动失败了.......");
            ioe.printStackTrace();
        }
    }
}

class ListenerMessage extends Thread {
    BufferedReader reader;
    PrintWriter writer;
    Socket socket;
    List<Socket> sockets;

    public ListenerMessage(Socket socket,List<Socket> sockets) {
        this.socket = socket;
        this.sockets = sockets;
        this.start();
    }

    @Override
    public void run() {
        String msg = "";
        while (true) {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                msg = reader.readLine();
                sendMsg(msg);
            } catch (IOException ioe) {
                ioe.printStackTrace();
                break;
            }
            if (msg != null && !"".equals(msg.trim())) {
                System.out.println(msg);
            }
        }
    }

    public synchronized void sendMsg (String ms) {
        try {
            for (int i = 0 ; i < sockets.size() ; i++) {
                writer = new PrintWriter(sockets.get(i).getOutputStream(),true);
                writer.println(ms);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}