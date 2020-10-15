package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int portNumber = 6013;

    public static void main(String[] args) {
        try{
            ServerSocket sock = new ServerSocket(portNumber);

            while (true) {
                Socket client = sock.accept();
                System.out.println("Got a request!");

                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();

                int i = input.read();

                while (i != -1) {
                    output.write(i);
                    i = input.read();
                }

                output.flush();
                client.close();
            }

        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}