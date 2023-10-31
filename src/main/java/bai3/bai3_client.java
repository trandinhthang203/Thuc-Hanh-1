/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class bai3_client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2006);
            while (true) {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                
                System.out.print("Client: ");
                Scanner scn = new Scanner(System.in);
                String input = scn.nextLine();
                dos.writeUTF(input);

                String respone = dis.readUTF();
                System.out.print("Server: " + respone + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(bai3_client.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
