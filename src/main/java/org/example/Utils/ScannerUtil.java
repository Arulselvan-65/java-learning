package org.example.Utils;

import java.util.Scanner;

public class ScannerUtil {

    public static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        while(!scanner.hasNextInt()) {
            System.out.println("Enter a valid number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String readString() {
        while(!scanner.hasNextLine()) {
            System.out.println("Enter a valid string.");
            scanner.next();
        }
        return scanner.nextLine();
    }
}
