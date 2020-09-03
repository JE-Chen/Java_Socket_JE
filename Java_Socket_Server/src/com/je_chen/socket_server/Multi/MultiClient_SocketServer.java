package com.je_chen.socket_server.Multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClient_SocketServer {
    private ServerSocket ServerUseSocket;

    public void Start(int Port) throws IOException {
        ServerUseSocket = new ServerSocket(Port);
        while (true){
            Thread Handle = new Thread(new ClientSocketHandler(ServerUseSocket.accept()));
            Handle.start();
        }
    }

    public void Disconnect() throws IOException {
        ServerUseSocket.close();
    }

    private static class ClientSocketHandler implements Runnable{
        private Socket Client_Socket;
        private PrintWriter DataOutput;
        private BufferedReader DataInput;

        public ClientSocketHandler(Socket socket){
            this.Client_Socket = socket;
        }

        @Override
        public void run() {
            try {
                DataOutput = new PrintWriter(Client_Socket.getOutputStream(),true);
                DataInput = new BufferedReader(new InputStreamReader(Client_Socket.getInputStream()));
                String Input;
                while ((Input=DataInput.readLine())!=null){
                    if(Input.equals("Close")){
                        DataOutput.println("Close");
                        break;
                    }
                    DataOutput.println(Input);
                    System.out.println(Input);
                }
                DataOutput.close();
                DataInput.close();
                Client_Socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
