package Database;

public class DataReader {
    private String date; 
    private String province; 
    private String labour; 
    private String sex; 
    private String population;

    public DataReader (String date, String province, String labour, String sex, String population){
        this.date = date; 
        this.province = province; 
        this.labour = labour; 
        this.sex = sex;
        this.population = population; 
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

    public String population() {
        return population;
    }

}
