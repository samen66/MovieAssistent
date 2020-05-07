package sample.Windows;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Client.AdminClient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLog {
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
           if(AdminClient.checkAdmin(log, pass)==true){
               ButtnLogin.getScene().getWindow().hide();

               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("/sample/Client/Admin.fxml"));
               try {
                   loader.load();
               } catch (IOException e) {
                   System.out.println(e);
               }

               Parent root = loader.getRoot();
               Stage stage = new Stage();
               stage.setScene(new Scene(root));
               stage.showAndWait();
               TextfiltLogin.setText("");
               TextfiltPass.setText("");
           }
           else {
               TextfiltLogin.setText("login or password incorrect");
           }

       });
    }
}
