package sample.Windows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Client.AdminClient;
import sample.Client.CinemaClient;

public class CinemaLog  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField TextfiltPass;

    @FXML
    private TextField TextfiltLogin;

    @FXML
    private Button ButtnLogin;

    @FXML
    void initialize() {
        ButtnLogin.setOnAction(event -> {
            String log = TextfiltLogin.getText();
            String pass = TextfiltPass.getText();
            System.out.println("GOOD");

            if(CinemaClient.chekCinema(log, pass) != null){
                TextfiltPass.setText("");
                TextfiltLogin.setText("");
                ButtnLogin.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/Client/Cinema.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    System.out.println(e);
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
            else TextfiltLogin.setText("incorrect Login or password");
        });
    }



    }

