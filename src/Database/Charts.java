package Database;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;


public class Charts extends Application {
    
    public static BarChart chart;
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
        chart = new BarChart(xAxis, yAxis, barChartData, 100.0);
        return chart;

    }

}