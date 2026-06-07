package ex2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientApp {
    static void main(String[] args) throws Exception {
        final int portNumber = 8080;

        try (Socket socket = new Socket("192.168.20.246", portNumber);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println("1 2");
            int rezultat = Integer.parseInt(in.readLine().trim());
            System.out.println(rezultat);
        }
    }
}
