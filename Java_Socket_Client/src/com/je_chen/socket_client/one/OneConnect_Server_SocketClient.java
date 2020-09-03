package com.je_chen.socket_client.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class OneConnect_Server_SocketClient implements Runnable{

    private Socket OneClient_Socket;
    private PrintWriter Client_Output;
    private BufferedReader Client_Input;
    private String Socket_ID;
    private String Server_IP;
    private int Server_Port;
    private int Test_Time = 1000;

    public OneConnect_Server_SocketClient(String ID,String Server_IP,int Server_Port){
        this.Socket_ID = ID;
        this.Server_IP = Server_IP;
        this.Server_Port = Server_Port;
    }

    public void SetSocket() throws IOException {
        OneClient_Socket = new Socket(this.Server_IP,this.Server_Port);
        Client_Output = new PrintWriter(OneClient_Socket.getOutputStream(),true);
        Client_Input = new BufferedReader(new InputStreamReader(OneClient_Socket.getInputStream()));
    }

    public String SendMessage(String Message) throws IOException {
        Client_Output.println(Message);
        return Client_Input.readLine();
    }

    public void Disconnect() throws IOException {
        Client_Output.close();
        Client_Input.close();
        OneClient_Socket.close();
    }

    public void Set_Test_Time(int Time){
        this.Test_Time = Time;
    }



    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(Test_Time);
                this.SetSocket();
                this.SendMessage(this.Socket_ID);
                this.Disconnect();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
