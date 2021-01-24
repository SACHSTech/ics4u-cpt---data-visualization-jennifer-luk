package Database;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableData {

    private StringProperty thedate;
    private StringProperty theprovince;
    private StringProperty thelabour;
    private StringProperty thesex;
    private StringProperty thepopulation;

 
    public TableData(String date, String province, String labour, String sex, String population) {
        this.thedate = new SimpleStringProperty(date);
        this.theprovince = new SimpleStringProperty(province);
        this.thelabour = new SimpleStringProperty(labour);
        this.thesex = new SimpleStringProperty(sex);
        this.thepopulation = new SimpleStringProperty(population);
	}

    public StringProperty thedateProperty() {
        return thedate;
    }
 
    public StringProperty theprovinceProperty() {
        return theprovince;
    }
 
    public StringProperty thelabourProperty() {
        return thelabour;
    }

    public StringProperty thesexProperty() {
        return thesex;
    }

    public StringProperty thepopulationProperty() {
        return thepopulation;
    }
}
