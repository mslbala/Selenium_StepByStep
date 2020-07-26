package day1_decisionMaking;

import java.util.Scanner;

public class DecisionMaking_NestedIf {
    public static void main(String[] args) {
        System.out.println("Please enter a number");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        if (i < 100) {
            if (i > 50)
                System.out.println("The amount is greater than 50 but lesser than 100");
        }

        System.out.println("I am always executed");

    }

}
