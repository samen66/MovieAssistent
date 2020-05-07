package sample.LOGIN;
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
import sample.Client.UserClient;

public class reg  {





        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TextField nameText;

        @FXML
        private Button signeButtn;

        @FXML
        private TextField phoneText;

        @FXML
        private TextField cityText;

        @FXML
        private TextField loginText;

        @FXML
        private TextField reteyText;

        @FXML
        private Button backButton;

        @FXML
        private TextField email;

        @FXML
        private PasswordField passwordText;

        @FXML
        void initialize() {
            signeButtn.setOnAction(event -> {
                String name = nameText.getText();
                String mail = email.getText();
                String phone = phoneText.getText();
                String country = cityText.getText();
                String login = loginText.getText();
                String pass = passwordText.getText();
                String repass = reteyText.getText();
                User use = new User(100, name, mail, phone, country, login, pass);
                int check = 100;
                if(repass.equals(pass) == true && name.equals("")==false && mail.equals("") == false && phone.equals("")==false && country.equals("")==false && login.equals("") == false && pass.equals("")==false) {
                        User user = UserClient.chechAutorization(login, pass);
                        if(user == null){
                            UserClient.adduser(use);
                            nameText.setText("");
                            email.setText("");
                            phoneText.setText("");
                            cityText.setText("");
                            loginText.setText("");
                            passwordText.setText("");
                            reteyText.setText("");

                        }
                        else loginText.setText("login has already used ");
                    }
                else passwordText.setText("password is not equal");



            });

            backButton.setOnAction(event -> {
               // backButton.getScene().getWindow().hide();
                backButton.getScene().getWindow().getOnHidden();


                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/Client/signe.fxml"));
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
