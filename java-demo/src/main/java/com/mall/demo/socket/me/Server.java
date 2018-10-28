package com.mall.demo.socket.me;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 超
 * Create by fengc on  2018/10/24 23:18
 */
public class Server {

    public static void main(String[] args) throws IOException{

        ServerSocket server = new ServerSocket(8081);
        System.out.println("服务器监听开始了.......");
        while (true) {
            Socket client = server.accept();
            System.out.println("客户端已经连接上来了.......");
            new Thread(){
                @Override
                public void run () {
                    while (true) {
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                            String message = br.readLine();
                            System.out.println(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            }.start();
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            PrintWriter pw = new PrintWriter(client.getOutputStream(),true);
            pw.write(line);
        }

    }

}
