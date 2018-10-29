package com.mall.demo.socket.me;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * @author 超
 * Create by fengc on  2018/10/24 23:18
 */
public class Client extends Thread{

    static Socket socket;
    static BufferedReader reader;
    static PrintWriter writer;

    public static void main(String[] args) throws IOException{

        new Client();

        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            if ("bye".equals(line)) {
                writer.close();
                reader.close();
                socket.close();
                break;
            }
            writer.println(line);
        }
    }
    public Client() {
        try {
            socket = new Socket("127.0.0.1",8081);
            System.out.println("连接成功........");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println("我登录过来了......");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        this.start();
    }

    @Override
    public void run() {
        String msg = "";
        while (true) {
            try {
                msg = reader.readLine();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            if (msg != null && !"".equals(msg.trim())) {
                System.out.println(msg);
            }
        }
    }
}
