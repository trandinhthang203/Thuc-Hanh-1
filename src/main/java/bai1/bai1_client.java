/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package bai1;

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
public class bai1_client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2003);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.print("Enter input: ");
            Scanner scn = new Scanner(System.in);
            String input = scn.nextLine();
            dos.writeUTF(input);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            System.out.println("Chuoi dao nguoc: " + dis.readUTF());
            System.out.println("Chuoi chu hoa: " + dis.readUTF());
            System.out.println("Chuoi chu thuong: " + dis.readUTF());
            System.out.println("Chuoi vua hoa vua thuong: " + dis.readUTF());
            System.out.println("So tu trong chuoi: " + dis.readUTF());
            System.out.println("So nguyen am trong chuoi: " + dis.readUTF());

            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(bai1_client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
