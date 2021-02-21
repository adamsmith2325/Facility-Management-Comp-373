package DataAccess;
import java.sql.*;
import java.util.stream.IntStream;  


public class FacilityDAO {
    

    public static Integer getFacilityID(String Name){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facilitymanagementsystem","root","root");  
            Statement stmt=con.createStatement();  
            
            String query = "select * from facilities where Name = " + "'" + Name + "'";
            
            ResultSet rs=stmt.executeQuery(query);  
            Integer facilityID = null;
            while(rs.next())  
                facilityID = rs.getInt(1);  
            con.close();   
            return facilityID;

        }catch(Exception e){ 
            System.out.println(e);
            return 999;
            }  
        }

    


        public static String getFacilityName(Integer Id){
            try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facilitymanagementsystem","root","root");  
                Statement stmt=con.createStatement();  
                
                String query = "select * from facilities where idFacilities = " + Id;
                
                ResultSet rs=stmt.executeQuery(query);  
                String facilityName = null;
                while(rs.next())  
                    facilityName = rs.getString(2);  
                con.close();   
                return facilityName;
    
            }catch(Exception e){ 
                System.out.println(e);
                return e.toString();
                }  
            }



        public static void main(String args[]){
            System.out.println(getFacilityID("Test 2"));
            System.out.println(getFacilityName(3));
        }

    }

    