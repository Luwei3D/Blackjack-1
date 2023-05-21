package com.DAM1.Blackjack.utils;
import java.util.Scanner;
import java.util.Random;
public class IO {
    public static Scanner lector = new Scanner(System.in);
    public static StringBuilder sb = new StringBuilder();
    public static Random random = new Random();
    /**
     * In this method we will request a message, which it outputs in screen<br>
     * This method return the final text
     * @param message (The message that would show)
     * @param minLengthStr (min length of the string)
     * @param maxLengthStr (max length of the string)
     * @return finalText (a String that the user introduces and is kept in a variable)
     */
    public static String readMessage(String message, int minLengthStr, int maxLengthStr) {
        boolean valid;
        String finalText = "";
        do {
            System.out.println(message);
            finalText = lector.nextLine();
            valid = finalText.length() > minLengthStr && finalText.length() < maxLengthStr;
        
            if (!valid) {
                System.out.printf("The string have to have got %d to %d letters", minLengthStr, maxLengthStr);
                pause("Vuleve a introducir el string");
            }
        } while (!valid);
        return finalText;
    }
    /**
     * In this method we will request a message, which it outputs in screen<br>
     * This method return the final text
     * @param message (The message that would show)
     * @param minLengthStr (min length of the string)
     * @return finalText (a String that the user introduces and is kept in a variable)
     */
    public static String readMessage(String message, int minLengthStr) {
        boolean valid;
        String finalText = "";
        do {
            System.out.println(message);
            finalText = lector.nextLine();
            valid = finalText.length() >= minLengthStr;
            if (!valid) {
                System.out.printf("The string have to have got %d letters", minLengthStr);
                pause("Vuleve a introducir el string");
            }
        } while (!valid);
        return finalText;
    }
    /**
     * In this method, we will request a message  which it outputs in screen<br>
     * This method return the final text
     * @param message
     * @param min (The minium of the number that the users introduces)
     * @param max (The max of the number that the users introduces)
     * @return finalNumber (The number that the user introduces, an int)
     */
    public static int readNumber(String message, int min, int max) {
        boolean valid;
        int finalNumber = 0;
        do {
            System.out.println(message);
            try {
                finalNumber = Integer.parseInt(lector.nextLine());
                valid = finalNumber >= min && finalNumber <= max;
            }catch(NumberFormatException nfe) {
                valid = false;
                pause("Only numbers");
            }
            if (!valid) {
                System.out.printf("The number have to have got a minium of %d and a max of %d numbers", min, max);
            }
        } while(!valid);
        return finalNumber;
    }
    /**
     * In this method, we will request a message without a max of nums which it outputs in screen<br>
     * This method return the final text
     * @param message
     * @param min (The minium of the number that the users introduces)
     * @return finalNumber (The number that the user introduces, an int)
     */
    public static int readNumber(String message, int min) {
        boolean valid;
        int finalNumber = 0;
        do {
            System.out.println(message);
            try {
                finalNumber = Integer.parseInt(lector.nextLine());
                valid = finalNumber >= min;
            }catch (NumberFormatException nfe) {
                valid = false;
                pause("Only numbers");
            }  
            if (!valid) {
                System.out.printf("The number have to have got a minium of %d", min);
            }
        } while(!valid);
        return finalNumber;
    }
    /**
     * In this method, we will request a message  which it outputs in screen<br>
     * This method return the final text
     * @param message
     * @param min
     * @param max
     * @return finalNumber (The number that the user introduces, a double)
     */
    public static double readDoubleNumber(String message, int min, int max) {
        boolean valid;
        double finalNumber = 0;
        do {
            System.out.println(message);
            try {
                finalNumber = lector.nextDouble();
                lector.nextLine();
                valid = finalNumber >= min && finalNumber <= max;
            }catch(NumberFormatException nfe) {
                valid = false;
                pause("Only numbers");
            }
            if (!valid) {
                System.out.printf("The double have to have got a minum of %d and a max of %d numbers", min, max);
            }
        } while(!valid);
        return finalNumber;
    }
    /**
     * In this method, we will request a message  which it outputs in screen<br>
     * This method return the final text
     * @param message
     * @param min
     * @return finalNumber (The number that the user introduces, a double)
     */
    public static double readDoubleNumber(String message, int min) {
        boolean valid;
        double finalNumber = 0;
        do {
            System.out.println(message);
            try {
                finalNumber = lector.nextDouble();
                lector.nextLine();
                valid = finalNumber >= min;
            }catch(NumberFormatException nfe) {
                valid = false;
                pause("Only numbers");
            }
            if (!valid) {
                System.out.printf("The double have to have got a minum of numbers", min);
            }
        } while(!valid);
        return finalNumber;
    }
    /**
     * In this method, we will request a message  which it outputs in screen<br>
     * This method return the final text
     * @param message
     * @param min
     * @param max
     * @return finalNumber (The number that the user introduces, a float)
     */
    public static double readFloatNumber(String message, int min, int max) {
        boolean valid;
        float finalNumber = 0;
        do {
            System.out.println(message);
            try {
                finalNumber = lector.nextFloat();
                lector.nextLine();
                valid = finalNumber >= min;
            }catch(NumberFormatException nfe) {
                valid = false;
                pause("Only numbers");
            }
            if (!valid) {
                System.out.printf("The float have to have got a minum of %d and a max of %d numbers", min, max);
            }
        } while(!valid);
        return finalNumber;
    }
    /**
     * In this method, we will request a message  which it outputs in screen<br>
     * This method return the final text
     * @param message
     * @param min
     * @return character (a char that the user introduces)
     */
    public static char readChar(String message, int min) {
        boolean valid;
        char character;
        do {
            System.out.println(message);
            character = lector.next().charAt(0);
            valid = character >= min;
            if (!valid) {
                System.out.printf("The char have to have got a minum of %d", min);
            }
        } while(!valid);
        return character;
    }
    private static void pause(String text) {
        System.out.println(text);
        System.out.println("Go INTRO to continue...");
        lector.nextLine();
    }
}
