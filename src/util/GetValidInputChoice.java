package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetValidInputChoice {
    private int intChoice = 0;
    private String stringChoice = "";


    public int getValidInt(Scanner scan) {
        try {
            intChoice = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice");
            scan.next();
        }
        return intChoice;
    }


    public String getValidString(Scanner scan) {
        try {
            stringChoice = scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice");
            scan.next();
        }
        return stringChoice;
    }

}
