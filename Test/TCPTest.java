package com.je_chen.socket_server.Test;

import com.je_chen.socket_server.Multi.TCPMultiClient_SocketServer;

import java.io.IOException;

public class TCPTest {

    public static void main(String[] args) {
        TCPMultiClient_SocketServer SocketServer = new TCPMultiClient_SocketServer();
        try {
            SocketServer.Start(5555);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
