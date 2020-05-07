package sample.Windows;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Cinema.Cinema;
import sample.Client.AdminClient;

public class AdminShowAllCinema {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Cinema> Table_Cinema;

    @FXML
    private TableColumn<Cinema, Integer> id_table;

    @FXML
    private TableColumn<Cinema, String> name_table;

    @FXML
    private TableColumn<Cinema, String> addres_table;

    @FXML
    private TableColumn<Cinema, String> phone_table;

    @FXML
    private TableColumn<Cinema, String> recall_table;

    @FXML
    private TableColumn<Cinema, String> login_table;

    @FXML
    private TableColumn<Cinema, String> password_table;

    @FXML
    private Button  updata;;

    private ObservableList<Cinema> data;

    @FXML
   void initialize() {
      System.out.println("GOOOD");
      updata.setOnAction(event -> {
          UdateData(event);
      });

      }

//samenuatkhan


    @FXML
    void UdateData(javafx.event.ActionEvent event) {
        System.out.println("GOOOD");


            data = FXCollections.observableArrayList();
            ArrayList<Cinema> cinemaArrayList = new ArrayList<>();
            cinemaArrayList=AdminClient.listCinema();
            Cinema cinema = new Cinema();
            for (int i = 0; i <cinemaArrayList.size() ; i++) {
                cinema = cinemaArrayList.get(i);
                data.add(cinema);
            }
            id_table.setCellValueFactory(new PropertyValueFactory<>("id"));
            name_table.setCellValueFactory(new PropertyValueFactory<>("nameOFCinema"));
            addres_table.setCellValueFactory(new PropertyValueFactory<>("addres"));
            phone_table.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
            recall_table.setCellValueFactory(new PropertyValueFactory<>("recall"));
            login_table.setCellValueFactory(new PropertyValueFactory<>("login"));
            password_table.setCellValueFactory(new PropertyValueFactory<>("pass"));

            Table_Cinema.setItems(null);
            Table_Cinema.setItems(data);



    }

//    @FXML
//    void initialize() {
//        System.out.println("GOOOD");
//        updata.setOnAction(event -> {
//
//            data = FXCollections.observableArrayList();
//            ArrayList<Cinema> cinemaArrayList = new ArrayList<>();
//            cinemaArrayList=AdminClient.listCinema();
//            Cinema cinema = new Cinema();
//            for (int i = 0; i <cinemaArrayList.size() ; i++) {
//                cinema = cinemaArrayList.get(i);
//                data.add(cinema);
//            }
//            id_table.setCellValueFactory(new PropertyValueFactory<>("id"));
//            name_table.setCellValueFactory(new PropertyValueFactory<>("nameOFCinema"));
//            addres_table.setCellValueFactory(new PropertyValueFactory<>("addres"));
//            phone_table.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
//            recall_table.setCellValueFactory(new PropertyValueFactory<>("recall"));
//            login_table.setCellValueFactory(new PropertyValueFactory<>("login"));
//            password_table.setCellValueFactory(new PropertyValueFactory<>("pass"));
//
//            Table_Cinema.setItems(null);
//            Table_Cinema.setItems(data);
//
//
//        });
//
//    }
//
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
}
