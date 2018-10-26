package com.mall.demo.socket.twowaysocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-10-26 16:53.
 * 服务端
 */
public class Server {

    public static final int PORT = 8081;

    public static void main(String[] args) {
        try {
            initServer(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initServer(int port) throws IOException {

        ServerSocket server = new ServerSocket(port);
        LogUtils.println("服务端监听开始.....");
        while (true) {
            Socket client = server.accept();
            LogUtils.println("客户端连接上来了....,客户端详细是：" + client.toString());
            InputStream is = client.getInputStream();
            StringBuilder sb = new StringBuilder(16);
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = is.read(bytes)) != -1) {
                sb.append(new String(bytes,0,len,"utf-8"));
            }
            LogUtils.println(sb.toString());

            OutputStream os = client.getOutputStream();
            os.write("客户端，你已经连接过来了!".getBytes("utf-8"));
            os.flush();
            is.close();
            os.close();
            client.close();
        }
    }


}
