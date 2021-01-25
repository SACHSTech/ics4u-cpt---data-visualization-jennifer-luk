package Database;

// Import statements 
import java.util.ArrayList;

public class DataInteraction {

    // The methods below search the data set  

    /**
    * Searchs the data set for province choice
    * @param array - the datareader array 
    * @param province - the name of the province
    * @return the array list that contains the province  
    */
    public static ArrayList<DataReader> provincesearch(DataReader[] array, String province){
        String provinceelement;

        // Array list that holds all the data entries with the province choice
        ArrayList<DataReader> temporary = new ArrayList<DataReader>(); 

        // Check if the province in the array element is province of choice
        for(int i = 0; i < array.length; i++){
            provinceelement = array[i].getprovince();	
            
            // Add to array list 
            if(provinceelement.equals(province)){
                temporary.add(array[i]);
            }
        }
        
        // Return array list 
        return temporary; 
    }

    /**
    * Searchs the data set for labour choice
    * @param array - the datareader array 
    * @param labour - the name of the labour
    * @return the array list that contains the labour type  
    */
    public static ArrayList<DataReader> laboursearch(DataReader[] array, String labour){
        String labourelement;

        // Array list that holds all the data entries with the labour choice
        ArrayList<DataReader> temporary = new ArrayList<DataReader>();

         // Check if the labour type in the array element is labour type of choice
        for(int i = 0; i < array.length; i++){
            labourelement = array[i].getlabour();		
            
            // Add to array list 
            if(labourelement.equals(labour)){
                temporary.add(array[i]);
            }
        }
    
        // Return array list 
        return temporary; 
    }

    /**
    * Searchs the data set for date choice
    * @param array - the datareader array 
    * @param date - the name of the date
    * @return the array list that contains the date    
    */
    public static ArrayList<DataReader> datesearch(DataReader[] array, String date){
        String dateelement;

        // Array list that holds all the data entries with the date choice
        ArrayList<DataReader> temporary = new ArrayList<DataReader>();

        // Check if the labour type in the array element is labour type of choice
        for (int i = 0; i < array.length; i++) {
            dateelement = array[i].getdate();				
            
            // Add to array list 
            if (dateelement.equals(date)) {
                temporary.add(array[i]);
            }
        }
    
        // Return array list 
        return temporary; 

    }

    /**
    * Searchs the data set for sex choice
    * @param array - the datareader array 
    * @param sex - the name of the sex
    * @return the array list that contains the sex    
    */
    public static ArrayList<DataReader> sexsearch(DataReader[] array, String sex){
        String sexelement;

        // Array list that holds all the data entries with the date choice
        ArrayList<DataReader> temporary = new ArrayList<DataReader>();

        // Check if the sex in the array element is sex of choice
        for(int i = 0; i < array.length; i++){
            sexelement = array[i].getsex();	
            
            // Add to array list 
            if(sexelement.equals(sex)){
                temporary.add(array[i]);
            }
        }
        
        // Return array list 
        return temporary; 

    }

    /**
    * Searchs the data set for an individual record
    * @param array - the datareader array 
    * @param date - the date of the data
    * @param name - the province name 
    * @param labtype - the labour type
    * @param sex - the sex
    * @return the elements of the array that meets the parameters
    */
    public static String IndRecordSearch(DataReader[] array, String date, String name, String labtype, String sex){
    
        // Initialize variables
        String thename;
        String thedate;
        String thelabtype;
        String thesex;

        // Runs through the array
        for(int i = 0; i < array.length; i++){
            thedate = array[i].getdate();
            thename = array[i].getprovince();		
            thelabtype = array[i].getlabour();	
            thesex = array[i].getsex();

            // Checks  see if the user choices are found in the array 
            if(thename.equals(name) && thedate.equals(date) && thelabtype.equals(labtype) && thesex.equals(sex)){

                // Prints out and returns the elemnt of the array 
                System.out.println(array[i].toString());
            }
        }

        // Returns a invalid message 
        return "Not a valid data entry";

    }

    // The methods below sort the data set

    /**
    * Sorts the data set from the lowest to highest population 
    * @param array - the datareader array 
    * @return the sorted array
    */
    public static DataReader[] sortLow(DataReader[] array){

        // Initialize variables
        int currentlowest;

        // Sort for the whole array minus one and sorts the current minimum to the front of the list 
        for (int i = 0; i < array.length - 1; i++) {
            currentlowest = i;

            // Find index of the minimum in unsorted list 
            for (int j = i + 1; j < array.length; j++) {

                // Check to see if population is less than current minimum 
                if (array[j].getpopulation() < array[currentlowest].getpopulation()) {
                    currentlowest = j;
                }
            }

            // Switches the elements to update current minimum 
            if (i != currentlowest){
                DataReader temporary = array[currentlowest];
                array[currentlowest] = array[i];
                array[i] = temporary;
            }
        }

        // Returns sorted array
        return array;

    }

    /**
    * Sorts the data set from the highest to lowest population 
    * @param array - the datareader array 
    * @return the sorted array
    */
    public static DataReader[] sortHigh(DataReader[] array){

        // Initialize variables
        int currenthighest;

        // Sort for the whole array minus one and sorts the current maximum to the front of the list 
        for (int i = 0; i < array.length - 1; i++) {
            currenthighest = i;

            // Find index of the maximum in unsorted list 
            for (int j = i + 1; j < array.length; j++) {
                
                // Check to see if population is greater than current maximum 
                if (array[j].getpopulation() > array[currenthighest].getpopulation()) {
                    currenthighest = j;
                }
            }

            // Switches the elements to update current maximum  
            if (i != currenthighest){
                DataReader temporary = array[currenthighest];
                array[currenthighest] = array[i];
                array[i] = temporary;
            }
        }

        // Returns sorted array
        return array;
    }

    /**
    * Sorts the data for highest labour type rate depending on date 
    * @param array - the datareader array 
    * @param labour - the labour type
    * @param date - the date
    * @return the highest labour type 
    */
    public static double largest(DataReader[] array, String labour, String date){

        // Initialize variables
        String element; 
        String dateelement; 
        double currentmax = 0;

        // Go through the whole array 
        for(int i = 0; i < array.length; i++){
            element = array[i].getlabour();	
            dateelement = array[i].getdate().substring(0, 4);
            
            // Check to see if elements meet the parameters
            if(element.equals(labour) && dateelement.equals(date)){ 

                // Swap elements 
                if (array[i].getpopulation() > currentmax) {
                    currentmax = array[i].getpopulation();
                }             
            }
        }
        
        // Return highest value 
        return currentmax;  
    }

    /**
    * Sorts the data for lowest labour type rate depending on date 
    * @param array - the datareader array 
    * @param labour - the labour type
    * @param date - the date
    * @return the lowest labour type 
    */
    public static double smallest(DataReader[] array, String labour, String date){
        
        // Initialize variables
        String labourelement; 
        String dateelement; 
        double currentmin = 0;

        // Go through the whole array 
        for(int i = 0; i < array.length; i++){
            labourelement = array[i].getlabour();	
            dateelement = array[i].getdate().substring(0, 4);
            
            // Set the first array element as lowest value 
            if (i == 1){
                currentmin = array[i].getpopulation();
            }

            // Check to see if elements meet the parameters
            if(labourelement.equals(labour) && dateelement.equals(date)){ 
                
                // Swap elements 
                if (array[i].getpopulation() < currentmin) {
                    currentmin = array[i].getpopulation();
                }             
            }
        }

        // Return lowest value
        return currentmin;  
    }

    // The methods below calculate the averages

    /**
    * Calculates the average of the labour type according to date 
    * @param array - the datareader array 
    * @param labour - the labour type 
    * @param date - the date
    * @return the average of the employment type 
    */
    public static double AverageLabour(DataReader[] array, String labour, String date) {
        
        // Initialize variables 
        String labourelement; 
        String dateelement; 
        double sum = 0; 
        int n = 0;

        // Go through the whole array 
        for (int i = 0; i < array.length; i++) {
            labourelement = array[i].getlabour();	

            // Takes the first four characters of date string (year)
            dateelement = array[i].getdate().substring(0, 4);

            // If elements meet the parameters, add to the sum
            if (labourelement.equals(labour) && dateelement.equals(date)) {
                n++;
                sum += array[i].getpopulation();
            }                              
        }

        // Returns the average to two decimal places
        return Math.round((sum / n) * 100.0) / 100.0;    
    }

    /**
    * Calculates the average of the labour type according to date and sex
    * @param array - the datareader array 
    * @param labour - the labour type 
    * @param date - the date
    * @param sex - the sex
    * @return the average of the employment type 
    */
    public static double AverageLabourSex(DataReader[] array, String labour, String date, String sex){
        
        // Initialize variables 
        String labourelement; 
        String dateelement; 
        String sexelement;
        double sum = 0; 
        int n = 0;

        // Go through the whole array 
        for(int i = 0; i < array.length; i++){
            labourelement = array[i].getlabour();	
            dateelement = array[i].getdate().substring(0, 4);
            sexelement = array[i].getsex();

            // If elements meet the parameters, add to the sum
            if(labourelement.equals(labour) && dateelement.equals(date) && sexelement.equals(sex)){
                n++;
                sum += array[i].getpopulation();
            }
        }

        // Returns the average to two decimal places
        return Math.round((sum / n) * 100.0) / 100.0;    
    }

    /**
    * Calculates the average of the labour type according to date and month for bar chart
    * @param array - the datareader array 
    * @param labour - the labour type 
    * @param date - the date and month 
    * @return the average of the employment type 
    */
    public static double AverageByDate(DataReader[] array, String labourtype, String date){

        // Initialize variables
        String element; 
        String dateelement; 
        double sum = 0; 
        int n = 0;

        // Go through whole array 
        for(int i = 0; i < array.length; i++){
            element = array[i].getlabour();	
            dateelement = array[i].getdate();

            // If elements meet the parameters, add to the sum
            if(element.equals(labourtype) && dateelement.equals(date)){
                n++;
                sum += array[i].getpopulation();
            }
        }

        // Returns the average to two decimal places
        return Math.round((sum / n) * 100.0) / 100.0;    
    }

    /**
    * Calculates the average of the labour type according to date, month, and sex for line chart
    * @param array - the datareader array 
    * @param labour - the labour type 
    * @param date - the date and month 
    * @param sex - the sex
    * @return the average of the employment type 
    */
    public static double AveragebySex(DataReader[] array, String choice, String date, String sex){
        
        // Initialize variables
        String element; 
        String dateelement; 
        String sexelement;
        double sum = 0; 
        int n = 0;
        
        // Go through whole array
        for(int i = 0; i < array.length; i++){
            element = array[i].getlabour();	
            dateelement = array[i].getdate();
            sexelement = array[i].getsex();

            // If elements meet the parameters, add to the sum
            if(element.equals(choice) && dateelement.equals(date) && sexelement.equals(sex)){
                n++;
                sum += array[i].getpopulation();
            }
        }

        // Returns the average to two decimal places
        return Math.round((sum / n) * 100.0) / 100.0;    
    }

    // The methods below calculate the median

    /**
    * Calculates the median population amount according to labour type and year 
    * @param array - the datareader array 
    * @param labour - the labour type 
    * @param date - the date and month 
    * @return the median 
    */
    public static double findMedian(DataReader[] array, String labour, String date){
        
        // Initialize variables 
        String labourelement; 
        String dateelement; 
        DataReader[] sortedarray = new DataReader[60];
        int n; 
        int j = 0; 
        
        // First we sort the array
        sortLow(array);

        // Go through whole array
        for(int i = 0; i < array.length; i++){
            labourelement = array[i].getlabour();	
            dateelement = array[i].getdate().substring(0, 4);

            // If elements meet the parameters, add to the new array
            if(labourelement.equals(labour) && dateelement.equals(date)){
                sortedarray[j] = array[i];
                j++;
            }
        }

        n = sortedarray.length; 
         
        // check for even case
        if (n % 2 != 0)
            return sortedarray[n/2].getpopulation();
        
        return ((sortedarray[(n - 1) / 2].getpopulation()) + (sortedarray[n / 2].getpopulation())) / 2.0;
    }
}
