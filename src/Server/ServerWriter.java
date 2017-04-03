package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by User on 04.04.2017.
 */
public class ServerWriter {
    Socket client;
    PrintWriter outToClient;
    Scanner scanner;
    String string;


    ServerWriter(Socket client) throws IOException {
        this.client = client;
        outToClient = new PrintWriter(client.getOutputStream(),true);
        scanner = new Scanner(System.in);
    }

    public void defaultMessage(){
        string = scanner.nextLine();
        outToClient.println(string);
    }

    public void sayHello(){
        outToClient.println("Hallo");
    }
}
