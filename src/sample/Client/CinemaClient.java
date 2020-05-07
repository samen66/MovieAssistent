package sample.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.AllResurs.AllEntity;
import sample.Cinema.Cinema;
import sample.Cinema.Movie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CinemaClient extends Application {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;

    public static Socket socket;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/Cinema/CinemaLog.fxml"));
        primaryStage.setTitle("Cinema");
        primaryStage.setScene(new Scene(root, 700, 500));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        connectToServer();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public static void connectToServer() {
        try {
            socket = new Socket("127.0.0.1", 1605);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream((socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addMovie(Movie movie){
        AllEntity entity = new AllEntity();
        entity.setMovie(movie);
        entity.setOperationType("addMovie");
        try{
            outputStream.writeObject(entity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static Cinema chekCinema(String log, String pass){
        AllEntity entity = new AllEntity();
        Cinema cinema = new Cinema();
        entity.setOperationType("checkCinema");
        cinema.setLogin(log);
        cinema.setPass(pass);
        entity.setCinema(cinema);
        try{
            outputStream.writeObject(entity);
            if((entity = (AllEntity) inputStream.readObject())!=null){
                cinema = entity.getCinema() ;
                return cinema ;
            }
            else return null;
        } catch (IOException ex) {
            ex.printStackTrace();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
