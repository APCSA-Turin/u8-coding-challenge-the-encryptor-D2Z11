package com.example.project;

import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {

    public static int determineColumns(int messageLen, int rows) {
        if (messageLen == 0) {
            return 1;
        }
        if (messageLen % rows == 0) {
            return messageLen / rows;
        }
        return (int) ((double) messageLen / rows) + 1;
    }

    public static String[][] generateEncryptArray(String message, int rows) {
        int columns = determineColumns(message.length(), rows);
        System.out.println(columns);
        String[][] arr = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Should be rows-1 because index starts at zero
                int c = i * (columns) + j;
                if (c >= message.length()) {
                    arr[i][j] = "=";
                    continue;
                }
                System.out.println(i + "*" + (columns) + "+" + j + " " + message.substring(c, c + 1));
                arr[i][j] = message.substring(c, c + 1);
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        return arr;
    }

    public static String encryptMessage(String message, int rows) {
        String[][] g = generateEncryptArray(message, rows);
        String m = "";
        // For each column, go to all rows and get that column
        for (int col = g[0].length - 1; col >= 0; col--) {
            for (int row = 0; row < g.length; row++) {
                m += g[row][col];
            }
        }
        return m;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        // Determine columns using determineColumns()
        int columns = determineColumns(encryptedMessage.length(), rows);
    
        // Create string array with rows and columns
        String[][] arr = new String[rows][columns];
    
        // Index to track position
        int index = 0;
    
        // Loop from first to last character of message
        for (int col = columns - 1; col >= 0; col--) {
            for (int row = 0; row < rows; row++) {
                if (index < encryptedMessage.length()) {
                    arr[row][col] = encryptedMessage.substring(index, index + 1);
                    index++;
                } else {
                    arr[row][col] = "=";
                }
            }
        }
    
        String msg = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.println(arr[row][col]);
                if (arr[row][col].equals("=")) {
                    break;
                }
                msg += arr[row][col];
            }
        }
    
        return msg;
    }
}