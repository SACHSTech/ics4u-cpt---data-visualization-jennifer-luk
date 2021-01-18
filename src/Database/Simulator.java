package Database;

import java.io.*;

public class Simulator {
    public static void main(String[] args) throws IOException{
    
        BufferedReader file = new BufferedReader(new FileReader("src/Database/BothSexes.csv"));
        String date;
        String province;
        String labour;
        String sex;
        String population; 


        while(file.readLine() != null){
            String data[] = file.readLine().split(",");
            date = data[0];
            province = data[1];
            labour = data[2];
            sex = data[3];
            population = data[4];
            System.out.println(date + "     " + province + "     " + labour + "     " + sex + "     " +population);
        }
        file.close();
    }
}


