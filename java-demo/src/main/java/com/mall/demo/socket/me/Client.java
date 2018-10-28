package com.mall.demo.socket.me;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * @author 超
 * Create by fengc on  2018/10/24 23:18
 */
public class Client {

    public static void main(String[] args) throws IOException {

        Socket server = new Socket("127.0.0.1",8081);
        System.out.println("已经连接上了服务器........");
        new Thread(){
            @Override
            public void run () {
                try {
                    PrintWriter pw = new PrintWriter(server.getOutputStream(),true);
                    Scanner sc = new Scanner(System.in);
                    String line = sc.nextLine();
                    pw.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
        String message = br.readLine();
        System.out.println(message);

    }

}
