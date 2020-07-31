package com.example.springmybatisdemo.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo {
    private static void demo(){
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            for (int i = 0; i < 10; i++) {
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String s;
                while ((s = reader.readLine()) != null) {
                    System.out.println(s);
                }
                reader.close();
                inputStream.close();
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
