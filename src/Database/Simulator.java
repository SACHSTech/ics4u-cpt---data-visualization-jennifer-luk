package Database;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Simulator extends Application {
    static double EM1901;   
    static double EM1905; 
    static double EM1909; 
    static double UN1901;   
    static double UN1905; 
    static double UN1909; 
    static double EM2001;   
    static double EM2005;
    static double EM2009; 
    static double UN2001;   
    static double UN2005; 
    static double UN2009; 
    static int chart; 

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
        String date2 = "";
        String province;
        String labour;
        String labourtype = "";
        String sex;
        String sex2 = "";
        String str;
        double population; 
        String line = "";
        String name = "";
        String choice; 
       
        DataReader data; 
        int count = 0; 
        DataReader[] datareader = new DataReader[480];
 
        BufferedReader file = new BufferedReader(new FileReader("src/Database/DataSet.csv"));
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));      
        

        while(count < 480){
            line = file.readLine();
            String[] element = line.split(",");

            date = element[0];
            province = element[1];
            labour = element[2];
            sex = element[3];
            population =  Double.parseDouble(element[4]);
            
            data = new DataReader(date, province, labour, sex, population);
            
            datareader[count] = data;

            count++; 
        }
        file.close();
        
        System.out.println("\nWelcome to the Stats Canada Labour Force Characteristics System");
        System.out.println("The following database contains data from January 2019 to September 2020, with records measured on a 4 month basis.\n");
        boolean endmenu = true;  
        while (endmenu) {
            endmenu = true; 
            System.out.println("Please select one of the options below: ");
            System.out.println("\n(1) View Data Sorted by Province");
            System.out.println("(2) View Data Sorted by Labour Type");
            System.out.println("(3) View Data Sorted by Population");
            System.out.println("(4) View Data Sorted by Sex");
            System.out.println("(5) View Data with Multiple Filters");
            System.out.println("(6) View an Individual Record");
            System.out.println("(7) View Summary Report");
            System.out.println("(8) View Charts");

            System.out.print("Input Choice: ");
            String strChoice = key.readLine();
            clearScreen();
            
            if (strChoice.equals("1")){
                System.out.println("Enter province name (Case sensitive):\n- Alberta\n- British Columbia\n- Manitoba\n- New Brunswick\n- Newfoundland and Labrador\n- Nova Scotia\n- Ontario\n- Prince Edward Island\n- Quebec\n- Saskatchewan");
                System.out.print("Input Province (case sensitive): ");
                choice = key.readLine();
                str = DataInteraction.provincesearch(datareader, choice).toString();
                System.out.println("DATE          " + ("PROVINCE                               ").substring(0,27) + ("LABOUR TYPE                                   ").substring(0,24) + ("SEX                                  ").substring(0,12) + ("POPULATION x1,000"));
                ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
                for(int i = 0; i < list.size(); i++){
                    System.out.println(list.get(i).toString());
                }
                endmenu = false; 

            } else if (strChoice.equals("2")){
                System.out.println("Enter the Labour Type\n- Employment\n- Unemployment");
                System.out.print("Input Labour Type (case sensitive): ");
                choice = key.readLine();
                if (choice.equals("Employment")) {
                    System.out.println("Choose a filter to view data by:\n- Employment\n- Part-time employment\n- Full-time employment");
                    System.out.print("Input Filter (case sensitive): ");
                    choice = key.readLine();
                    str = DataInteraction.laboursearch(datareader, choice).toString();
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
                    for(int i = 0; i < list.size(); i++){
                        System.out.println(list.get(i).toString());
                    }
                } else if (choice.equals("Unemployment")){
                    str = DataInteraction.laboursearch(datareader, choice).toString();
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
                    for(int i = 0; i < list.size(); i++){
                        System.out.println(list.get(i).toString());
                    }
                }
                endmenu = false;
                
            } else if (strChoice.equals("3")){
                System.out.print("(1) Sort by lowest to highest\n(2) Sort by highest to lowest");
                choice = key.readLine();
                if (choice.equals("1")){
                   DataInteraction.sortLow(datareader);
                   for (int i = 0; i < datareader.length; i++) {
                        System.out.println(datareader[i]);
                   }
                } else if (choice.equals("2")){
                    DataInteraction.sortHigh(datareader);
                    for (int i = 0; i < datareader.length; i++) {
                        System.out.println(datareader[i]);
                   }
                }
                endmenu = false;
               
            } else if (strChoice.equals("4")){
                System.out.print("Enter sex (Males, Females): ");
                choice = key.readLine();
                str = DataInteraction.sexsearch(datareader, choice).toString();
                ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
                for(int i = 0; i < list.size(); i++){
                    System.out.println(list.get(i).toString());
                }
                endmenu = false;

            } else if (strChoice.equals("5")){
                boolean endmenu2 = true; 
                str ="";
                DataReader[] array = datareader; 
                ArrayList<DataReader> temporary = new ArrayList<DataReader>();
                int j = 480;
                while (endmenu2) {

                    System.out.println("(1) Filter by Date\n(2) Filter by Province\n(3) Filter by Labour Type\n(4) Filter by Sex\n(5) Stop Filtering\n");
                    choice= key.readLine();
                    if(choice.equals("1")){
                        temporary.clear();
                        System.out.println("Enter a date (2019-01, 2019-05, 2019-09, 2020-01, 2020-05, 2020-09): ");
                        date2 = key.readLine();
                        temporary.addAll(DataInteraction.datesearch(array, date2));
                        array = temporary.toArray(new DataReader[j/6]);
                        j = j/6;
                     }
                    if (choice.equals("2")){
                        temporary.clear();
                        System.out.println("Enter province name (Case sensitive):\n- Alberta\n- British Columbia\n- Manitoba\n- New Brunswick\n- Newfoundland and Labrador\n- Nova Scotia\n- Ontario\n- Prince Edward Island\n- Quebec\n- Saskatchewan");
                        name = key.readLine();
                        temporary.addAll(DataInteraction.provincesearch(array, name));
                        array = temporary.toArray(new DataReader[j/10]);  
                        j = j/10;
                     } 
                    if (choice.equals("3")) {
                        temporary.clear();
                        System.out.println("Enter the Labour Type (Case sensitive):\n- Employment\n- Part-time employment\n- Full-time employment\n- Unemployment");
                        labourtype = key.readLine();
                        temporary.addAll(DataInteraction.laboursearch(array, labourtype));
                        array = temporary.toArray(new DataReader[j/4]);
                        j = j/4;
                     } if (choice.equals("4")) {
                        temporary.clear();
                        System.out.println("Enter sex (Case Sensitive): \n- Males\n- Females");
                        sex2 = key.readLine();
                        temporary.addAll(DataInteraction.sexsearch(array, sex2));
                        array = temporary.toArray(new DataReader[j/2]);
                        j = j/2;
                    } 
                    if (choice.equals("5")) {
                        System.out.println("Processing filters...");
                        pause(500);
                        System.out.println("------------------- Filtered Data -------------------");
                        str = Arrays.toString(temporary.toArray()).replace("[", " ").replace("]", "");

                        ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
                        for(int i = 0; i < list.size(); i++){
                            System.out.println(list.get(i).toString());
                        }
                       
                        endmenu2 = false; 
                    }
                    clearScreen();
                }
                  

            } else if (strChoice.equals("6")){
                System.out.println("To view an individual record, enter all the following data");
                System.out.print("Enter a date (2019-01, 2019-05, 2019-09, 2020-01, 2020-05, 2020-09): ");
                date2 = key.readLine();
                System.out.print("Enter province name (Case sensitive):\n- Alberta\n- British Columbia\n- Manitoba\n- New Brunswick\n- Newfoundland and Labrador\n- Nova Scotia\n- Ontario\n- Prince Edward Island\n- Quebec\n- Saskatchewan");
                name = key.readLine();
                System.out.print("Enter labour type (Case sensitive, ex. Employment, Part-time employment, Full-time employment, Unemployment)");
                labourtype = key.readLine(); 
                System.out.print("Enter sex: ");
                sex2 = key.readLine();
                DataInteraction.IndRecordSearch(datareader, date2, name, labourtype, sex2);
                endmenu = false;  

            } else if (strChoice.equals("7")){
                System.out.println("------------------- Summary Report -------------------");
                System.out.println("Total number of records: " + datareader.length);
                System.out.println("Total number of provinces recorded: " + (datareader.length/6/8));
                System.out.println("\n----------- 2019 Summary -----------");
                System.out.println("Average Employment in 2019(Total): " + DataInteraction.AverageLabour(datareader, "Employment", "2019"));
                System.out.println("Average Employment in 2019(Males): " + DataInteraction.AverageLabourSex(datareader, "Employment", "2019", "Males"));
                System.out.println("Average Employment in 2019(Females): " + DataInteraction.AverageLabourSex(datareader, "Employment", "2019", "Females"));
                System.out.println("Average Unemployment in 2019(Total): " + DataInteraction.AverageLabour(datareader, "Unemployment", "2019"));
                System.out.println("Average Unemployment in 2019(Males): " + DataInteraction.AverageLabourSex(datareader, "Unemployment", "2019", "Males"));
                System.out.println("Average Unemployment in 2019(Females): " + DataInteraction.AverageLabourSex(datareader, "Unemployment", "2019", "Females"));
                System.out.println("Highest Employment Rate in 2019: " + DataInteraction.largest(datareader, "Employment", "2019"));
                System.out.println("Lowest Employment Rate in 2019: "+ DataInteraction.smallest(datareader, "Employment", "2019"));
                System.out.println("Highest Unemployment Rate in 2019: " + DataInteraction.largest(datareader, "Unemployment", "2019"));
                System.out.println("Lowest Unemployment Rate in 2019: " + DataInteraction.smallest(datareader, "Unemployment", "2019"));
                
                System.out.println("\n----------- 2020 Summary -----------");
                System.out.println("Average Employment in 2020(Total): " + DataInteraction.AverageLabour(datareader, "Employment", "2020"));
                System.out.println("Average Employment in 2020(Males): " + DataInteraction.AverageLabourSex(datareader, "Employment", "2020", "Males"));
                System.out.println("Average Employment in 2020(Females): " + DataInteraction.AverageLabourSex(datareader, "Employment", "2020", "Females"));
                System.out.println("Average Unemployment in 2020(Total): " + DataInteraction.AverageLabour(datareader, "Unemployment", "2020"));
                System.out.println("Average Unemployment in 2020(Males): " + DataInteraction.AverageLabourSex(datareader, "Unemployment", "2020", "Males"));
                System.out.println("Average Unemployment in 2020(Females): " + DataInteraction.AverageLabourSex(datareader, "Unemployment", "2020", "Females"));
                System.out.println("Highest Employment Rate in 2020: " + DataInteraction.largest(datareader, "Employment", "2020"));
                System.out.println("Lowest Employment Rate in 2020: "+ DataInteraction.smallest(datareader, "Employment", "2020"));
                System.out.println("Highest Unemployment Rate in 2020: " + DataInteraction.largest(datareader, "Unemployment", "2020"));
                System.out.println("Lowest Unemployment Rate in 2020: " + DataInteraction.smallest(datareader, "Unemployment", "2020"));
                endmenu = false;
                
            } else if (strChoice.equals("8")){
                System.out.println("(1)For line chart \n(2) For table view\n(3) For bar graph");
                choice  = key.readLine();
                if (choice.equals("1")) {
                    chart = 1; 
                }
    
                if (choice.equals("2")) {
                    chart = 2;
                     launch(args);
                }
                if (choice.equals("3")) {
                    chart = 3;
                    EM1901 = DataInteraction.AverageByDate(datareader, "Employment", "2019-01");   
                    EM1905 = DataInteraction.AverageByDate(datareader, "Employment", "2019-05"); 
                    EM1909 = DataInteraction.AverageByDate(datareader, "Employment", "2019-09"); 
                    UN1901 = DataInteraction.AverageByDate(datareader, "Unemployment", "2019-01");   
                    UN1905 = DataInteraction.AverageByDate(datareader, "Unemployment", "2019-05"); 
                    UN1909 = DataInteraction.AverageByDate(datareader, "Unemployment", "2019-09"); 
                    EM2001 = DataInteraction.AverageByDate(datareader, "Employment", "2020-01");   
                    EM2005 = DataInteraction.AverageByDate(datareader, "Employment", "2020-05"); 
                    EM2009 = DataInteraction.AverageByDate(datareader, "Employment", "2020-09"); 
                    UN2001 = DataInteraction.AverageByDate(datareader, "Unemployment", "2020-01");   
                    UN2005 = DataInteraction.AverageByDate(datareader, "Unemployment", "2020-05"); 
                    UN2009 = DataInteraction.AverageByDate(datareader, "Unemployment", "2020-09"); 

                    launch(args);
                }
            } else {
                System.out.println("Invalid Input. Please try again.");
                pause(500);
                clearScreen();
            }
        }
        
    }
    
    public void start(Stage primaryStage) throws Exception {
        String date;
        String province;
        String labour;
        String sex;
        String population; 
        String line = "";

       
        TableData data; 
        int count = 0; 
        TableData[] table = new TableData[480];
 
        BufferedReader file = new BufferedReader(new FileReader("src/Database/DataSet.csv"));      

        while(count < 480){
            line = file.readLine();
            String[] element = line.split(",");

            date = element[0];
            province = element[1];
            labour = element[2];
            sex = element[3];
            population =  element[4];
            
            data = new TableData(date, province, labour, sex, population);
            
            table[count] = data;

            count++; 
        }
        file.close();
        
        if (chart == 1) {
            
        } else if (chart == 2) {
            primaryStage.setScene(new Scene(Charts.theTable()));
        } else if (chart == 3){
            primaryStage.setScene(new Scene(Charts.theBarChart(EM1901, EM1905, EM1909, UN1901, UN1905, UN1909, EM2001, EM2005, EM2009, UN2001, UN2005, UN2009)));
            
        }
        primaryStage.show();
       
    }



}


