package sample.Cinema;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class Cinema implements Serializable {


    private Integer id;
    private String nameOFCinema;
    private String addres;
    private String phoneNumber;
    private String recall;
   private String login;
   private String pass;
    ArrayList<Movie> movies = new ArrayList<>();

    public Cinema(Integer id, String nameOFCinema, String addres, String phoneNumber, String recall, String login, String pass) {
        this.id = id;
        this.nameOFCinema = nameOFCinema;
        this.addres = addres;
        this.phoneNumber = phoneNumber;
        this.recall = recall;
        this.login = login;
        this.pass = pass;
    }

    public Cinema() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOFCinema() {
        return nameOFCinema;
    }

    public void setNameOFCinema(String nameOFCinema) {
        this.nameOFCinema = nameOFCinema;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRecall() {
        return recall;
    }

    public void setRecall(String recall) {
        this.recall = recall;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

//    public Cinema(IntegerProperty id, StringProperty nameOFCinema, StringProperty addres, StringProperty phoneNumber, StringProperty recall, StringProperty login, StringProperty pass) {
//        this.id = id;
//        this.nameOFCinema = nameOFCinema;
//        this.addres = addres;
//        this.phoneNumber = phoneNumber;
//        this.recall = recall;
//        this.login = login;
//        this.pass = pass;
//    }
//
//    public Cinema() {
//    }
//
//    public int getId() {
//        return id.get();
//    }
//
//    public IntegerProperty idProperty() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id.set(id);
//    }
//
//    public String getNameOFCinema() {
//        return nameOFCinema.get();
//    }
//
//    public StringProperty nameOFCinemaProperty() {
//        return nameOFCinema;
//    }
//
//    public void setNameOFCinema(String nameOFCinema) {
//        this.nameOFCinema.set(nameOFCinema);
//    }
//
//    public String getAddres() {
//        return addres.get();
//    }
//
//    public StringProperty addresProperty() {
//        return addres;
//    }
//
//    public void setAddres(String addres) {
//        this.addres.set(addres);
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber.get();
//    }
//
//    public StringProperty phoneNumberProperty() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber.set(phoneNumber);
//    }
//
//    public String getRecall() {
//        return recall.get();
//    }
//
//    public StringProperty recallProperty() {
//        return recall;
//    }
//
//    public void setRecall(String recall) {
//        this.recall.set(recall);
//    }
//
//    public String getLogin() {
//        return login.get();
//    }
//
//    public StringProperty loginProperty() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login.set(login);
//    }
//
//    public String getPass() {
//        return pass.get();
//    }
//
//    public StringProperty passProperty() {
//        return pass;
//    }
//
//    public void setPass(String pass) {
//        this.pass.set(pass);
//    }
}
