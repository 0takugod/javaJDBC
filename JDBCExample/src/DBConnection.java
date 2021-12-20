import java.sql.*;
public class DBConnection 
{
    Connection con;
    DBConnection()
    {
        try
        {
                        //step1 load the driver class
                        Class.forName("com.mysql.jdbc.Driver");
            
            
            
            
                        //step2 create the connection object
                        String ConnectionURL = "jdbc:mysql://localhost:3306/sectionOPDB";
                        con=DriverManager.getConnection(ConnectionURL,"root","root");
                        
                         System.out.println("Connection Success");
        }
        catch(Exception e)
        {
                          System.out.println("Connection Failed..."+e);
        }
    }
    public static void main(String args[])
    {
        DBConnection obj = new DBConnection();
    }
}