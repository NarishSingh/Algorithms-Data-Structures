package main.hackerrank;

import java.util.List;

public class subarrayDiv {

    /**
     * Find the number of subarrays from the labeled chocolate given the following conditions
     *
     * @param s List of integers on the chocolate squares
     * @param d day of bday = required sum of subarray
     * @param m month of bday = length of subarray
     * @return number of subarrays/segments of the bar
     */
    public static int birthdayChocolate(List<Integer> s, int d, int m) {
        //edge, if only 1 segment check if it equals the sum, if not, it will return 0
        if (s.size() == 1 && s.get(0) == d) {
            return 1;
        }

        int subCt = 0;

        //upper limit must be .size()-m to stop index out of bounds
        for (int i = 0; i < s.size() - m; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += s.get(j);

                if (sum == d) {
                    subCt++;
                }
            }
        }

        return subCt;
    }

    public static void main(String[] args) {
        List<Integer> choc1 = List.of(2, 2, 1, 3, 2);
        List<Integer> choc2 = List.of(1, 2, 1, 3, 2);
        List<Integer> choc3 = List.of(1, 1, 1, 1, 1, 1);
        List<Integer> choc4 = List.of(4);
        List<Integer> choc5 = List.of(2, 2, 2, 1, 3, 2, 2, 3, 3, 1, 4, 1, 3, 2, 2, 1, 2, 2, 4, 2, 2, 3, 5, 3, 4, 3, 2, 1, 4, 5, 4);

        System.out.println(birthdayChocolate(choc1, 4, 2));
        System.out.println(birthdayChocolate(choc2, 3, 2));
        System.out.println(birthdayChocolate(choc3, 3, 2));
        System.out.println(birthdayChocolate(choc4, 4, 1));
        System.out.println(birthdayChocolate(choc5, 10, 4)); // FIXME: 5/21/2021 expected 7 , getting 9
    }
}
