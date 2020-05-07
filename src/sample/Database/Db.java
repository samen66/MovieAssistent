package sample.Database;

import sample.LOGIN.User;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Db {
    public static Connection connection;
     public   Connection getConnection() throws ClassNotFoundException, SQLException {
        File file = new File();
        try {
            file.FileWrite();
            file = file.FileRead(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class.forName(file.driver);
        String url = file.hostname + file.port+"/"+file.dbname;
        connection = DriverManager.getConnection(url, file.user, file.password);
        return  connection;
    }
    public void addUser(User users)throws ClassNotFoundException, SQLException{
        User u = new User();
        getConnection();


        String qeary = "INSERT INTO USERS(ID, name, mail, nummber, country, login, password) VALUES(NULL, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement =  connection.prepareStatement(qeary);
            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getEmail());
            preparedStatement.setString(3, users.getPhone());
            preparedStatement.setString(4, users.getCity());
            preparedStatement.setString(5, users.getLogin());
            preparedStatement.setString(6, users.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }


    }
    public Integer getUser(String login, String password) throws ClassNotFoundException, SQLException {
        getConnection();


        HashMap<String, String> hashMap = new HashMap<String, String>();
        try {
            Statement statement = connection.createStatement();
            String quary = "select *from users";
            ResultSet resultSet = statement.executeQuery(quary);
            while (resultSet.next()){
                String loginUser = resultSet.getString(6);
                String passwUser = resultSet.getString(7);
                hashMap.put(loginUser, passwUser);

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        HashMap<String, String> MapAdmin = new HashMap<String, String>();
        try{
            Statement statement = connection.createStatement();
            String quatyAdmin = "select *from Admin";
            ResultSet resultSet = statement.executeQuery(quatyAdmin);
            while(resultSet.next()){
                String loginAdmin = resultSet.getString(5);
                String passwAdmin = resultSet.getString(6);
                MapAdmin.put(loginAdmin, passwAdmin);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        if(hashMap.containsKey(login) == true && MapAdmin.containsKey(login) == false){
            if(hashMap.get(login).equals(password)){
                return 1;
            }
            else return 3;
        }
        else if(hashMap.containsKey(login) == false && MapAdmin.containsKey(login) == true){
            if(MapAdmin.get(login).equals(password)){
                return 2;
            }
            else return 4;
        }
        else return 0;

    }
}
