package com.gowri_manikandan.Z_Kart.utils;

import java.util.Scanner;

public class ConsoleUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayHeader(String title) {
        System.out.println("======================== " + title.toUpperCase() + " ========================");
    }

    public static void displaySeparator()
    {
        System.out.println("================================================================");
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayError(String error) {
        System.out.println("ERROR: " + error);
    }

    public static void displaySuccess(String success) {
        System.out.println("SUCCESS: " + success);
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                displayError("Invalid number. Please try again.");
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                displayError("Invalid number. Please try again.");
            }
        }
    }

    public static long readLong(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Long.parseLong(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                displayError("Invalid number. Please try again.");
            }
        }
    }

    public static void clearScreen() {
        // Simple way to clear console
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }
}