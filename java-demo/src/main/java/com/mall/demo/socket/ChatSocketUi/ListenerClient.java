package com.mall.demo.socket.ChatSocketUi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author 超
 * Create by fengc on  2018/10/28 21:23
 */
public class ListenerClient extends Thread {

    BufferedReader reader;
    PrintWriter writer;
    ServerUI ui;
    Socket client;

    public ListenerClient(ServerUI ui, Socket client) {
        System.out.println("当前线程....." + Thread.currentThread().getName());
        this.ui = ui;
        this.client=client;
        this.start();
    }

    //为每一个客户端创建线程等待接收信息，然后把信息广播出去
    @Override
    public void run() {
        String msg = "";
        while (true) {
            try {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                msg = reader.readLine();
                System.out.println("阻塞前一句......");
                sendMsg(msg);
            } catch (IOException e) {
                println(e.toString());
                break;
            }
            if (msg != null && msg.trim() != "") {
                println("客户端 " + msg);
            }
        }
    }

    //把信息广播到所有用户
    public synchronized void sendMsg(String msg) {
        System.out.println("..............................................");
        try {
            for (int i = 0; i < ServerUI.clients.size(); i++) {
                Socket client = ServerUI.clients.get(i);
                writer = new PrintWriter(client.getOutputStream(), true);
                writer.println(msg);
            }
        } catch (Exception e) {
            println(e.toString());
        }
    }

    public void println(String s) {
        if (s != null) {
            this.ui.taShow.setText(this.ui.taShow.getText() + s + "\n");
            System.out.println(s + "\n");
        }
    }

}
