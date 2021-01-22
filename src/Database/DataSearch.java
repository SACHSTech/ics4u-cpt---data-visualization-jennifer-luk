package Database;

import java.util.*; 
import java.util.ArrayList;

public class DataSearch {

  public static ArrayList<DataReader> provincesearch(DataReader[] array, String choice){
    String element;
    ArrayList<DataReader> temporary = new ArrayList<DataReader>(); 

      for(int i = 0; i < array.length; i++){
        element = array[i].getprovince();				
        if(element.equals(choice)){
            temporary.addAll(Arrays.asList(array[i]));
         }
      }
     
      return temporary; 
  }

  public static ArrayList<DataReader> laboursearch(DataReader[] array, String choice){
    String element;
    ArrayList<DataReader> temporary = new ArrayList<DataReader>();

    for(int i = 0; i < array.length; i++){
      element = array[i].getlabour();				
      if(element.equals(choice)){
          temporary.addAll(Arrays.asList(array[i]));
       }
    }
   
    return temporary; 
   }

  public static ArrayList<DataReader> datesearch(DataReader[] array, String choice){
    String element;
    ArrayList<DataReader> temporary = new ArrayList<DataReader>();

    for(int i = 0; i < array.length; i++){
      element = array[i].getlabour();				
      if(element.equals(choice)){
          temporary.addAll(Arrays.asList(array[i]));
       }
    }
   
    return temporary; 

  }
  public static ArrayList<DataReader> sexsearch(DataReader[] array, String choice){
    String element;
    ArrayList<DataReader> temporary = new ArrayList<DataReader>();

    for(int i = 0; i < array.length; i++){
      element = array[i].getlabour();				
      if(element.equals(choice)){
          temporary.addAll(Arrays.asList(array[i]));
       }
    }
   
    return temporary; 

  }
  public static String IndRecordSearch(DataReader[] array, String date, String name, String labtype, String sex){
  String thename;
  String thedate;
  String thelabtype;
  String thesex;

    for(int i = 0; i < array.length; i++){
        thedate = array[i].getdate();
        thename = array[i].getprovince();		
        thelabtype = array[i].getlabour();	
        thesex = array[i].getsex();
        if(thename.equals(name) && thedate.equals(date) && thelabtype.equals(labtype) && thesex.equals(sex)){
            System.out.println(array[i].toString());
        }
    }
    return "Not a valid data entry";

  }
 
}
