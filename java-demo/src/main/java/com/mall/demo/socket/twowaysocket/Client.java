package com.mall.demo.socket.twowaysocket;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-10-26 16:53.
 */
public class Client {

    public final static String IP = "127.0.0.1";
    public final static int PORT = 8081;
    public static void main(String[] args) {
        try{
            initClient(IP,PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void initClient(String ip,int port) throws IOException {

        Socket socket = new Socket(ip,port);
        LogUtils.println("连接到了服务器，详细信息是：" + socket.toString());

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        OutputStream os = socket.getOutputStream();

        while (true) {
            String message = bf.readLine();
            if (null != message && !"".equals(message)) {
                os.write(message.getBytes("utf-8"));
                os.flush();
            }
        }


    }

}