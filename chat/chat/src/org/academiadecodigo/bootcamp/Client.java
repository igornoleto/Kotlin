package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private final int PORT_NUMBER = 8080;
    boolean isConnected = false;
    String message;
    String hostName = "localhost";
    BufferedReader in;
    PrintWriter out;
    Socket clientSocket;
    String name = "";

    public static void main(String[] args) {

        Client client = new Client("Igor");
    }

    public Client(String name) {
        this.name = name;
        init();
    }

    public void init() {
        try {

            System.out.println("## ATTEMPTING TO CONNECT TO " + hostName + ":" + PORT_NUMBER + " ##");

            clientSocket = new Socket(hostName, PORT_NUMBER);

            System.out.println("## " + name + " IS ONLINE ##");

// CONNECTION SUCCESSFUL

            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            //  Scanner terminal = new Scanner(System.in);

            System.out.println("## TYPE TYPE TYPE ##");

            ClientHelper clientHelper = new ClientHelper();
            Thread thread = new Thread(clientHelper);
            thread.start();

            while (isConnected = true) {

                message = in.readLine();
                out.println(name + ": " + message);
                System.out.println("✓");
            }
            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public class ClientHelper implements Runnable {

        @Override
        public void run() {
            try {
                String message;
                BufferedReader inHelper = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                while (true) {

                    message = inHelper.readLine();
                    System.out.println(message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}











