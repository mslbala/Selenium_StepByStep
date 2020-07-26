package day1_decisionMaking;

import java.util.Scanner;

public class DecisionMaking_If_ElseIf {
    public static void main(String[] args) {
        System.out.println("Please enter a number");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        if (i < 30) {
            System.out.println("The amount is lesser than 30");
        }
        else if (i<50)
        {
            System.out.println("The amount is lesser than 50 but greater than 30");
        }
        else
        {
            System.out.println("The number is greater than 50");
        }
        System.out.println("I am always executed");

    }

}
