package com.je_chen.socket_server.One;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPOneClient_SocketServer {

    public void run() throws IOException {
        byte[] buffer = new byte[20];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 20);
        DatagramSocket datagramSocket = new DatagramSocket(5555);
        datagramSocket.receive(datagramPacket);
        StringBuilder messageBuilder = new StringBuilder();
        for(int message =0 ; message < buffer.length ; message++){
            messageBuilder.append(Character.toString(buffer[message]));
        }
        System.out.println(messageBuilder);
    }
}
