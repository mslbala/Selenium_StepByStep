package day1_decisionMaking;

public class DecisionMaking_Return {

    //Return statement in the main method, the compiler halts and the program comes to an end.
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello");
            if (i < 6) return;
            System.out.println(i);
        }
    }
}

