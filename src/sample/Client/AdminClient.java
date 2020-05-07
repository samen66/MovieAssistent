package sample.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.AllResurs.AllEntity;
import sample.Cinema.Cinema;
import sample.LOGIN.Admin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class AdminClient extends Application {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;

    public static Socket socket;



    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("AdminLog.fxml"));
        primaryStage.setTitle("Admin");
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

    public static void addCinema(Cinema cinema){
        AllEntity entity = new AllEntity();
        entity.setCinema(cinema);
        entity.setOperationType("addCinema");
        try{
            outputStream.writeObject(entity);
        } catch (Exception e) {
            e.printStackTrace();
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

    public static Boolean checkAdmin (String log, String pass){
        AllEntity entity = new AllEntity();
        Admin admin = new Admin();
        entity.setOperationType("checkAdmin");
        admin.setLogin(log);
        admin.setPassword(pass);
        entity.setAdmin(admin);
        try{
            outputStream.writeObject(entity);
            if(((boolean) inputStream.readObject())==true){
                return true;
            }
            else return false;
        } catch (IOException ex) {
            ex.printStackTrace();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static ArrayList<Cinema> listCinema(){
        AllEntity entity = new AllEntity();
        entity.setOperationType("listCinema");
        ArrayList<Cinema> cinemaArrayList = new ArrayList<>();
        try{
            outputStream.writeObject(entity);
            if( (entity = (AllEntity) inputStream.readObject())!=null){
                cinemaArrayList = entity.getCinemas();
                return  cinemaArrayList;
            }
            else return null;
        } catch (IOException ex) {
            ex.printStackTrace();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cinemaArrayList;
    }
}




