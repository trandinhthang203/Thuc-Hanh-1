/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

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
public class bai2_server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2005);
            Socket socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String input = dis.readUTF();
            double result = evaluateExpression(input);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(Double.toString(result));

            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(bai2_server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static int evaluateExpression(String expression) {
        // Tách biểu thức thành các toán hạng và toán tử
        String[] tokens = expression.split(" ");

        // Duyệt các toán hạng và toán tử
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            // Nếu là toán hạng thì thêm vào stack
            if (!tokens[i].matches("[+-*/()]")) {
                result = Integer.parseInt(tokens[i]);
            } else {
                // Nếu là toán tử thì thực hiện phép tính
                int operand1 = result;
                result = 0;

                switch (tokens[i]) {
                    case "+":
                        result = operand1 + Integer.parseInt(tokens[i + 1]);
                        break;
                    case "-":
                        result = operand1 - Integer.parseInt(tokens[i + 1]);
                        break;
                    case "*":
                        result = operand1 * Integer.parseInt(tokens[i + 1]);
                        break;
                    case "/":
                        result = operand1 / Integer.parseInt(tokens[i + 1]);
                        break;
                }
            }
        }

        return result;
    }
}
