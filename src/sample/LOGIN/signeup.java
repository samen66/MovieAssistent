package sample.LOGIN;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Client.UserClient;
import sample.Database.Db;

public class signeup {


        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private PasswordField TextfiltPass;

        @FXML
        private Button ButtnRegistr;

        @FXML
        private TextField TextfiltLogin;

        @FXML
        private Button ButtnLogin;

        @FXML
        void initialize() {
            ButtnLogin.setOnAction(event -> {
                String log = TextfiltLogin.getText().trim();
                String pas = TextfiltPass.getText().trim();
                User user = UserClient.chechAutorization(log, pas);

                if(user != null){
                    System.out.println("PPPPPPPPPPp");
                    ButtnLogin.getScene().getWindow().hide();

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/home/Home.fxml"));
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
                else if(user == null) TextfiltLogin.setText("your login or pass incorrect");


            });
            ButtnRegistr.setOnAction(event -> {

                //windowContral.signeup.setVisible(false);
                ButtnRegistr.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/LOGIN/registr.fxml"));
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
