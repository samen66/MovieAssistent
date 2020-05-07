package sample.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.AllResurs.AllEntity;
import sample.LOGIN.User;
import sun.nio.cs.US_ASCII;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class UserClient extends Application {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;

    public static Socket socket;



    @Override
    public void start(Stage primaryStage) throws Exception {
        //sample/LOGIN/signe.fxml
            Parent root = FXMLLoader.load(getClass().getResource("signe.fxml"));
            primaryStage.setTitle("Signe up");
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

    public static void adduser(User user){
        AllEntity pd=new AllEntity();
        pd.setOperationType("UserRegist");
        pd.setUser(user);
        try {
            outputStream.writeObject(pd);
        }
        catch (Exception e){e.printStackTrace();}
    }

    public static User chechAutorization(String login , String password){
        AllEntity pd=new AllEntity();
        User adam = new User();
        adam.setLogin(login);
        adam.setPassword(password);
        pd.setOperationType("UserAuthorization");
        pd.setUser(adam);
        try {
            outputStream.writeObject(pd);
            if((pd = (AllEntity) inputStream.readObject())!=null){
                adam = pd.getUser() ;
                return adam ;
            }
            else return null;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
