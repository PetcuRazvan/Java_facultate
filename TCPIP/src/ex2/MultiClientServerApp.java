package ex2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClientServerApp {
    static void main(String[] args) throws Exception {
        final int portNumber = 8080;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("[SERVER] am primit request");

                Thread thread = new Thread(() -> {
                    service(socket);
                });
                thread.start();
            }
        }
    }

    static void service(Socket socket)  {
        try {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                String linie = in.readLine();
                System.out.println("[SERVER] am primit mesajul");

                String[] numere = linie.split(" ");

                int nr1 = Integer.parseInt(numere[0].trim());
                int nr2 = Integer.parseInt(numere[1].trim());

                int result = nr1 + nr2;

                out.println(result);
                System.out.println("[SERVER] a plecat");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
