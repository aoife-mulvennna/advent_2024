import java.util.Scanner; 
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Stream;
import java.lang.Math;


class DayTwo {
        
    public static void main(String[] args) throws Exception {

		try {
            File file = new File("/Users/aoifem/advent_2024/dayTwo/dayTwoInput.txt");
            List<String> lines = Files.readAllLines(file.toPath());
            partOne(lines);

		} catch (IOException e) {
			e.printStackTrace();
        }

    }

    private static void partOne(List<String> lines){
       
        List<int[]> safeArrays = new ArrayList<int[]>();
            
        for (String line : lines) {
            int[] array = Arrays.stream(line.split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
            if (isSafe(array)) {
                safeArrays.add(array);
            } 
        }
        System.out.println("Part 1: Number of safe reports: " + safeArrays.size());
    }

    private static void partTwo(List<String> lines){
        List<int[]> safeArrays = new ArrayList<int[]>();
        List<int[]> unsafeArrays = new ArrayList<int[]>();   
        for (String line : lines) {
            int[] array = Arrays.stream(line.split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
            if (isSafe(array)) {
              safeArrays.add(array);
            } else {
              unsafeArrays.add(array);
            }
        }
        System.out.println("Part 2: Number of safe reports after removal: " + safeArrays.size());
    }

    private static boolean isSafe(int[] array){
        if (array.length < 2) return true;
        boolean increasing = array[1] > array[0];
        for (int i = 0; i < array.length - 1; i++){
            int diff = array[i + 1] - array[i];
            if (diff == 0 || Math.abs(diff) > 3) {
                return false; 
            }
            if ((increasing && diff < 0) || (!increasing && diff > 0)) {
                return false; // Breaks monotonicity
         }
        }
       return true;
    }

     private static boolean isSafeAfterRemoval(int[] array){

// Create a new array with one less element
int[] tempArray = new int[array.length - 1];
int j = 0;
for (int i = 0; i < array.length; i++) {
    if (i == removeIndex) continue; // Skip the item to remove
    tempArray[j++] = array[i];
}


       return true;
    }
}
