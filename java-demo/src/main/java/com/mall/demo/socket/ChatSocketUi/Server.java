package com.mall.demo.socket.ChatSocketUi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author 超
 * Create by fengc on  2018/10/28 20:49
 */
public class Server extends Thread {

    ServerUI ui;
    ServerSocket ss;
    BufferedReader reader;
    PrintWriter writer;

    public Server(ServerUI ui) {
        this.ui = ui;
        this.start();
    }

    @Override
    public void run() {
        try {
            ss = new ServerSocket(8081);
            ServerUI.clients=new ArrayList<>();
            println("启动服务器成功：端口8081");
            while (true) {
                println("等待客户端链接.......................................");
                Socket client = ss.accept();
                ServerUI.clients.add(client);
                println("连接成功，客户端请求服务端的详细信息：" + client.toString());
                new ListenerClient(ui, client);
            }
        } catch (IOException e) {
            println("启动服务器失败：端口8081");
            println(e.toString());
            e.printStackTrace();
        }
    }

    public synchronized void sendMsg(String msg) {
        try {
            for (int i = 0; i < ServerUI.clients.size(); i++) {
                Socket client = ServerUI.clients.get(i);
                writer = new PrintWriter(client.getOutputStream(), true);
                System.out.println("writer :" + writer);
                writer.println(msg);
            }
        } catch (Exception e) {
            println(e.toString());
        }
    }

    public void println(String s) {
        if (s != null) {
            s = "服务端打印消息：" + s;
            this.ui.taShow.setText(this.ui.taShow.getText() + s + "\n");
            System.out.println(s + "\n");
        }
    }

    public void closeServer() {
        try {
            if (ss != null)
                ss.close();
            if (reader != null)
                reader.close();
            if (writer != null)
                writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
