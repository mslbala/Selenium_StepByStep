package classroom_day2;

public class LearningClassAndMethods {

    public void methodA() {
        System.out.println("i am in method A");
    }

    public void methodB() {
        System.out.println("i am in method B");
    }


    public static void main(String[] args) {
        LearningClassAndMethods object = new LearningClassAndMethods();
        object.methodA();
        object.methodB();

    }
}
