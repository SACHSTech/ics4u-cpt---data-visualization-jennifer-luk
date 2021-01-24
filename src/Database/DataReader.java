package Database;

public class DataReader {
    private String date; 
    private String province; 
    private String labour; 
    private String sex; 
    private double population;

    public DataReader (String date, String province, String labour, String sex, double pop){
        this.date = date; 
        this.province = province; 
        this.labour = labour; 
        this.sex = sex;
        this.population = pop; 
    }
    public String getdate() {
        return date;
    }

    public String getprovince() {
        return province;
    }

    public String getlabour() {
        return labour;
    }

    public String getsex() {
        return sex;
    }

    public double getpopulation() {
        return population;
    }

    public String toString() {
        
        return date + "      " + (province + "                               ").substring(0,27) + (labour + "                                   ").substring(0,24) + (sex + "                                   ").substring(0,12) + population;
      }
}
