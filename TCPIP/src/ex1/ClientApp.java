package ex1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientApp {
    static void main(String[] args) throws Exception {
        final int portNumber = 6767;

        try (Socket socket = new Socket("192.168.20.246", portNumber); //adresa ip al calculatorului meu din retea (ipconfig in consola si ia adresa de la IPV4)
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             ) {

            out.println("ceva scris mic");
            System.out.println("[CLIENT] am trimis mesajul");

            String resultat = in.readLine();
            System.out.println("[CLIENT] am primit resultatul: " + resultat);
        }
    }
}
