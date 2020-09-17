package com.je_chen.socket_server.One;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPOneClient_SocketServer implements Runnable{

    private boolean Running = true;
    private byte[] buffer = new byte[20];
    private DatagramSocket datagramSocket;

    public void setDatagramSocket(int port) throws SocketException {
        datagramSocket = new DatagramSocket(port);
    }

    @Override
    public void run() {
        while (Running) {
            try {
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);
            StringBuilder messageBuilder = new StringBuilder();
            for (int message = 0; message < buffer.length; message++) {
                messageBuilder.append(Character.toString(buffer[message]));
            }
            System.out.println(messageBuilder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
