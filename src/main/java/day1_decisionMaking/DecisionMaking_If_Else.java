package day1_decisionMaking;

import java.util.Scanner;

public class DecisionMaking_If_Else {
    public static void main(String[] args) {
        System.out.println("Please enter a number");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        if (i < 5000) {
            System.out.println("The amount is lesser than 5000");
        }
        else
        {
            System.out.println("The amount is greater than 5000");
        }
        System.out.println("I am always executed");

    }

}
