package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Il client è partito");

        Socket mySocket = new Socket("localhost", 5637);
        System.out.println("Il client si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream())); //ascolto (ricevere)
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream()); //parla (invia)

        out.writeBytes("ciao" + "\n"); //invio al server della stringa
        String stringaRicevuta = in.readLine(); //in attessa della risposta dal server

        System.out.println("La stringa ricevuta: " + stringaRicevuta); //stringa ricevuta e stampata in maiuscolo

        mySocket.close(); //chiusura
    }
}