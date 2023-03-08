package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {

    public static void main(String[] args) throws IOException {

        Server server = new Server();
        server.serverConnection();
    }
    private final int PORT_NUMBER = 8080;
    ArrayList<Socket> clientsList;
    public void serverConnection() throws IOException {

        System.out.println("## BINDING SERVER TO PORT NUMBER " + PORT_NUMBER);
        ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
        clientsList = new ArrayList<>();
        System.out.println("## BINDING SUCCESSFUL! WAITING FOR A CONNECTION ##");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            try {
                Thread thread = new Thread(new ServerHelper(clientSocket));
                thread.start();
                System.out.println("## NEW CLIENT CONNECTED ##");
                clientsList.add(clientSocket);
            } catch (Exception e) {
                clientsList.remove(clientSocket);
                System.out.println("## CLIENT DISCONNECTED ##");
            }
        }
    }

    public class ServerHelper implements Runnable {
        Socket socket;
        public ServerHelper(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try {
                while (true) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String message = in.readLine();
                    System.out.println(message);

                    for (int i = 0; i < clientsList.size(); i++) {

                        if (!clientsList.get(i).equals(socket)) {

                            PrintWriter out = new PrintWriter(clientsList.get(i).getOutputStream(), true);
                            out.println(message);
                        }
                    }
                }
            } catch (Exception e) {

                System.out.println("## CLIENT DISCONNECTED ##");
            }
        }
    }
}