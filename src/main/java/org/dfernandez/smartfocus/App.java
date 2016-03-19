package org.dfernandez.smartfocus;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Tic Tac Toe Challenge!" );

        System.out.println("Who will start playing?");
        System.out.println("1) Computer");
        System.out.println("2) You");

        Scanner in = new Scanner(System.in);
        int entry;

        while (in.hasNextInt()) {
            entry = in.nextInt();

            switch (entry) {

                case 1:
                    System.out.println("\nComputer");
                    break;
                case 2:
                    System.out.println("\nHuman");
                    break;
                default:
                    System.out.println("\nHuman");
                    break;
            }

            System.out.println("Who will start playing?");
            System.out.println("1) Computer");
            System.out.println("2) You");
        }
    }
}
