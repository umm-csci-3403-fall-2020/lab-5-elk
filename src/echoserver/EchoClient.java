package echoserver;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static final int portNumber = 6013;

    public static void main(String[] args) throws IOException {
        String server;
        if (args.length == 0) {
            server = "127.0.0.1";
        } else {
            server = args[0];
        }

        try {
            Socket socket = new Socket(server, portNumber);

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            int i;
            int k = System.in.read();
            while (k != -1) {
                output.write(k);
                i = input.read();
                System.out.print(i);
                k = System.in.read();
            }

            socket.close();
        } catch (ConnectException ce) {
            System.out.println("We were unable to connect to " + server);
            System.out.println("You should make sure the server is running.");
        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}