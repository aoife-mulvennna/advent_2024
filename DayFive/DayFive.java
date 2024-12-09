import java.io.*;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.lang.Math;

class DayFive {

    public static void main(String[] args){

        try {
            File input = new File("/Users/aoifem/advent_2024/DayFive/DayFiveInput.txt");
            Scanner file = new Scanner(input);

            List <int[]> rules = new ArrayList<>();
            List <List<Integer>> updates = new ArrayList<>();

            boolean foundEmptyLine = false;
            while(file.hasNextLine()){
                String line = file.nextLine().trim();

                if (line.isEmpty()){
                    foundEmptyLine = true;
                } else if (!foundEmptyLine){
                    String[] parts = line.split("\\|");
                    
                    rules.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
                } else {
                    List<Integer> update = new ArrayList<>();
                    for (String num :line.split(",")){
                        update.add(Integer.parseInt(num));
                    }
                    updates.add(update);
                }
            }
            file.close();

            int sumOfMiddlePages = 0;
            for (List<Integer> update : updates){
                if (isValidUpdate(update, rules)){
                    int middleIndex = update.size() / 2;
                    sumOfMiddlePages+= update.get(middleIndex);
                }
            }
             System.out.println("Part 1: " + sumOfMiddlePages);
        } catch (FileNotFoundException e) {
            e.printStackTrace(); 
        }
    }

      /**
     * Checks if a given update is valid based on the provided rules.
     * @param update A list of integers representing the pages in the update.
     * @param rules A list of rules, where each rule is an int array [X, Y] (X must come before Y).
     * @return true if the update is valid, false otherwise.
     */
    private static boolean isValidUpdate(List<Integer> update, List<int[]> rules){
        for(int[] rule : rules){
            int x = rule[0];
            int y = rule[1];

            int indexX = update.indexOf(x);
            int indexY = update.indexOf(y);

            if (indexX != -1 && indexY != -1) {
                if (indexX > indexY){
                    return false;
                }
            }
        }
        return true;
    }
}