package Database;

import java.io.*;
import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) throws IOException{
        
        ArrayList<DataReader> data = new ArrayList<DataReader>();
        BufferedReader file = new BufferedReader(new FileReader("src/Database/DataSet.csv"));
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));      

        while(file.readLine() != null){
            String datalist[] = file.readLine().split(",");
            
            DataReader line = createData(datalist);
            data.add(line);

        }
        file.close();
        
        System.out.println("\nWelcome to the Stats Canada Labour Force Characteristics System");
        System.out.println("Please select one of the options below: ");
        System.out.println("\n(1) View Data Sorted by Province");
        System.out.println("(2) View Data Sorted by Labour Type");
        System.out.println("(3) View Data with Filters");
        System.out.println("(4) View an Individual Record by Month & Year");
        System.out.println("(5) View Summary Report");
        System.out.println("(6) View Charts");

        System.out.print("Input Choice: ");
        String strChoice = key.readLine();
    }

    private static DataReader createData(String[] datalist) { 
        String date;
        String province;
        String labour;
        String sex;
        String population; 

        date = datalist[0];
        province = datalist[1];
        labour = datalist[2];
        sex = datalist[3];
        population = datalist[4];
 
        // create and return book of this metadata return new 
        return new DataReader(date, province, labour, sex, population); 
    }
    

}


