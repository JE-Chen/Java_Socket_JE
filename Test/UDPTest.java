package com.je_chen.socket_server.Test;

import com.je_chen.socket_server.One.UDPOneClient_SocketServer;

import java.io.IOException;
import java.net.SocketException;

public class UDPTest {

    public static void main(String[] argv){

        UDPOneClient_SocketServer udpOneClient_socketServer = new UDPOneClient_SocketServer();

        try {
            udpOneClient_socketServer.setDatagramSocket(5555);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        new Thread(udpOneClient_socketServer).start();
    }
}
