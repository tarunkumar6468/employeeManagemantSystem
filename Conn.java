import static java.lang.Class.forName;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public  Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");                                                                    // database se connect karne ke liye important h next line;

            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root", "passwordpassword");// to open the mysql workbanch and create the database and show database ->

            // and  after that we right click on the project file that is Employeemanagementsystem and show the optimal maodule and click shoe the libraries and click and show java file and click and upe
            // conner to show the + plus sign and click and we go for Downloads and find the mysql server jar folder and link of jar folder is
            // https://drive.google.com/drive/folder...

             s = c.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
