package com.example.project;

public class Test {
    public static void main(String[] args) {
        String encryptedMessage = " =?!yeaddiostt uuoo ye ceirna  ywroehv  oslil etHi";
        int rows = 2;
        String expectedDecrypted = "Hello how are you today? it is very nice outside!";
        String actualDecrypted = Encryptor.decryptMessage(encryptedMessage, rows);

        // NO EDIT
        System.out.println(expectedDecrypted + "\n" + actualDecrypted);
        // System.out.println(expectedColumns + " " + Encryptor.determineColumns(10, rows));
        // System.out.println(ans + "\n" + expected);
        // System.out.println(ans.equals(expected));
        // Encryptor.generateEncryptArray(message, rows);
    }
}
