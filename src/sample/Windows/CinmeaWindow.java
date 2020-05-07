package sample.Windows;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Cinema.Movie;
import sample.Client.CinemaClient;

public class CinmeaWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button signeButtn;

    @FXML
    private TextField reccallText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField yearText;

    @FXML
    private TextField ageText;

    @FXML
    private TextField directorText;

    @FXML
    private TextField ganerText;

    @FXML
    private PasswordField actorText;

    @FXML
    void initialize() {
        signeButtn.setOnAction(event -> {
            if(nameText.equals(null)==false){
                String nameOgMovie = nameText.getText();
                String ganer = ganerText.getText();
                String yearOfIssue = yearText.getText();
                String age = ageText.getText();
                String director = directorText.getText();
                String actors = actorText.getText();
                String recall = reccallText.getText();
                Movie movie = new Movie(100, nameOgMovie, ganer, yearOfIssue, age, director, actors, recall );
                CinemaClient.addMovie(movie);
            }

        });

}
}
