package day1_decisionMaking;

import java.util.Scanner;

public class DecisionMaking_Switch {
    public static void main(String[] args) {
        System.out.println("Please enter your browser name");
        Scanner scanner = new Scanner(System.in);
        String browserType = scanner.next();

        switch (browserType) {
            case "chrome":
                System.out.println("Please download chromedriver");
                break;
            case "firefox":
                System.out.println("Please download geckodriver");
                break;
            case "ie":
                System.out.println("Please download IEdriver server");
                break;
            default:
                System.out.println("Please enter a valid browser name which can be automated");


        }

    }}
