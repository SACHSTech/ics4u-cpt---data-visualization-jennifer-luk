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
        String date2 = "";
        String province;
        String labour;
        String labourtype = "";
        String sex;
        String sex2 = "";
        Double population; 
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
        System.out.println("The following database contains data from January 2019 to September 2020, with records measured on a 4 month basis.\nWith the data, ");
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
                System.out.println("Enter the Name of Province\n- Ontario\n- Newfoundland and Labrador\n- Alberta\n- Manitoba\n- Prince Edward Island\n- Nova Scotia\n- British Columbia\n- Saskatchewan\n- Quebec");
                System.out.print("Input Province (case sensitive): ");
                choice = key.readLine();
                System.out.println(DataSearch.provincesearch(datareader, choice).toString());
                endmenu = false; 

            } else if (strChoice.equals("2")){
                System.out.println("Enter the Labour Type\n- Employment\n- Unemployment");
                System.out.print("Input Labour Type (case sensitive): ");
                choice = key.readLine();
                if (choice.equals("Employment")) {
                    System.out.println("Choose a filter to view data by:\n- Employment\n- Part-time employment\n- Full-time employment");
                    System.out.print("Input Filter (case sensitive): ");
                    choice = key.readLine();
                    DataSearch.laboursearch(datareader, choice);
                } else if (choice.equals("Unemployment")){
                    DataSearch.laboursearch(datareader, choice);
                }
                endmenu = false;
                
            } else if (strChoice.equals("3")){
                System.out.print("(1) Sort by lowest to highest\n(2) Sort by highest to lowest");
                choice = key.readLine();
                if (choice.equals("1")){
                   DataSort.sortLow(datareader);
                   for (int i = 0; i < datareader.length; i++) {
                        System.out.println(datareader[i]);
                   }
                } else if (choice.equals("2")){
                    DataSort.sortHigh(datareader);
                    for (int i = 0; i < datareader.length; i++) {
                        System.out.println(datareader[i]);
                   }
                }
                endmenu = false;
               
            } else if (strChoice.equals("4")){
                System.out.print("Enter sex (Males, Females): ");
                choice = key.readLine();
                DataSearch.sexsearch(datareader, choice);
                endmenu = false;

            } else if (strChoice.equals("5")){
                boolean endmenu2 = true; 
                while (endmenu2) {
                    System.out.println("(1) Filter by Date\n(2) Filter by Province\n(3) Filter by Labour Type\n(4) Filter by Sex\n(5) Stop Filtering");
                     choice= key.readLine();
                    if(choice.equals("1")){
                        System.out.println("Enter a date (2019-01, 2019-05, 2019-09, 2020-01, 2020-05, 2020-09): ");
                        date2 = key.readLine();
                        DataSearch.datesearch(datareader, choice);
                    } else if (choice.equals("2")){
                        System.out.println("Enter province name (Case sensitive):\n- Ontario\n- Newfoundland and Labrador\n- Alberta\n- Manitoba\n- Prince Edward Island\n- Nova Scotia\n- British Columbia\n- Saskatchewan\n- Quebec");
                        name = key.readLine();
                        DataSearch.provincesearch(datareader, choice);
                    } else if (choice.equals("3")) {
                        System.out.println("Enter the Labour Type (Case sensitive):\n- Employment\n- Part-time employment\n- Full-time employment\n- Unemployment");
                        labourtype = key.readLine();
                    } else if (choice.equals("4")) {
                        System.out.println("Enter sex (Case Sensitive): \n- Males\n- Females");
                        sex2 = key.readLine();
                    } else if (choice.equals("5")) {
                        System.out.println("Processing filters...");
                        pause(500);
                        endmenu2 = false; 
                    }
                }
                  

            } else if (strChoice.equals("6")){
                System.out.println("To view an individual record, enter all the following data");
                System.out.print("Enter a date (2019-01, 2019-05, 2019-09, 2020-01, 2020-05, 2020-09): ");
                date2 = key.readLine();
                System.out.print("Enter province name (Case sensitive): ");
                name = key.readLine();
                System.out.print("Enter labour type (Case sensitive, ex. Employment, Part-time employment, Full-time employment, Unemployment)");
                labourtype = key.readLine(); 
                System.out.print("Enter sex: ");
                sex2 = key.readLine();
                DataSearch.IndRecordSearch(datareader, date2, name, labourtype, sex2);
                endmenu = false;  
            } else if (strChoice.equals("7")){
                System.out.println("------------------- Summary Report -------------------");
                System.out.println("Total number of records: " + datareader.length);
                System.out.println("Total number of provinces recorded: " + (datareader.length/6/8));
                System.out.println("\n----------- 2019 Summary -----------");
                System.out.println("Average Employment in 2019(Total): " + DataSort.AverageLabour(datareader, "Employment", "2019"));
                System.out.println("Average Employment in 2019(Males): " + DataSort.AverageLabourSex(datareader, "Employment", "2019", "Males"));
                System.out.println("Average Employment in 2019(Females): " + DataSort.AverageLabourSex(datareader, "Employment", "2019", "Females"));
                System.out.println("Average Unemployment in 2019(Total): " + DataSort.AverageLabour(datareader, "Unemployment", "2019"));
                System.out.println("Average Unemployment in 2019(Males): " + DataSort.AverageLabourSex(datareader, "Unemployment", "2019", "Males"));
                System.out.println("Average Unemployment in 2019(Females): " + DataSort.AverageLabourSex(datareader, "Unemployment", "2019", "Females"));
                System.out.println("Highest Employment Rate in 2019: " + DataSort.largest(datareader, "Employment", "2019"));
                System.out.println("Lowest Employment Rate in 2019: "+ DataSort.smallest(datareader, "Employment", "2019"));
                System.out.println("Highest Unemployment Rate in 2019: " + DataSort.largest(datareader, "Unemployment", "2019"));
                System.out.println("Lowest Unemployment Rate in 2019: " + DataSort.smallest(datareader, "Unemployment", "2019"));
                
                System.out.println("\n----------- 2020 Summary -----------");
                System.out.println("Average Employment in 2020(Total): " + DataSort.AverageLabour(datareader, "Employment", "2020"));
                System.out.println("Average Employment in 2020(Males): " + DataSort.AverageLabourSex(datareader, "Employment", "2020", "Males"));
                System.out.println("Average Employment in 2020(Females): " + DataSort.AverageLabourSex(datareader, "Employment", "2020", "Females"));
                System.out.println("Average Unemployment in 2020(Total): " + DataSort.AverageLabour(datareader, "Unemployment", "2020"));
                System.out.println("Average Unemployment in 2020(Males): " + DataSort.AverageLabourSex(datareader, "Unemployment", "2020", "Males"));
                System.out.println("Average Unemployment in 2020(Females): " + DataSort.AverageLabourSex(datareader, "Unemployment", "2020", "Females"));
                System.out.println("Highest Employment Rate in 2020: " + DataSort.largest(datareader, "Employment", "2020"));
                System.out.println("Lowest Employment Rate in 2020: "+ DataSort.smallest(datareader, "Employment", "2020"));
                System.out.println("Highest Unemployment Rate in 2020: " + DataSort.largest(datareader, "Unemployment", "2020"));
                System.out.println("Lowest Unemployment Rate in 2020: " + DataSort.smallest(datareader, "Unemployment", "2020"));
                endmenu = false;
            } else if (strChoice.equals("8")){
              
            } else {
                System.out.println("Invalid Input. Please try again.");
                pause(500);
                clearScreen();
            }
        }
    }

}


