package Database;

// Import statement 
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Simulator extends Application {

    // Initialize static variables for charts
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
    
    // Variables for males employment vs unemployment chart
    static double EMM1901;   
    static double EMM1905; 
    static double EMM1909; 
    static double UNM1901;   
    static double UNM1905; 
    static double UNM1909;
    static double EMM2001;   
    static double EMM2005; 
    static double EMM2009;
    static double UNM2001;   
    static double UNM2005; 
    static double UNM2009;
    static int chart; 

    // Method to pause console
    private static void pause(int pauseLength) {
        try {
            Thread.sleep(pauseLength);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to clear screen
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    public static void main(String[] args) throws IOException{

        // Initialize variables
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

        // Array that holds the csv data instances 
        DataReader[] datareader = new DataReader[480];
        
        // Allows reading of the csv file 
        BufferedReader file = new BufferedReader(new FileReader("src/Database/DataSet.csv"));

        // Allows reading of the user input
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));      
        
        // While loop to read the data set
        while(count < 480){

            // Read the csv file and split each array element by comma
            line = file.readLine();
            String[] element = line.split(",");

            // Each element from the array represents an attribute to the labour characteristics
            date = element[0];
            province = element[1];
            labour = element[2];
            sex = element[3];
            population =  Double.parseDouble(element[4]);
            
            // Creates a new data object and puts the object into an array 
            data = new DataReader(date, province, labour, sex, population);
            datareader[count] = data;

            count++; 
        }

        // close file
        file.close();
        

        // main menu outprint 
        System.out.println("\nWelcome to the Stats Canada Labour Force Characteristics System");
        System.out.println("The following database contains data from January 2019 to September 2020, with records measured on a 4 month basis.\n");
        
        // loop for main menu 
        boolean endmenu = true;  
        while (endmenu) {
            endmenu = true; 

            // Present main menu choices
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
            
            // Allows user to view data sorted by province 
            if (strChoice.equals("1")){
                System.out.println("Enter province name (Case sensitive):\n- Alberta\n- British Columbia\n- Manitoba\n- New Brunswick\n- Newfoundland and Labrador\n- Nova Scotia\n- Ontario\n- Prince Edward Island\n- Quebec\n- Saskatchewan");
                System.out.print("Input Province (case sensitive): ");
                choice = key.readLine();
                str = DataInteraction.provincesearch(datareader, choice).toString();
                System.out.println("DATE          " + ("PROVINCE                               ").substring(0,27) + ("LABOUR TYPE                                   ").substring(0,24) + ("SEX                                  ").substring(0,12) + ("POPULATION x1,000"));
                
                // Convert string to arraylist and print out 
                ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
                for(int i = 0; i < list.size(); i++){
                    System.out.println(list.get(i).toString());
                }
                
                // Option to continue viewing other menu options or end program 
                System.out.println("\n(M) Main Menu\n(X) Exit Database");
                choice = key.readLine();
                if (choice.equals("M")){
                    endmenu = true; 
                    System.out.println("Returning to Main Menu...");
                    pause(500);
                    clearScreen();
                } else if (choice.equals("X")){
                    endmenu = false;
                }
                
            // Allows user to view by labour type 
            } else if (strChoice.equals("2")){
                System.out.println("Enter the Labour Type\n- Employment\n- Unemployment");
                System.out.print("Input Labour Type (case sensitive): ");
                choice = key.readLine();

                // Filters by the labour type user inputs 
                if (choice.equals("Employment")) {
                    System.out.println("Choose a filter to view data by:\n- Employment\n- Part-time employment\n- Full-time employment");
                    System.out.print("Input Filter (case sensitive): ");
                    choice = key.readLine();
                    str = DataInteraction.laboursearch(datareader, choice).toString();
                    System.out.println("DATE          " + ("PROVINCE                               ").substring(0,27) + ("LABOUR TYPE                                   ").substring(0,24) + ("SEX                                  ").substring(0,12) + ("POPULATION x1,000"));
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
                    for(int i = 0; i < list.size(); i++){
                        System.out.println(list.get(i).toString());
                    }
                
                } else if (choice.equals("Unemployment")){
                    str = DataInteraction.laboursearch(datareader, choice).toString();
                    System.out.println("DATE          " + ("PROVINCE                               ").substring(0,27) + ("LABOUR TYPE                                   ").substring(0,24) + ("SEX                                  ").substring(0,12) + ("POPULATION x1,000"));
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
                    for(int i = 0; i < list.size(); i++){
                        System.out.println(list.get(i).toString());
                    }
                }
                
                // Option to continue viewing other menu options or end program 
                System.out.println("\n(M) Main Menu\n(X) Exit Database");
                choice = key.readLine();
                if (choice.equals("M")){
                    endmenu = true; 
                    System.out.println("Returning to Main Menu...");
                    pause(500);
                    clearScreen();
                } else if (choice.equals("X")){
                    endmenu = false;
                }
            
            // Allows use to view data sorted by population 
            } else if (strChoice.equals("3")){
                System.out.print("(1) Sort by lowest to highest\n(2) Sort by highest to lowest");
                choice = key.readLine();
                
                System.out.println("DATE          " + ("PROVINCE                               ").substring(0,27) + ("LABOUR TYPE                                   ").substring(0,24) + ("SEX                                  ").substring(0,12) + ("POPULATION x1,000"));
                
                // Sorts data from lowest to highest 
                if (choice.equals("1")){
                   DataInteraction.sortLow(datareader);
                   for (int i = 0; i < datareader.length; i++) {
                        System.out.println(datareader[i]);
                   }
                
                // Sorts data from highest to lowest 
                } else if (choice.equals("2")){
                    DataInteraction.sortHigh(datareader);
                    for (int i = 0; i < datareader.length; i++) {
                        System.out.println(datareader[i]);
                   }
                }

                // Option to continue viewing other menu options or end program 
                System.out.println("\n(M) Main Menu\n(X) Exit Database");
                choice = key.readLine();
                if (choice.equals("M")){
                    endmenu = true; 
                    System.out.println("Returning to Main Menu...");
                    pause(500);
                    clearScreen();
                } else if (choice.equals("X")){
                    endmenu = false;
                }
               
            // Sorts data by sex 
            } else if (strChoice.equals("4")){
                System.out.print("Enter sex (Males, Females): ");
                choice = key.readLine();
                str = DataInteraction.sexsearch(datareader, choice).toString();
                System.out.println("DATE          " + ("PROVINCE                               ").substring(0,27) + ("LABOUR TYPE                                   ").substring(0,24) + ("SEX                                  ").substring(0,12) + ("POPULATION x1,000"));
                ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
                for(int i = 0; i < list.size(); i++){
                    System.out.println(list.get(i).toString());
                }

                // Option to continue viewing other menu options or end program 
                System.out.println("\n(M) Main Menu\n(X) Exit Database");
                choice = key.readLine();
                if (choice.equals("M")){
                    endmenu = true; 
                    System.out.println("Returning to Main Menu...");
                    pause(500);
                    clearScreen();
                } else if (choice.equals("X")){
                    endmenu = false;
                }

            // Sorts data with multiple filters 
            } else if (strChoice.equals("5")){
                boolean endmenu2 = true; 
                str ="";

                // array to store updated array elements based on filters applied
                DataReader[] array = datareader; 

                // temporary array list to add elements to 
                ArrayList<DataReader> temporary = new ArrayList<DataReader>();

                // integer to keep count of # of elements in array after each filter applied
                int j = 480;

                // Continues to loop multiple filters menu until user stops 
                while (endmenu2) {

                    System.out.println("(1) Filter by Date\n(2) Filter by Province\n(3) Filter by Labour Type\n(4) Filter by Sex\n(5) Stop Filtering\n");
                    choice= key.readLine();
                    if (choice.equals("1")) {
                        temporary.clear();
                        System.out.println("Enter a date (2019-01, 2019-05, 2019-09, 2020-01, 2020-05, 2020-09): ");
                        date2 = key.readLine();
                        temporary.addAll(DataInteraction.datesearch(array, date2));
                        array = temporary.toArray(new DataReader[j/6]);
                        j = j/6;
                    
                    } else if (choice.equals("2")) {
                        temporary.clear();
                        System.out.println("Enter province name (Case sensitive):\n- Alberta\n- British Columbia\n- Manitoba\n- New Brunswick\n- Newfoundland and Labrador\n- Nova Scotia\n- Ontario\n- Prince Edward Island\n- Quebec\n- Saskatchewan");
                        name = key.readLine();
                        temporary.addAll(DataInteraction.provincesearch(array, name));
                        array = temporary.toArray(new DataReader[j/10]);  
                        j = j/10;
                     
                    } else if (choice.equals("3")) {
                        temporary.clear();
                        System.out.println("Enter the Labour Type (Case sensitive):\n- Employment\n- Part-time employment\n- Full-time employment\n- Unemployment");
                        labourtype = key.readLine();
                        temporary.addAll(DataInteraction.laboursearch(array, labourtype));
                        array = temporary.toArray(new DataReader[j/4]);
                        j = j/4;

                     } else if (choice.equals("4")) {
                        temporary.clear();
                        System.out.println("Enter sex (Case Sensitive): \n- Males\n- Females");
                        sex2 = key.readLine();
                        temporary.addAll(DataInteraction.sexsearch(array, sex2));
                        array = temporary.toArray(new DataReader[j/2]);
                        j = j/2;
                     
                     } else if (choice.equals("5")) {
                        System.out.println("Processing filters...");
                        pause(500);
                        System.out.println("------------------- Filtered Data -------------------");
                        System.out.println("DATE          " + ("PROVINCE                               ").substring(0,27) + ("LABOUR TYPE                                   ").substring(0,24) + ("SEX                                  ").substring(0,12) + ("POPULATION x1,000"));
                        str = Arrays.toString(temporary.toArray()).replace("[", " ").replace("]", "");
                        ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
                        for(int i = 0; i < list.size(); i++){
                            System.out.println(list.get(i).toString());
                        }
                       
                        endmenu2 = false; 
                    }
                    clearScreen();
                }

                // option to continue viewing other menu options or end program 
                System.out.println("\n(M) Main Menu\n(X) Exit Database");
                choice = key.readLine();
                if (choice.equals("M")){
                    endmenu = true; 
                    System.out.println("Returning to Main Menu...");
                    pause(500);
                    clearScreen();
                } else if (choice.equals("X")){
                    endmenu = false;
                }

            // View individual records 
            } else if (strChoice.equals("6")){
                System.out.println("To view an individual record, enter all the following data");
                System.out.println("Enter a date\n- 2019-01\n- 2019-05\n- 2019-09\n- 2020-01\n- 2020-05\n- 2020-09): ");
                date2 = key.readLine();
                System.out.println("\nEnter province name (Case sensitive):\n- Alberta\n- British Columbia\n- Manitoba\n- New Brunswick\n- Newfoundland and Labrador\n- Nova Scotia\n- Ontario\n- Prince Edward Island\n- Quebec\n- Saskatchewan");
                name = key.readLine();
                System.out.println("\nEnter labour type (Case sensitive)\n- Employment\n- Part-time employment\n- Full-time employment\n- Unemployment)");
                labourtype = key.readLine(); 
                System.out.println("\nEnter sex (Case sensitive)\n- Males\n- Females):");
                sex2 = key.readLine();

                System.out.println("\nDATE          " + ("PROVINCE                               ").substring(0,27) + ("LABOUR TYPE                                   ").substring(0,24) + ("SEX                                  ").substring(0,12) + ("POPULATION x1,000"));
                DataInteraction.IndRecordSearch(datareader, date2, name, labourtype, sex2);
                
                // Option to continue viewing other menu options or end program 
                System.out.println("\n(M) Main Menu\n(X) Exit Database");
                choice = key.readLine();
                if (choice.equals("M")){
                    endmenu = true; 
                    System.out.println("Returning to Main Menu...");
                    pause(500);
                    clearScreen();
                } else if (choice.equals("X")){
                    endmenu = false;
                } 

            // View summary report to compare 2019 and 2020 data
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
                
                // Option to continue viewing other menu options or end program 
                System.out.println("\n(M) Main Menu\n(X) Exit Database");
                choice = key.readLine();
                if (choice.equals("M")){
                    endmenu = true; 
                    System.out.println("Returning to Main Menu...");
                    pause(500);
                    clearScreen();
                } else if (choice.equals("X")){
                    endmenu = false;
                }
            
            // View three different charts based on data 
            } else if (strChoice.equals("8")){
                System.out.println("(1)For line chart\n(2) For table view\n(3) For bar graph");
                choice  = key.readLine();

                // Allows use to view a line chart about the average male and female employment vs unmployment from Jan 2019 - Sep 2020
                if (choice.equals("1")) { 

                    // Gets average employment rate of males
                    EMM1901 = DataInteraction.AveragebySex(datareader, "Employment", "2019-01", "Males");   
                    EMM1905 = DataInteraction.AveragebySex(datareader, "Employment", "2019-05", "Males"); 
                    EMM1909 = DataInteraction.AveragebySex(datareader, "Employment", "2019-09", "Males");
                    EMM2001 = DataInteraction.AveragebySex(datareader, "Employment", "2020-01", "Males");   
                    EMM2005 = DataInteraction.AveragebySex(datareader, "Employment", "2020-05", "Males"); 
                    EMM2009 = DataInteraction.AveragebySex(datareader, "Employment", "2020-09", "Males"); 

                    // Gets average employment rate of females
                    EM1901 = DataInteraction.AveragebySex(datareader, "Employment", "2019-01", "Females");   
                    EM1905 = DataInteraction.AveragebySex(datareader, "Employment", "2019-05", "Females"); 
                    EM1909 = DataInteraction.AveragebySex(datareader, "Employment", "2019-09", "Females"); 
                    EM2001 = DataInteraction.AveragebySex(datareader, "Employment", "2020-01", "Females");   
                    EM2005 = DataInteraction.AveragebySex(datareader, "Employment", "2020-05", "Females"); 
                    EM2009 = DataInteraction.AveragebySex(datareader, "Employment", "2020-09", "Females"); 

                    // Gets average employment rate of males
                    UNM1901 = DataInteraction.AveragebySex(datareader, "Unemployment", "2019-01", "Males");   
                    UNM1905 = DataInteraction.AveragebySex(datareader, "Unemployment", "2019-05", "Males"); 
                    UNM1909 = DataInteraction.AveragebySex(datareader, "Unemployment", "2019-09", "Males"); 
                    UNM2001 = DataInteraction.AveragebySex(datareader, "Unemployment", "2020-01", "Males");   
                    UNM2005 = DataInteraction.AveragebySex(datareader, "Unemployment", "2020-05", "Males"); 
                    UNM2009 = DataInteraction.AveragebySex(datareader, "Unemployment", "2020-09", "Males");
                    
                    // Gets average unemployment rate of females
                    UN1901 = DataInteraction.AveragebySex(datareader, "Unemployment", "2019-01", "Females");   
                    UN1905 = DataInteraction.AveragebySex(datareader, "Unemployment", "2019-05", "Females"); 
                    UN1909 = DataInteraction.AveragebySex(datareader, "Unemployment", "2019-09", "Females"); 
                    UN2001 = DataInteraction.AveragebySex(datareader, "Unemployment", "2020-01", "Females");   
                    UN2005 = DataInteraction.AveragebySex(datareader, "Unemployment", "2020-05", "Females"); 
                    UN2009 = DataInteraction.AveragebySex(datareader, "Unemployment", "2020-09", "Females");
                    
                    // launches chart
                    chart = 1;
                    launch(args);
                }
                
                // Allows user to view a table 
                if (choice.equals("2")) {
                    
                    // launches chart
                    chart = 2;
                    launch(args);
                }

                // Allows user to view  bar chart 
                if (choice.equals("3")) {
                    
                    // Gets averate unemployment and employment rates by date 
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
                    
                    // launches chart
                    chart = 3;
                    launch(args);
                }

                endmenu = false; 
            
            // Invalid menu input 
            } else {
                System.out.println("Invalid Input. Please try again.");
                pause(500);
                clearScreen();
            }
        }
        
    }
    
    // Runs the charts that are chosen by the user
    public void start(Stage primaryStage) throws Exception {
        
        // runs line graph 
        if (chart == 1) {
            primaryStage.setScene(new Scene(Charts.theLineChart(EMM1901, EMM1905, EMM1909, EMM2001, EMM2005, EMM2009, EM1901, EM1905, EM1909, EM2001, EM2005, EM2009, 
            UNM1901, UNM1905, UNM1909, UNM2001, UNM2005, UNM2009, UN1901, UN1905, UN1909, UN2001, UN2005, UN2009)));
        
        // runs table
        } else if (chart == 2) {
            primaryStage.setScene(new Scene(Charts.theTable()));

        // runs bar graph 
        } else if (chart == 3){
            primaryStage.setScene(new Scene(Charts.theBarChart(EM1901, EM1905, EM1909, UN1901, UN1905, UN1909, EM2001, EM2005, EM2009, UN2001, UN2005, UN2009)));
            
        }
        primaryStage.show();
       
    }



}


