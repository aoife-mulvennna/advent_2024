import java.io.*;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.lang.Math;

class DayThree {
    public static void main(String[] args) throws Exception{
     File file = new File("/Users/aoifem/advent_2024/DayThree/DayThreeInput.txt");
      Scanner reader = new Scanner(file);
      while (reader.hasNextLine()) {
        String data = reader.nextLine();
        System.out.println(data);
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        
}