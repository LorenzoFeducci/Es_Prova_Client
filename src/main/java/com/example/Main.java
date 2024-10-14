package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Il client è partito");
        Scanner scanner = new Scanner(System.in);

        Socket mySocket = new Socket("localhost", 5637);
        System.out.println("Il client si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream())); // ascolto (ricevere)
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream()); // parla (invia)
        do {
            System.out.println("inserisci una stringa");
            String stringa = scanner.nextLine();//acquisizione stringa da tastiera
            if(stringa.equals("exit")){
                System.out.println("Sto chiudendo");
                out.writeBytes("!" + "\n");
                mySocket.close(); // chiusura
                break;
            }
            out.writeBytes(stringa + "\n"); // invio al server della stringa
            String stringaRicevuta = in.readLine(); // in attessa della risposta dal server

            System.out.println("La stringa ricevuta: " + stringaRicevuta); // stringa ricevuta e stampata in maiuscolo
        } while (true);
    }
}