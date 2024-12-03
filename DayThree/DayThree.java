import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.lang.Math;

class DayThree {
    public static void main(String[] args) throws Exception {
        try {
            File file = new File("/Users/aoifem/advent_2024/DayThree/DayThreeInput.txt");
            Scanner reader = new Scanner(file);
            int total = 0;
            while (reader.hasNextLine()) {
                String data = reader.nextLine();

                String regex = "mul\\(";

                String[] myArray = data.split(regex);

                for (String rawLine: myArray) {
                    String closeBrRegex = "\\)";
                    String[] arrayTwo = rawLine.split(closeBrRegex, 2);
                    String numberLine = arrayTwo[0];
                    String[] arrayThree = numberLine.split(",");
                    if (arrayThree.length == 2 && arrayThree[1].matches("^-?\\d+$")) {
                        total += Integer.parseInt(arrayThree[0]) * Integer.parseInt(arrayThree[1]);
                    }
                }

            }
            reader.close();
            System.out.println(total);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}