package classroom_day2;

import java.util.ArrayList;
import java.util.List;

public class Basics_List {
    public static void main(String[] args) {

        List<String> listOfStudents = new ArrayList<>();

        //to add elements to the list
        listOfStudents.add("Pinky");
        listOfStudents.add("John");
        listOfStudents.add("Rajiv");

        System.out.println("All the list of students--->" + listOfStudents);

        for (String student : listOfStudents) {
            System.out.println(student);
        }
        listOfStudents.add("Selva");
        listOfStudents.add("Rinu");
        listOfStudents.add(1, "Kumar");
        listOfStudents.add(2, "Kumar");
        listOfStudents.remove(4);
        System.out.println("Now updated list " + listOfStudents);


    }
}
