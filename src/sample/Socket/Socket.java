package sample.Socket;

import sample.Database.Db;

import java.net.ServerSocket;
import java.sql.Connection;

public class Socket {
    public  static Connection connection;
    public static void main(String[] args) {
        try{
            Db data  = new Db();
            connection = data.getConnection();
            ServerSocket ss = new ServerSocket(1605);
            while(true){
                System.out.println("waiting for client");
                java.net.Socket socket = ss.accept();
                System.out.println("new client connected");

                ServerThread sth = new ServerThread(socket,connection);
                sth.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}

