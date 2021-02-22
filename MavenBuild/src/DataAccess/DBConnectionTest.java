package DataAccess;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;  

Dotenv dotenv = Dotenv.load();
String DATABASE_USERNAME = dotenv.get(“DATABASE_USERNAME”);


public class DBConnectionTest {
    public static void main(String args[]){  
        try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facilitymanagementsystem", System.getenv("DATABASE_USERNAME"), System.getenv("DATABASE_PASSWORD"));  
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from facilities");  
        while(rs.next())  
        System.out.println(rs.getInt(1) + " - " + rs.getString(2));  
        con.close();  
        }catch(Exception e){ System.out.println(e);}  
        }  
}