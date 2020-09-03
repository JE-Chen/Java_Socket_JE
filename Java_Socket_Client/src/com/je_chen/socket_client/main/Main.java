package com.je_chen.socket_client.main;

import com.je_chen.socket_client.one.OneConnect_Server_SocketClient;

import java.io.IOException;

public class Main {

    public static void main(String[] args){

        OneConnect_Server_SocketClient Client1 = new OneConnect_Server_SocketClient("Socket1","127.0.0.1",5555);
        OneConnect_Server_SocketClient Client2 = new OneConnect_Server_SocketClient("Socket2","127.0.0.1",5555);
        Client1.Set_Test_Time(1500);
        Client2.Set_Test_Time(3000);
        Thread Test1 = new Thread(Client1);
        Thread Test2 = new Thread(Client2);
        Test1.start();
        Test2.start();
    }
}
