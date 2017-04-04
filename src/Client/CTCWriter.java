package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client-To-Client Writer
 * Instanziert einen PrintWriter auf dem Outputstream, sowie einen Scanner, damit ein Client Nachrichten in String-form verschicken kann.
 *
 * Created by Robin Berberat 04.04.2017.
 */
public class CTCWriter extends Thread{
    Socket client;
    PrintWriter outToClient;
    Scanner scanner;
    String string;

    /**
     * Konstruktor
     *
     * @param client
     * @throws IOException
     */
    public CTCWriter(Socket client) throws IOException {
        this.client = client;
        outToClient = new PrintWriter(client.getOutputStream(),true);
        scanner = new Scanner(System.in);
    }

    /**
     * Solange die Verbindung besteht, wartet der Thread auf eine Kommandozeileneingabe.
     * Bei eingabe eines Textes, wird dieser an den anderen Client gesendet.
     *<p>
     * Sobald die Verbindung zusammenbricht, stribt der Thread.
     */
    public void run(){
        while(client.isConnected()){
            string = scanner.nextLine();
            outToClient.println(string);
        }
    }
}
