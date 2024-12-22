import java.io.*;
import java.util.*;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.lang.Math;

class DayFive {

    public static void main(String[] args){

        try {
            File input = new File("/Users/aoifem/advent_2024/DaySix/DaySixInput.txt");
            Scanner file = new Scanner(input);
            List<List<Character>> map = new ArrayList<>();

            while (file.hasNextLine()) {
            String line = file.nextLine();
            List<Character> row = new ArrayList<>();
            for (char c : line.toCharArray()) {
                row.add(c);
            }
            map.add(row);
            }
            file.close();

            int[][] directions = {
                {-1, 0}, // Up
                {0, 1},  // Right
                {1, 0},  // Down
                {0, -1}  // Left
            };
            char[] directionSymbols = {'^', '>', 'v', '<'};
        
            int guardRow = -1, guardCol = -1, direction = -1;
            outerLoop:
            for (int r = 0; r < map.size(); r++) {
                for (int c = 0; c < map.get(r).size(); c++) {
                    char cell = map.get(r).get(c);
                    for (int d = 0; d < directionSymbols.length; d++) {
                        if (cell == directionSymbols[d]) {
                        guardRow = r;
                        guardCol = c;
                        direction = d;
                        break outerLoop;
                        }
                    }
                }
            }

            Set<String> visited = new HashSet<>();
            visited.add(guardRow + "," + guardCol);
        
        // Simulate guard movement
            while (true) {
                int nextRow = guardRow + directions[direction][0];
                int nextCol = guardCol + directions[direction][1];
            
            // Check bounds
                if (nextRow < 0 || nextRow >= map.size() || nextCol < 0 || nextCol >= map.get(0).size()) {
                    break; // Guard leaves the map
                }
            
                char nextCell = map.get(nextRow).get(nextCol);
                if (nextCell == '#') {
                // Turn right
                    direction = (direction + 1) % 4;
                } else {
                // Move forward
                    guardRow = nextRow;
                    guardCol = nextCol;
                    visited.add(guardRow + "," + guardCol);
                }
            }
        
        // Output the number of distinct positions visited
            System.out.println("Distinct positions visited: " + visited.size());
            } catch (FileNotFoundException e) {
            e.printStackTrace(); 
            }
        }
    }