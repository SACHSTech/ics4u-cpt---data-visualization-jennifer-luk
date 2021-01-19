package Database;

import java.io.*;

public class Simulator {
    public static void main(String[] args) throws IOException{
        String date;
        String province;
        String labour;
        String sex;
        String population; 
        String line = "";
        Province prov; 
        Labour lab; 
        int count = 0; 
        Province[] provinces = new Province[792];
        Labour[] labourtype = new Labour[792];

        BufferedReader file = new BufferedReader(new FileReader("src/Database/DataSet.csv"));
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));      
        

        while(count < 792){
            line = file.readLine();
            String[] element = line.split(",");

            date = element[0];
            province = element[1];
            labour = element[2];
            sex = element[3];
            population = element[4];
            
            prov = new Province(date, province, labour, sex, population);
            lab = new Labour(date, province, labour, sex, population);
           
            provinces[count] = prov;
            labourtype [count] = lab; 

            count++; 
        }
        file.close();
        
        System.out.println("\nWelcome to the Stats Canada Labour Force Characteristics System");
        boolean endmenu = true;  
        while (endmenu) {
            System.out.println("Please select one of the options below: ");
            System.out.println("\n(1) View Data Sorted by Province");
            System.out.println("(2) View Data Sorted by Labour Type");
            System.out.println("(3) View Data with Filters");
            System.out.println("(4) View an Individual Record by Month & Year");
            System.out.println("(5) View Summary Report");
            System.out.println("(6) View Charts");

            System.out.print("Input Choice: ");
            String strChoice = key.readLine();

            if (strChoice.equals("1")){

            } else if (strChoice.equals("2")){

            } else if (strChoice.equals("3")){
                
            } else if (strChoice.equals("4")){
                
            } else if (strChoice.equals("5")){
                
            } else if (strChoice.equals("6")){
                
            } else {
                
            }
        }
    }
}


