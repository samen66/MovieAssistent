package sample.Windows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Cinema.Cinema;
import sample.Client.AdminClient;
import sample.LOGIN.Admin;

public class AdminWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button signeButtn;

    @FXML
    private TextField nameText;

    @FXML
    private TextField phoneText;

    @FXML
    private TextField reccallText;

    @FXML
    private TextField loginText;

    @FXML
    private TextField addresText;

    @FXML
    private PasswordField passwordText;



    @FXML
    void initialize() {
        if(nameText.equals(null) == false)
        signeButtn.setOnAction(event -> {
            String nameCinema = nameText.getText();
            String addres = addresText.getText();
            String phoneNummber = phoneText.getText();
            String recall = reccallText.getText();
            String login = loginText.getText();
            String pass = passwordText.getText();
            Cinema cinemas = new Cinema();
            cinemas = AdminClient.chekCinema(login, pass);
            if(cinemas == null) {
                Cinema cinema = new Cinema(100, nameCinema, addres, phoneNummber, recall, login, pass);
                AdminClient.addCinema(cinema);
                nameText.setText("");
                addresText.setText("");
                phoneText.setText("");
                reccallText.setText("");
                loginText.setText("");
                passwordText.setText("");


            }
            else {
                loginText.setText("Login alredy used");
            }
        });
        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().getOnHidden();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Client/AdminShowAllSinema.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                System.out.println(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });


    }
}

