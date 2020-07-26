package classroom_day2;

import java.util.HashSet;

public class Basics_Set {
    public static void main(String[] args) {
        HashSet<String> students = new HashSet<>();
        students.add("Ram");
        students.add("Mala");
        students.add("Tina");
        students.add("Malar");
        students.add("Mala");
        System.out.println("Set of students--->" + students);

        int numberOfStudents = students.size();
        System.out.println("Number of students:"+numberOfStudents);

        students.remove("Tina");

        System.out.println("Set of updated studens---->"+students);

    }
}
