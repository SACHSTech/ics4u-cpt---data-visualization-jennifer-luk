package Database;

public class DataReader {

    // Initialize instance variables
    private String date; 
    private String province; 
    private String labour; 
    private String sex; 
    private double population;

    /**
    * Constructor - creates a new data instance
    * @param date - the date and month 
    * @param province - the province name 
    * @param labour - the labour type 
    * @param sex - the sex
    * @param pop - the population 
    */
    public DataReader (String date, String province, String labour, String sex, double pop){
        this.date = date; 
        this.province = province; 
        this.labour = labour; 
        this.sex = sex;
        this.population = pop; 
    }

    /**
    * Getter method for date
    * @return the date
    */
    public String getdate() {
        return date;
    }

    /**
    * Getter method for province name
    * @return province name
    */
    public String getprovince() {
        return province;
    }

    /**
    * Getter method for labour type 
    * @return labour type 
    */
    public String getlabour() {
        return labour;
    }

    /**
    * Getter method for the sex
    * @return the sex
    */
    public String getsex() {
        return sex;
    }

    /**
    * Getter method for population count 
    * @return population count
    */
    public double getpopulation() {
        return population;
    }
    
    /**
    * String representation of a set of data 
    * @return all the attributes related to one set of data 
    */
    public String toString() {
        
        return date + "      " + (province + "                               ").substring(0,27) + (labour + "                                   ").substring(0,24) + (sex + "                                   ").substring(0,12) + population;
      }
}
