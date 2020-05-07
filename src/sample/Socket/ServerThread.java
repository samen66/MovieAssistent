package sample.Socket;

import sample.AllResurs.AllEntity;
import sample.Cinema.Cinema;
import sample.Cinema.Movie;
import sample.LOGIN.Admin;
import sample.LOGIN.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Connection connection;
    private java.net.Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;

    

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void run() {
        try {
            AllEntity pd = null;
            while ((pd = (AllEntity) inputStream.readObject()) != null) {
                if (pd.getOperationType().equals("UserRegist")) {
                    try {
                        User user = pd.getUser();
                        registrationAdam(user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
                else if(pd.getOperationType().equals("UserAuthorization")){
                    try {
                        User adam = pd.getUser();
                        String login = adam.getLogin();
                        String password = adam.getPassword();
                        User u = new User();
                        if(authorization(login, password) != null) {
                            u = authorization(login, password);
                            AllEntity pd2 = new AllEntity();
                            pd2.setUser(u);
                            outputStream.writeObject(pd2);


                        }
                        else {
                            u = null;
                            AllEntity pd2 = new AllEntity();
                            pd2.setUser(u);
                            outputStream.writeObject(pd2);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("addMovie")){
                    Movie movie = new Movie();
                    movie = pd.getMovie();
                    addMovie(movie);
                }
                else if(pd.getOperationType().equals("addCinema")){
                    Cinema cinema;
                    cinema = pd.getCinema();
                    addCinema(cinema);

                }
                else if(pd.getOperationType().equals("checkCinema")){
                    Cinema cinema = new Cinema();
                    cinema = pd.getCinema();
                    String log = cinema.getLogin();
                    String pass = cinema.getPass();


                    Cinema c;
                    if( checkCinema(log, pass) != null) {
                        c = checkCinema(log, pass);
                        AllEntity pd2 = new AllEntity();
                        pd2.setCinema(c);
                        outputStream.writeObject(pd2);


                    }
                    else {
                        c = null;
                        AllEntity pd2 = new AllEntity();
                        pd2.setCinema(c);
                        outputStream.writeObject(pd2);
                    }

                }
                else if(pd.getOperationType().equals("checkAdmin")){
                    Admin admin;
                    admin = pd.getAdmin();
                    String log = admin.getLogin();
                    String pass = admin.getPassword();
                    if(  checkAdmin(log, pass) == true){
                        boolean s = true;
                        outputStream.writeObject((boolean)s);
                    }
                    else {
                        boolean s = false;
                        outputStream.writeObject((boolean)s);
                    }



                }
                else if(pd.getOperationType().equals("listCinema")){
                    ArrayList<Cinema> c = new ArrayList<>();
                   // pd.setCinemas(listCinema());
                    if( listCinema() != null) {
                        c = listCinema();
                        AllEntity pd2 = new AllEntity();
                        pd2.setCinemas(c);
                        outputStream.writeObject(pd2);
                    }



                }



        }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Cinema> listCinema() {
        ArrayList<Cinema> cinemaArrayList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *FROM cinema");
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String addres = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String recall = resultSet.getString(5);
                String login = resultSet.getString(6);
                String pass = resultSet.getString(7);
                Cinema cinema = new Cinema(id, name, addres, phone, recall, login, pass);
                cinemaArrayList.add(cinema);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cinemaArrayList;
    }

    private Boolean checkAdmin(String log, String pass) {
        Admin admin = new Admin();
        boolean t = false;
        try{
            Statement getStatement = connection.createStatement();
            ResultSet resultSet = getStatement.executeQuery("SELECT  *from admin");
            while (resultSet.next()) {

                String login = resultSet.getString(5);
                String password = resultSet.getString(6);
                if(log.equals(login) == true && pass.equals(password)==true){
                    t = true;
                    break;
                }
                else t = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(t == true) return true;
        else return false;
    }

    private Cinema checkCinema(String login, String password) {
        Cinema cinema = new Cinema();
        try {

            Statement getStatement = connection.createStatement();
            ResultSet resultSet = getStatement.executeQuery("SELECT  *from cinema");
            while (resultSet.next()) {
                int idBD = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String addres = resultSet.getString(3);
                String nummber = resultSet.getString(4);
                String recall = resultSet.getString(5);
                String log = resultSet.getString(6);
                String pass = resultSet.getString(7);

                // users.add(adam);
                if (login.equals(log) == true && password.equals(pass) == true) {
                    cinema = new Cinema(idBD, name, addres, nummber, recall, log, pass);
                    break;

                }
                else  {
                    cinema = null;
                }

            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        if(cinema != null){
            return  cinema;
        }
        else return null;
    }

    private void addCinema(Cinema cinema) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO cinema(ID, nameCinema, addres, phoneCinema, recall, login, password)"
            + "VALUES (NULL , ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, cinema.getNameOFCinema());
            preparedStatement.setString(2, cinema.getAddres());
            preparedStatement.setString(3, cinema.getPhoneNumber());
            preparedStatement.setString(4, cinema.getRecall());
            preparedStatement.setString(5, cinema.getLogin());
            preparedStatement.setString(6, cinema.getPass());

            preparedStatement.executeUpdate();
            preparedStatement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void addMovie(Movie movie) {
        try{
            PreparedStatement preparedStatement= connection.prepareStatement(
                    "INSERT INTO movie(id, name, ganer, year, age, director, actors, recall )"
                            + "VALUES (NULL , ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getGaner());
            preparedStatement.setString(3, movie.getYearOFIssue());
            preparedStatement.setString(4, movie.getAge());
            preparedStatement.setString(5, movie.getDirector());
            preparedStatement.setString(6, movie.getActors());
            preparedStatement.setString(7, movie.getRecall());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registrationAdam(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO fpost.users(id, name, mail, number , country, login, password)"
                            + "VALUES(NULL  , ? , ? , ? , ? , ?, ? ) ");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getCity());
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setString(6, user.getPassword());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User authorization(String login, String password) throws ClassNotFoundException, SQLException {
        ArrayList<User> users = new ArrayList<>();
        User adam = new User();

        Statement getStatement = connection.createStatement();
        ResultSet resultSet = getStatement.executeQuery("SELECT  *from users");
        while (resultSet.next()) {
            int idBD = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String mail = resultSet.getString(3);
            String nummber = resultSet.getString(4);
            String city = resultSet.getString(5);
            String log = resultSet.getString(6);
            String pass = resultSet.getString(7);

           // users.add(adam);
            if (log.equals(login) == true && pass.equals(password) == true) {
                adam = new User(idBD, name, mail, nummber, city, log, pass);
                break;

            }
            else  {
                adam = null;
            }

        }
        if(adam != null){
            return  adam;
        }
        else return null;
//        for (int i = 0; i <users.size() ; i++) {
//            if (users.get(i).getLogin().compareTo(login) == 0 && users.get(i).getPassword().compareTo(password) == 0) {
//                //User adam = new User(idBD, name, mail, nummber, city, log, pass);
//                User u = new User();
//                u = users.get(i);
//                return u;
//            }
//
//        }
        //return null;
    }
}
