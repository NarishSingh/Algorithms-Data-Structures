package main.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class gradingStudents {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        //extract size and dump list to new list
        List<Integer> gradeList = new ArrayList<>(grades.get(0)); //first integer is # of students
        for (int i = 1; i < grades.size(); i++) {
            gradeList.add(grades.get(i));
        }

        //round
        List<Integer> rounded = gradeList.stream()
                .map(n -> {
                    if (n < 38) {
                        //failing grades aren't rounded
                    } else if ((5 - (n % 5)) < 3) {
                        n += 5 - (n % 5); //get the diff of 5 and the modulo to round it up
                    }

                    return n;
                })
                .collect(Collectors.toList());

        return rounded;
    }

    public static void main(String[] args) {
        List<Integer> grades = List.of(4, 73, 67, 38, 33); //note: HR starts from the grades, didn't need lines 11-14

        System.out.println(gradingStudents(grades));
    }
}
