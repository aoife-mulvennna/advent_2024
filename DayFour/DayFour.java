import java.io.*;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.lang.Math;

class DayFour {

    public static void main(String[] args){
        // Read in the data 
        try {
            File input = new File("/Users/aoifem/advent_2024/DayFour/DayFourInput.txt");
            Scanner file = new Scanner(input);
            List<char[]> grid = new ArrayList<>();
            while(file.hasNextLine()){
                String line = file.nextLine();
                grid.add(line.toCharArray());
            }
            file.close();

            char[][] gridArray = grid.toArray(new char[0][]);

            String word = "XMAS";
            int occurrences = countWordOccurrences(gridArray, word);
             System.out.println("Part 1:" + occurrences);
        } catch (FileNotFoundException e) {
            e.printStackTrace(); 
        }
    }

    private static int countWordOccurrences(char[][] grid, String word){
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int len = word.length();

        int[][] directions = {
            {0, 1}, // right
            {0, -1}, // left
            {1, 0}, // down
            {-1, 0}, // up
            {1, 1},// diagonal down - right
            {-1, -1},// diagonal up - left
            {1, -1},// diagonal down - left
            {-1, 1}// diagonal up - right
        };

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                for (int[] direction : directions){
                    if (searchWord(grid, word, row, col, direction[0], direction[1])){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static boolean searchWord(char[][] grid, String word, int row, int col, int rowDir, int colDir){
        int len = word.length();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < len; i++){
            int newRow = row + i * rowDir;
            int newCol = col + i * colDir;

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || grid[newRow][newCol] != word.charAt(i)){
                return false;
            }
        }
        return true;
    }
}