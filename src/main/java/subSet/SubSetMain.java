package subSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSetMain {
    public static void main(String[] args) {

        //int set[] = {1, 2, 3};
        int set[] = {3, 3, 9, 9, 5};
        printSubsets(set);
    }

    static void printSubsets(int set[]) {
        Set<Set<Integer>> mySet2 = new HashSet<>();
        List<Set<Integer>> myList = new ArrayList<>();

        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1 << n); i++) {
            Set<Integer> mySet = new HashSet<>();
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++) {

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0) {


                    System.out.print(set[j] + " ");
                    mySet.add(set[j]);

                }


            }
            System.out.println("}");
            mySet2.add(mySet);
        }

        System.out.println("list:"+myList);
        System.out.println(mySet2);
    }

}
