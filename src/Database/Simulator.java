package Database;

import java.io.*;
import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) throws IOException{
        ArrayList<DataReader> data = readData("src/Database/Dataset.csv");

        for (DataReader b : data) {
            System.out.println(b); 
        }

        // BufferedReader file = new BufferedReader(new FileReader("src/Database/BothSexes.csv"));
        // String date;
        // String province;
        // String labour;
        // String sex;
        // String population; 


        // while(file.readLine() != null){
        //     String data[] = file.readLine().split(",");
        //     date = data[0];
        //     province = data[1];
        //     labour = data[2];
        //     sex = data[3];
        //     population = data[4];
            
        //     // System.out.println(date + "|" + province + "|" + labour + "|" + sex + "|" +population);
        // }
        // file.close();
    }
    private static ArrayList<DataReader> readData(String fileName) throws IOException{
        ArrayList<DataReader> data = new ArrayList<DataReader>();
        BufferedReader file = new BufferedReader(new FileReader(fileName));
      

        while(file.readLine() != null){
            String datalist[] = file.readLine().split(",");
            
            DataReader line = createData(datalist);
            data.add(line);

        }
        file.close();

        return data;
        
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


