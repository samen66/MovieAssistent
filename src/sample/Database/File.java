package sample.Database;

import java.io.*;
import java.util.ArrayList;

public class File {


    String driver;
    String dbname;
    String port;
    String hostname;
    String user;
    String password;

    public File() {
    }

    public File(String driver, String dbname, String port, String hostname, String user, String password) {
        this.driver = driver;
        this.dbname = dbname;
        this.port = port;
        this.hostname = hostname;
        this.user = user;
        this.password = password;

    }


    public  void FileWrite() throws IOException {

    String Driver = "com.mysql.jdbc.Driver";
    String DBname = "MovieAss";
    String Port = "3306";
    String HOST = "jdbc:mysql://localhost:";
    String USER = "root";
    String PASSWORD = "";
    ArrayList<String> filWrite = new ArrayList<>();
    filWrite.add(Driver);
     filWrite.add(DBname);
     filWrite.add(Port);
     filWrite.add(HOST);
     filWrite.add(USER);
     filWrite.add(PASSWORD);

   try{
         BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
         String s = "";
         for (int i = 0; i< filWrite.size();i++) {
             s+=filWrite.get(i)+"\n";
         }
         writer.write(s);
         writer.close();

     } catch (IOException e) {
         e.printStackTrace();
     }

 }


    public  File FileRead(File f){

        ArrayList<String> data = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String s = "";

            while((s = reader.readLine())!= null){
                data.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = data.get(0);
        String dbname = data.get(1);
        String port= data.get(2);
        String hostname= data.get(3);
        String user= data.get(4);
        String password= data.get(5);

        File file = new File(driver, dbname, port, hostname, user, password);
        return file;

    }
}


