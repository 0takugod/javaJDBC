import java.util.Scanner;
import java.sql.*;
public class Operation extends DBConnection
{
    void insert()
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Student ID");
            int id=sc.nextInt();
            
            System.out.println("Enter Student Name");
            String name=sc.next();
            
            System.out.println("Enter Student age");
            int age=sc.nextInt();
            
            System.out.println("Enter Student Course");
            String course=sc.next();
            
            String insertquery="insert into student values(?,?,?,?);";
            PreparedStatement pst=con.prepareStatement(insertquery);
            
            pst.setInt(1,id);
            pst.setString(2,name);
            pst.setInt(3,age);
            pst.setString(4,course);
            
            pst.executeUpdate();
            System.out.println("data inserted.....");
        }
        catch(Exception e)
        {
            System.out.println("");
        }
    }
    void delete()
    {
        try
        {
            //delting using the id:-
            //int studentid=03;
            //String delquery=("delete from student where sid="+studentid);
            //deleting using the sname:-
            String studentname="shobhit";
            String delquery=("delete from student where sname='"+studentname+"'");
            PreparedStatement pst2 = con.prepareStatement(delquery);
            
            pst2.executeUpdate();
            
            System.out.println("data deleteddd");
        }
        catch(Exception e)
        {
            System.out.println("cant delete due to "+e);
        }
    }
    void view()
    {
        try
        {
            String viewquery="select*from student";
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(viewquery);
            while(rs.next())
            {
                System.out.print(" "+rs.getInt(1));
                System.out.print(" "+rs.getString(2));
                System.out.print(" "+rs.getInt(3));
                System.out.print(" "+rs.getString(4));
                System.out.print("\n");
            }
            System.out.println("view fn working");
        }
        catch(Exception e)
        {
            System.out.println("");
        }
    }
    void update()
    { 
        try
        {
            //using id:-
            int studentid=03;
            String updatequery=("update student set scourse='Btech' where sid="+studentid);
            //using sname:-
            //String studentname= "bhavay";
            //String updatequery=("update student set scourse='Btech' where sname='"+studentname+"'");
            PreparedStatement pst3 = con.prepareStatement(updatequery);
            
            pst3.executeUpdate();
            System.out.println("Table Updateddd.");
        }
        catch(Exception e)
        {
            System.out.println("table not updated due to"+e);
        }
    }
    public static void main(String args[])
    {
        Operation obj = new Operation();
        while(true)
        {
            System.out.println("\nPress 1 for Insert");
            System.out.println("Press 2 for delete");
            System.out.println("Press 3 for view");
            System.out.println("Press 4 for update");
            System.out.println("Press 5 for Exit");
            
            System.out.println("\nEnter Your Choice");
            Scanner scl = new Scanner(System.in);
            int choice = scl.nextInt();
            
            switch(choice)
            {
                case 1:
                    obj.insert();
                    break;
                case 2:
                    obj.delete();
                    break;
                case 3:
                    obj.view();
                    break;
                case 4:
                    obj.update();
                    break;
                case 5:
                    System.exit(0);
                    break;      
                default:
                    System.out.println("\nInvalid Choice");
            }
        }
    }
}