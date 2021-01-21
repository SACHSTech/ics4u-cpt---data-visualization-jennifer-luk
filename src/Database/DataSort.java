package Database;

import java.util.Arrays;

public class DataSort {
    
    public static DataReader[] sortLow(DataReader[] array){

        int currentlowest;

        for (int i = 0; i < array.length - 1; i++) {
            currentlowest = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j].getpopulation() < array[currentlowest].getpopulation()) {
                    currentlowest = j;
                }
            }

            if (i != currentlowest){
                DataReader temporary = array[currentlowest];
                array[currentlowest] = array[i];
                array[i] = temporary;
            }
        }

        return array;

    }

    public static DataReader[] sortHigh(DataReader[] array){

        int currentlowest;

        for (int i = 0; i < array.length - 1; i++) {
            currentlowest = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j].getpopulation() > array[currentlowest].getpopulation()) {
                    currentlowest = j;
                }
            }

            if (i != currentlowest){
                DataReader temporary = array[currentlowest];
                array[currentlowest] = array[i];
                array[i] = temporary;
            }
        }

        return array;

    }
    public static double AverageLabour(DataReader[] array, String choice){
    String element; 
    int sum = 0; 
    DataReader[] average;
        for(int i = 0; i < array.length; i++){
            element = array[i].getlabour();				
            if(element.equals(choice)){
                average = array[i]; 
            }
        }
        int n = average.length;
        for (int i = 0; i < n; i++) {
            sum += average[i].getpopulation();
        }
        return sum / n;

    }
    

}

