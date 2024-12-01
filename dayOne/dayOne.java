import java.io.*;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.lang.Math;

class DayOne
{

    public static void main(String[] args) throws Exception
    {
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        Scanner s = new Scanner(new FileReader("/Users/aoifem/advent_2024/dayOne/dayOneInput.txt"));

        while (s.hasNext()) {
            left.add(s.nextInt());
            right.add(s.nextInt());
        }

        s.close();

        Collections.sort(left);
        Collections.sort(right);
        
        partOne(left, right);
        partTwo(left, right);
    }

    private static void partOne(List<Integer> left, List<Integer> right) {
        int totalDistance = 0;

        for (int i = 0; i < left.size(); i++){
            int tempDistance =  Math.abs(left.get(i) - right.get(i));
            totalDistance += tempDistance;
        }

        System.out.println("Part One = " + totalDistance);
    }

    private static void partTwo(List<Integer> left, List<Integer> right) {
        int simScore = 0;
        for (int i = 0; i < left.size(); i++){ 
            for (int j = 0; j < right.size(); j++){
                if (left.get(i).equals(right.get(j))){
                    simScore += left.get(i);
                }
            }
        }

        System.out.println("Part Two = " + simScore);
    }
};