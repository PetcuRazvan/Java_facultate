package ex1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    static void main(String[] args) throws Exception {
        final int portNumber = 6767;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                System.out.println("[SERVER] serverul e gata sa primeasca un request");
                try (Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
                ) {
                    String mesaj = in.readLine();
                    System.out.println("[SERVER] am primit mesaj de la client");

                    out.println(mesaj.toUpperCase());
                }
            }
        }
    }
}
