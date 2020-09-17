package com.je_chen.socket_server.Test;

import com.je_chen.socket_server.One.UDPOneClient_SocketServer;

import java.io.IOException;

public class UDPTest {

    public static void main(String[] argv){
        try {
            new UDPOneClient_SocketServer().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
