package Database;

import java.io.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;



public class Charts extends Application {
    
    public static BarChart barchart;
    public static CategoryAxis xAxis;
    public static NumberAxis yAxis;

    public static Parent theBarChart(double EM1901, double EM1905, double EM1909, double UN1901, double UN1905, double UN1909, double EM2001, double EM2005, double EM2009, double UN2001, double UN2005, double UN2009) {

        String[] dates = { "2019-01", "2019-05", "2019-09", "2020-01", "2020-05", "2020-09" };
        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(dates));
        yAxis = new NumberAxis("Population x1,000", 0.0, 1000.0, 50.0);
       
        ObservableList<BarChart.Series> barChartData =
            FXCollections.observableArrayList(
                new BarChart.Series("Employment",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(dates[0], EM1901),
                    new BarChart.Data(dates[1], EM1905),
                    new BarChart.Data(dates[2], EM1909),
                    new BarChart.Data(dates[3], EM2001),
                    new BarChart.Data(dates[4], EM2005),
                    new BarChart.Data(dates[5], EM2009))),
                new BarChart.Series("Unemployment",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(dates[0], UN1901),
                    new BarChart.Data(dates[1], UN1905),
                    new BarChart.Data(dates[2], UN1909),
                    new BarChart.Data(dates[3], UN2001),
                    new BarChart.Data(dates[4], UN2005),
                    new BarChart.Data(dates[5], UN2009)))
            );
        barchart = new BarChart(xAxis, yAxis, barChartData, 100.0);
        return barchart;

    }
    public static Parent theTable() throws IOException{
        String date;
            String province;
            String labour;
            String sex;
            String population; 
            String line = "";

        
            TableData data; 
            int count = 0; 
            TableData[] table = new TableData[480];
    
            BufferedReader file = new BufferedReader(new FileReader("src/Database/DataSet.csv"));      

            while(count < 480){
                try {
					line = file.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                String[] element = line.split(",");

                date = element[0];
                province = element[1];
                labour = element[2];
                sex = element[3];
                population =  element[4];
                
                data = new TableData(date, province, labour, sex, population);
                
                table[count] = data;

                count++; 
            }
            file.close();
    
        final ObservableList<TableData> tableview = FXCollections.observableArrayList(table);
        
        TableColumn datecol = new TableColumn();
        datecol.setText("Date");
        datecol.setCellValueFactory(new PropertyValueFactory("thedate"));

        TableColumn provincecol = new TableColumn();
        provincecol.setText("Province");
        provincecol.setCellValueFactory(new PropertyValueFactory("theprovince"));

        TableColumn labourcol = new TableColumn();
        labourcol.setText("Labour Type");
        labourcol.setCellValueFactory(new PropertyValueFactory("thelabour"));

        TableColumn sexcol = new TableColumn();
        sexcol.setText("Sex");
        sexcol.setCellValueFactory(new PropertyValueFactory("thesex"));

        TableColumn populationcol = new TableColumn();
        populationcol.setText("Population x1,000");
        populationcol.setCellValueFactory(new PropertyValueFactory("thepopulation"));
        
        final TableView tableView = new TableView();
        tableView.setItems(tableview);
        tableView.getColumns().addAll(datecol, provincecol, labourcol, sexcol, populationcol);
        return tableView;
    }

    public static final String[] CATEGORIES = { "2019-01", "2019-05", "2019-09", "2020-01", "2020-05", "2020-09"};
    public static LineChart<String, Number> linechart;
    public static CategoryAxis xAxis2;
    public static NumberAxis yAxis2;

    public static Parent theLineChart(double EMM1901, double EMM1905, double EMM1909, double EMM2001, double EMM2005, double EMM2009, double EMF1901, double EMF1905, double EMF1909, double EMF2001, double EMF2005, double EMF2009, 
                                    double UNM1901, double UNM1905, double UNM1909, double UNM2001, double UNM2005, double UNM2009, double UNF1901, double UNF1905, double UNF1909, double UNF2001, double UNF2005, double UNF2009){
        xAxis2 = new CategoryAxis();
        yAxis2 = new NumberAxis("Population x1,000", 0.0, 1200.00, 100.00);
        linechart = new LineChart<>(xAxis2, yAxis2);
        
        // setup chart
        linechart.setTitle("Average Unemployment VS Employment");
        xAxis2.setLabel("Date");
        yAxis2.setLabel("Population x1,000");
        
        // add data
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Employed Males");
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[0], EMM1901));
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[1], EMM1905));
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[2], EMM1909));
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[3], EMM2001));
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[4], EMM2005));
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[5], EMM2009));
        linechart.getData().add(series);
        
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Employed Females");
        series2.getData().add(new XYChart.Data<String, Number>(CATEGORIES[0], EMF1901));
        series2.getData().add(new XYChart.Data<String, Number>(CATEGORIES[1], EMF1905));
        series2.getData().add(new XYChart.Data<String, Number>(CATEGORIES[2], EMF1909));
        series2.getData().add(new XYChart.Data<String, Number>(CATEGORIES[3], EMF2001));
        series2.getData().add(new XYChart.Data<String, Number>(CATEGORIES[4], EMF2005));
        series2.getData().add(new XYChart.Data<String, Number>(CATEGORIES[5], EMF2009));
        linechart.getData().add(series2);

        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("Unemployed Males");
        series3.getData().add(new XYChart.Data<String, Number>(CATEGORIES[0], UNM1901));
        series3.getData().add(new XYChart.Data<String, Number>(CATEGORIES[1], UNM1905));
        series3.getData().add(new XYChart.Data<String, Number>(CATEGORIES[2], UNM1909));
        series3.getData().add(new XYChart.Data<String, Number>(CATEGORIES[3], UNM2001));
        series3.getData().add(new XYChart.Data<String, Number>(CATEGORIES[4], UNM2005));
        series3.getData().add(new XYChart.Data<String, Number>(CATEGORIES[5], UNM2009));
        linechart.getData().add(series3);

        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        series4.setName("Unemployed Males");
        series4.getData().add(new XYChart.Data<String, Number>(CATEGORIES[0], UNF1901));
        series4.getData().add(new XYChart.Data<String, Number>(CATEGORIES[1], UNF1905));
        series4.getData().add(new XYChart.Data<String, Number>(CATEGORIES[2], UNF1909));
        series4.getData().add(new XYChart.Data<String, Number>(CATEGORIES[3], UNF2001));
        series4.getData().add(new XYChart.Data<String, Number>(CATEGORIES[4], UNF2005));
        series4.getData().add(new XYChart.Data<String, Number>(CATEGORIES[5], UNF2009));
        linechart.getData().add(series4);
        return linechart;
    }
    
}