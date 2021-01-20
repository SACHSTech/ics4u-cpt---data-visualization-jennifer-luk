package Database;

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
    

}

