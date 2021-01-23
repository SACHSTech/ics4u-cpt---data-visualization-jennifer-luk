// package Database;
// import javafx.application.Application;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.TableView;
// import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.stage.Stage;

// public class Charts extends Application{

//     public Parent createTable(){
//     final ObservableList<DataReader> data = FXCollections.observableArrayList(
    
//     TableColumn DateCol = new TableColumn();
//     DateCol.setText("Date");
//     DateCol.setCellValueFactory(new PropertyValueFactory("firstName"));
//     TableColumn ProvinceCol = new TableColumn();
//     ProvinceCol.setText("Province");
//     ProvinceCol.setCellValueFactory(new PropertyValueFactory("lastName"));
//     TableColumn LabCol = new TableColumn();
//     LabCol.setText("Labour Type");
//     LabCol.setMinWidth(200);
//     LabCol.setCellValueFactory(new PropertyValueFactory("Population x1000"));
//     final TableView tableView = new TableView();
//     tableView.setItems(data);
//     tableView.getColumns().addAll(DateCol, ProvinceCol, LabCol);
//     return tableView;
// }

// @Override
// public void start(Stage arg0) throws Exception {
//     // TODO Auto-generated method stub

// }
// }
