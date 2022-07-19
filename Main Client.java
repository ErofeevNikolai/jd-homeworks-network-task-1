package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8088;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Соединение выполнено успешно");

            String resp = in.readLine();
            System.out.println(resp);

            InetAddress inetAddress = InetAddress.getByName(host);
            System.out.println(host + ", ip address: " + inetAddress.getHostAddress());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}