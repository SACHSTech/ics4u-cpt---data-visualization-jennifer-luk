package Database;

// Import statement
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableData {

    // Initialize instance variables
    private StringProperty thedate;
    private StringProperty theprovince;
    private StringProperty thelabour;
    private StringProperty thesex;
    private StringProperty thepopulation;

    /**
    * Constructor - creates a new data instance for the tableview
    * @param date - the date and month 
    * @param province - the province name 
    * @param labour - the labour type 
    * @param sex - the sex
    * @param population - the population 
    */
    public TableData(String date, String province, String labour, String sex, String population) {
        this.thedate = new SimpleStringProperty(date);
        this.theprovince = new SimpleStringProperty(province);
        this.thelabour = new SimpleStringProperty(labour);
        this.thesex = new SimpleStringProperty(sex);
        this.thepopulation = new SimpleStringProperty(population);
	}

    /**
    * Getter method for date property 
    * @return the date
    */
    public StringProperty thedateProperty() {
        return thedate;
    }
    
    /**
    * Getter method for province name property 
    * @return province name
    */
    public StringProperty theprovinceProperty() {
        return theprovince;
    }
    
    /**
    * Getter method for labour type property
    * @return labour type 
    */
    public StringProperty thelabourProperty() {
        return thelabour;
    }

    /**
    * Getter method for the sex property 
    * @return the sex
    */
    public StringProperty thesexProperty() {
        return thesex;
    }

    /**
    * Getter method for population count property
    * @return population count
    */
    public StringProperty thepopulationProperty() {
        return thepopulation;
    }
}
