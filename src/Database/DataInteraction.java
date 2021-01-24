package Database;

import java.util.ArrayList;

public class DataInteraction {

  public static ArrayList<DataReader> provincesearch(DataReader[] array, String choice){
    String element;
    ArrayList<DataReader> temporary = new ArrayList<DataReader>(); 

      for(int i = 0; i < array.length; i++){
        element = array[i].getprovince();				
        if(element.equals(choice)){
            temporary.add(array[i]);
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
          temporary.add(array[i]);
       }
    }
   
    return temporary; 
   }

  public static ArrayList<DataReader> datesearch(DataReader[] array, String choice){
    String element;
    ArrayList<DataReader> temporary = new ArrayList<DataReader>();

    for(int i = 0; i < array.length; i++){
      element = array[i].getdate();				
      if(element.equals(choice)){
          temporary.add(array[i]);
       }
    }
   
    return temporary; 

  }
  public static ArrayList<DataReader> sexsearch(DataReader[] array, String choice){
    String element;
    ArrayList<DataReader> temporary = new ArrayList<DataReader>();

    for(int i = 0; i < array.length; i++){
      element = array[i].getsex();				
      if(element.equals(choice)){
          temporary.add(array[i]);
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
public static double AverageLabour(DataReader[] array, String choice, String date) {
    String element; 
    String dateelement; 
    double sum = 0; 
    int n = 0;
    for (int i = 0; i < array.length; i++) {
        element = array[i].getlabour();	
        dateelement = array[i].getdate().substring(0, 4);
        if (element.equals(choice) && dateelement.equals(date)) {
            n++;
            sum += array[i].getpopulation();
        }                              
    }

    return Math.round((sum / n) * 100.0) / 100.0;    

}
public static double AverageLabourSex(DataReader[] array, String choice, String date, String sex){
    String element; 
    String dateelement; 
    String sexelement;
    double sum = 0; 
    int n = 0;
    for(int i = 0; i < array.length; i++){
        element = array[i].getlabour();	
        dateelement = array[i].getdate().substring(0, 4);
        sexelement = array[i].getsex();
        if(element.equals(choice) && dateelement.equals(date) && sexelement.equals(sex)){
            n++;
            sum += array[i].getpopulation();
        }
    }
    return Math.round((sum / n) * 100.0) / 100.0;    

}
public static double largest(DataReader[] array, String choice, String date){
    String element; 
    String dateelement; 
    double currentmax = 0;

    for(int i = 0; i < array.length; i++){
        element = array[i].getlabour();	
        dateelement = array[i].getdate().substring(0, 4);
        
        if(element.equals(choice) && dateelement.equals(date)){ 
            if (array[i].getpopulation() > currentmax) {
                currentmax = array[i].getpopulation();
            }             
        }
    }
        return currentmax;  
}
public static double smallest(DataReader[] array, String choice, String date){
    String element; 
    String dateelement; 
    double currentmin = 0;

    for(int i = 0; i < array.length; i++){
        element = array[i].getlabour();	
        dateelement = array[i].getdate().substring(0, 4);
        
        if(element.equals(choice) && dateelement.equals(date)){ 
            if (i == 1){
                currentmin = array[i].getpopulation();
            }
            else if (array[i].getpopulation() < currentmin) {
                currentmin = array[i].getpopulation();
            }             
        }
    }
    return currentmin;  
}

 
public static double AverageLabourProv(DataReader[] array, String province, String labourtype, String date){
    String prov; 
    String element; 
    String dateelement; 
    int n = 0;
    double sum = 0;
    
    for(int i = 0; i < array.length; i++){
        prov = array[i].getprovince();
        element = array[i].getlabour();	
        dateelement = array[i].getdate();
        
        if(prov.equals(province) && element.equals(labourtype) && dateelement.equals(date)){ 
            n++; 
            sum += array[i].getpopulation();          
        }
    }
    return Math.round((sum / n) * 100.0) / 100.0;      
}

public static double AverageByDate(DataReader[] array, String labourtype, String date){
    String element; 
    String dateelement; 
   
    double sum = 0; 
    int n = 0;
    for(int i = 0; i < array.length; i++){
        element = array[i].getlabour();	
        dateelement = array[i].getdate();
        if(element.equals(labourtype) && dateelement.equals(date)){
            n++;
            sum += array[i].getpopulation();
        }
    }
    return Math.round((sum / n) * 100.0) / 100.0;    

}
 
}