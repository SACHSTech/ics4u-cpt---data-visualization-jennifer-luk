package Database;

import java.io.*;

public class Simulator {

    // method to pause console
    private static void pause(int pauseLength) {
        try {
            Thread.sleep(pauseLength);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    public static void main(String[] args) throws IOException{
        String date;
        String province;
        String labour;
        String sex;
        String population; 
        String line = "";
        DataReader data; 
        int count = 0; 
        DataReader[] datareader = new DataReader[528];
 
        BufferedReader file = new BufferedReader(new FileReader("src/Database/DataSet.csv"));
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));      
        

        while(count < 528){
            line = file.readLine();
            String[] element = line.split(",");

            date = element[0];
            province = element[1];
            labour = element[2];
            sex = element[3];
            population = element[4];
            
            data = new DataReader(date, province, labour, sex, population);
            
            datareader[count] = data;

            count++; 
        }
        file.close();
        
        System.out.println("\nWelcome to the Stats Canada Labour Force Characteristics System");
        boolean endmenu = true;  
        while (endmenu) {
            endmenu = true; 
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
                System.out.println("Enter the Name of Province\n- Ontario\n- Newfoundland and Labrador\n- Alberta\n- Manitoba\n- Prince Edward Island\n- Nova Scotia\n- British Columbia\n- Saskatchewan\n- Quebec");
                System.out.print("Input Province (case sensitive): ");
                String choice = key.readLine();
                DataSearch.provincesearch(datareader, choice);
                endmenu = false; 
            } else if (strChoice.equals("2")){
                System.out.println("Enter the Labour Type\n- Ontario\n- Newfoundland and Labrador\n- Alberta\n- Manitoba\n- Prince Edward Island\n- Nova Scotia\n- British Columbia\n- Saskatchewan\n- Quebec");
                System.out.print("Input Province (case sensitive): ");
                String choice = key.readLine();
                DataSearch.provincesearch(datareader, choice);
                endmenu = false;
            } else if (strChoice.equals("3")){
                
            } else if (strChoice.equals("4")){
                
            } else if (strChoice.equals("5")){
                
            } else if (strChoice.equals("6")){
                
            } else {
                System.out.println("Invalid Input. Please try again.");
                pause(500);
                clearScreen();
            }
        }
    }
}


