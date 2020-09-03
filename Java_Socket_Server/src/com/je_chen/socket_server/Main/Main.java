package com.je_chen.socket_server.Main;

import com.je_chen.socket_server.Multi.MultiClient_SocketServer;
import com.je_chen.socket_server.One.OnlyOne_Connect_SocketSever;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        MultiClient_SocketServer SocketServer = new MultiClient_SocketServer();
        try {
            SocketServer.Start(5555);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
