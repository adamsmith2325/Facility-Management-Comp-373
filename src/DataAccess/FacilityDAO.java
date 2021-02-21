package DataAccess;
import java.sql.*;  


public class FacilityDAO {
    

    public static String getFacilityID(String Name){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facilitymanagementsystem","root","root");  
            Statement stmt=con.createStatement();  
            
            String query = "select * from facilities where Name = " + "'" + Name + "'";
            
            ResultSet rs=stmt.executeQuery(query);  
            String facilityID = null;
            while(rs.next())  
                facilityID = rs.getString(1);  
            con.close();   
            return facilityID;

        }catch(Exception e){ 
            System.out.println(e);
            return e.toString();
            }  
        }




        public static void main(String args[]){
            System.out.println(getFacilityID("Test 2"));
        }

    }

    