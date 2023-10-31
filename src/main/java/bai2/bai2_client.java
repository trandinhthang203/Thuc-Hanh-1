/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

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
public class bai2_client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2005);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.print("Enter input: ");
            Scanner scn = new Scanner(System.in);
            String input = scn.nextLine();
            dos.writeUTF(input);
            
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String result = dis.readUTF();
            System.out.println("Ket qua: " + result);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(bai2_client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
