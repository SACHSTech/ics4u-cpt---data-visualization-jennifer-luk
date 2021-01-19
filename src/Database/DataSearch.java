package Database;

public class DataSearch {

    public static String provincesearch(DataReader[] array, String choice){
        String element;
  
          for(int i = 0; i < array.length; i++){
            element = array[i].getprovince();				
            if(element.equals(choice)){
                System.out.println(array[i].toString());
            }
          }
          return " ";
  
      }
  
}
