/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class bai3_server {

    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(2006);
            Socket socket = server.accept();
            while (true) {
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                
                String input = dis.readUTF();
                System.out.println("Client: " + input);

                System.out.print("Server: ");
                Scanner scn = new Scanner(System.in);
                String respone = scn.nextLine();
                dos.writeUTF(respone);

            }
        } catch (IOException ex) {
            Logger.getLogger(bai3_server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
