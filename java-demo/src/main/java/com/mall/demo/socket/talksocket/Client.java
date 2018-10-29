package com.mall.demo.socket.talksocket;

import com.mall.demo.socket.twowaysocket.LogUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public static void main(String[] args) {

        Socket socket ;
        BufferedReader reader;
        PrintWriter writer;
        Scanner scanner;

        try {
            socket = new Socket(IP,PORT);
            scanner = new Scanner(System.in);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            writer = new PrintWriter(socket.getOutputStream(),true);
            while (true) {
                String message = scanner.nextLine();
                writer.println(message);
                System.out.println(message);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
