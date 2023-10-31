/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class bai1_server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2003);
            Socket socket = server.accept();
            System.out.println("Server is ready...");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String text = dis.readUTF();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // dao nguoc 
            StringBuilder reversedString = new StringBuilder(text).reverse();
            String result = reversedString.toString();
            dos.writeUTF(result);

            // chuyen thanh chu hoa
            String uppercaseString = text.toUpperCase();
            dos.writeUTF(uppercaseString);

            // chuyen thanh chu thuong
            String lowercaseString = text.toLowerCase();
            dos.writeUTF(lowercaseString);

            // vua hoa vua thuong
            char[] mixedCaseChars = text.toCharArray();
            for (int i = 0; i < mixedCaseChars.length; i++) {
                if (i % 2 == 0) {
                    mixedCaseChars[i] = Character.toUpperCase(mixedCaseChars[i]);
                } else {
                    mixedCaseChars[i] = Character.toLowerCase(mixedCaseChars[i]);
                }
            }
            String mixedCaseString = new String(mixedCaseChars);
            dos.writeUTF(mixedCaseString);

            // dem so tu
            String[] words = text.split("\\s+"); // Tách chuỗi thành mảng các từ bằng khoảng trắng
            int wordCount = words.length;
            dos.writeUTF(Integer.toString(wordCount));

            // dem so nguyen am
            int vowelCount = 0;
            for (int i = 0; i < text.length(); i++) {
                char ch = Character.toLowerCase(text.charAt(i));
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                }
            }
            dos.writeUTF(Integer.toString(vowelCount));

            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(bai1_server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
