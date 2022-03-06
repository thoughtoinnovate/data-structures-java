package org.datastructures.arrays.challenges;

import java.util.*;
import java.util.stream.Collectors;

public class OverLappingArrays {

    /**
     * BruteForce
     * Problem : Merge Overlapping Intervals
     * Intervals: [[1,4], [2,5], [7,9]]
     * [[1,4], [2,5], [3,9],[1,10]==> [1,10]
     * Output: [[1,5], [7,9]]
     */
    public static List<List<Integer>> mergeOverlappingIntervals(List<List<Integer>> input) {


        List<List<Integer>> nonOverlapping = new ArrayList<>();
        //Integer lowerBound = 0;
        //Integer upperBound = 0;
        HashSet<String> traversedSet = new HashSet<>();

        for (int i = 0; i < input.size(); i++) {

            Integer lowerBound = input.get(i).get(0);
            Integer upperBound = input.get(i).get(1);

            String concat = String.valueOf(lowerBound).concat(String.valueOf(upperBound));

            if (traversedSet.contains(concat)) {
                continue;
            }

            traversedSet.add(concat);

            for (int j = i + 1; j < input.size(); j++) {

                String first = String.valueOf(input.get(j).get(0));
                String second = String.valueOf(input.get(j).get(1));

                String key = first.concat(second);

                if (traversedSet.contains(key)) {
                    continue;
                }

                if (input.get(j).get(0) > upperBound) {
                    continue;
                }
                traversedSet.add(key);
                if (lowerBound > input.get(j).get(0)) {
                    lowerBound = input.get(j).get(0);
                }
                if (upperBound < input.get(j).get(1)) {
                    upperBound = input.get(j).get(1);
                }


            }
            nonOverlapping.add(Arrays.asList(lowerBound, upperBound));


        }

        return nonOverlapping;

    }

    /**
     * Optimised Solution
     * (N)
     * @return
     */
    public static List<List<Integer>> mergeOverlaps(List<List<Integer>> input) {

        //Sort the Overlaps
        List<List<Integer>> sortedList = input.stream().sorted(Comparator.comparing(l -> l.get(0))).collect(Collectors.toList());

        Stack<List<Integer>> intervalStack = new Stack<>();
        intervalStack.push(sortedList.get(0));

        for (int i = 1; i < input.size(); i++) {
            List<Integer> peek = intervalStack.peek();
            if (peek.get(1) >= sortedList.get(i).get(0)) {
                peek.set(1, sortedList.get(i).get(1));
            } else {
                intervalStack.push(sortedList.get(i));
            }
        }

        return intervalStack.stream().toList();
    }

    public static void main(String[] args) {

        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(5);

        List<Integer> two = new ArrayList<>();
        two.add(5);
        two.add(10);

        List<Integer> three = new ArrayList<>();
        three.add(8);
        three.add(19);

        List<List<Integer>> input = Arrays.asList(one, two, three);
        System.out.println(OverLappingArrays.mergeOverlappingIntervals(input));

        System.out.println(OverLappingArrays.mergeOverlaps(input));
    }

}
