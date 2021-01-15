package Database;

import java.io.*;
import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) throws IOException{

        //Get scanner instance
        Scanner scanner = new Scanner(new File("src/Database/Male.csv"));
        
        //Set the delimiter used in file
        scanner.useDelimiter(",");
        
        //Get all tokens and store them in some data structure
        //I am just printing them
        while (scanner.hasNext()) 
        {
            System.out.print(scanner.next() + "|");
        }
        
        scanner.close();
     } 
          
    

}
