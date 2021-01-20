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

  public static String laboursearch(DataReader[] array, String choice){
    String element;

      for(int i = 0; i < array.length; i++){
        element = array[i].getlabour();				
        if(element.equals(choice)){
            System.out.println(array[i].toString());
        }
      }
      return " ";
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
