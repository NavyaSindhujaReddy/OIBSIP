import java.util.*;
import java.sql.*;
public class Reservation {
    public static class User
    {
        private String username;
        private String password;
        User()
        {
        }
        Scanner sc=new Scanner(System.in);
        public String getUserName()
        {
            System.out.println("Enter UserName: ");
            username=sc.nextLine();
            return username;
        }
        public String getPassword()
        {
            System.out.println("Enter Password: ");
            password=sc.nextLine();
            return password;
        }
    }
    public static class Record
    {
        private int id=0;
        private String trainNo;
        private String PassName;
        private String MobileNo;
        private String classt;
        private String date;
        private String from;
        private String to;
        Scanner sc=new Scanner(System.in);
        public int getId()
        {
            id++;
            return id;
        }
        public String getTrainNo()
        {
            System.out.print("Enter Train Number : ");
            trainNo=sc.nextLine();
            return trainNo;
        }
        public String getPassName()
        {
            System.out.print("Enter Your Name: ");
            PassName=sc.nextLine();
            return PassName;
        }
        public String getMobileNo()
        {
            System.out.print("Enter Mobile Number: ");
            MobileNo=sc.nextLine();
            return MobileNo;
        }
        public String getclass()
        {
            System.out.print("Enter Class: ");
            classt=sc.nextLine();
            return classt;
        }
        public String getdate()
        {
            System.out.print("Enter Date: ");
            date=sc.nextLine();
            return date;
        }
        public String getfrom()
        {
            System.out.print("Enter Your Location: ");
            from=sc.nextLine();
            return from;
        }
        public String getTo()
        {
            System.out.print("Enter Your Destination: ");
            to=sc.nextLine();
            return to;
        }
    }
    /**
     * @param args
     */
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        User u=new User();
        String username=u.getUserName();
        String password=u.getPassword();
        String url="jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection con=DriverManager.getConnection(url,username,password)){
                System.out.println("User Connected");
                while(true)
                {
                    String insert="insert into reservations values(?,?,?,?,?,?,?,?)";
                    String delete="delete from reservations where id=?";
                    String updatetrain="update reservations set trainNo=? where id=?";
                    String updatename="update reservations set PassName=? where id=?";
                    String updatemobile="update reservations set MobileNo=? where id=?";
                    String updateclass="update reservations set class=? where id=?";
                    String updatedate="update reservations set dater=? where id=?";
                    String updatefrom="update reservations set fromL=? where id=?";
                    String updateto="update reservations set toL=? where id=?";
                    String show="select * from reservations";
                    System.out.print("Enter your choice: ");
                    System.out.println("1.Insert Record");
                    System.out.println("2.Delete Record");
                    System.out.println("3.Update Record");
                    System.out.println("4.Show Records");
                    System.out.println("5.Exit");
                    int choice=sc.nextInt();
                    if(choice==1)
                    {
                        Record r=new Record();
                        int id=r.getId();
                        String trainNo=r.getTrainNo();
                        String PassName=r.getPassName();
                        String MobileNo=r.getMobileNo();
                        String classt=r.getclass();
                        String date=r.getdate();
                        String from=r.getfrom();
                        String to=r.getTo();
                        try(PreparedStatement p=con.prepareStatement(insert))
                        {
                            p.setInt(1,id);
                            p.setString(2,trainNo);
                            p.setString(3,PassName);
                            p.setString(4,MobileNo);
                            p.setString(5,classt);
                            p.setString(6,date);
                            p.setString(7,from);
                            p.setString(8,to);
                            int rows=p.executeUpdate();
                            if(rows>0)
                            System.out.println("Record Inserted");
                            else
                            System.out.println("Record was not added");
                        }
                        catch(SQLException e)
                        {
                            System.err.println("SQL Exception"+e.getMessage());
                        }
                    }
                    else if(choice==2)
                    {
                        System.out.print("Enter id: ");
                        int id=sc.nextInt();
                        try(PreparedStatement p=con.prepareStatement(delete))
                        {
                            p.setInt(1,id);
                            int rows=p.executeUpdate();
                            if(rows>0)
                            System.out.println("Record Deleted");
                            else
                            System.out.println("Record was not deleted");
                        }
                        catch(SQLException e)
                        {
                            System.err.println("SQL Exception"+e.getMessage());
                        }
                    }
                    else if(choice==3)
                    {
                        System.out.println("Enter which data u want to update: 1.TrainNo 2.Name 3.MobileNo 4.class 5.date 6.Location 7.Destination");
                        int c=sc.nextInt();
                        System.out.print("Enter id: ");
                        int id=sc.nextInt();
                        if(c==1)
                        {
                            Record r=new Record();
                            String train=r.getTrainNo();
                            try(PreparedStatement p=con.prepareStatement(updatetrain))
                            {
                                p.setString(1, train);
                                p.setInt(2,id);
                                int rows=p.executeUpdate();
                                if(rows>0)
                                System.out.println("Record Updated");
                                else
                                System.out.println("Record was not Updated");
                            }
                            catch(SQLException e)
                            {
                                System.err.println("SQL Exception"+e.getMessage());
                            }
                        }
                        else if(c==2)
                        {
                            Record r=new Record();
                            String name=r.getPassName();
                            try(PreparedStatement p=con.prepareStatement(updatename))
                            {
                                p.setString(1,name);
                                p.setInt(2,id);
                                int rows=p.executeUpdate();
                                if(rows>0)
                                System.out.println("Record Updated");
                                else
                                System.out.println("Record was not Updated");
                            }
                            catch(SQLException e)
                            {
                                System.err.println("SQL Exception"+e.getMessage());
                            }
                        }
                        else if(c==3)
                        {
                            Record r=new Record();
                            String MobileNo=r.getMobileNo();
                            try(PreparedStatement p=con.prepareStatement(updatemobile))
                            {
                                p.setString(1,MobileNo);
                                p.setInt(2,id);
                                int rows=p.executeUpdate();
                                if(rows>0)
                                System.out.println("Record Updated");
                                else
                                System.out.println("Record was not Updated");
                            }
                            catch(SQLException e)
                            {
                                System.err.println("SQL Exception"+e.getMessage());
                            }
                        }
                        else if(c==4)
                        {
                            Record r=new Record();
                            String classt=r.getclass();
                            try(PreparedStatement p=con.prepareStatement(updateclass))
                            {
                                p.setString(1,classt);
                                p.setInt(2,id);
                                int rows=p.executeUpdate();
                                if(rows>0)
                                System.out.println("Record Updated");
                                else
                                System.out.println("Record was not Updated");
                            }
                            catch(SQLException e)
                            {
                                System.err.println("SQL Exception"+e.getMessage());
                            }
                        }
                        else if(c==5)
                        {
                            Record r=new Record();
                            String date=r.getdate();
                            try(PreparedStatement p=con.prepareStatement(updatedate))
                            {
                                p.setString(1,date);
                                p.setInt(2,id);
                                int rows=p.executeUpdate();
                                if(rows>0)
                                System.out.println("Record Updated");
                                else
                                System.out.println("Record was not Updated");
                            }
                            catch(SQLException e)
                            {
                                System.err.println("SQL Exception"+e.getMessage());
                            }
                        }
                        else if(c==6)
                        {
                            Record r=new Record();
                            String from=r.getfrom();
                            try(PreparedStatement p=con.prepareStatement(updatefrom))
                            {
                                p.setString(1,from);
                                p.setInt(2,id);
                                int rows=p.executeUpdate();
                                if(rows>0)
                                System.out.println("Record Updated");
                                else
                                System.out.println("Record was not Updated");
                            }
                            catch(SQLException e)
                            {
                                System.err.println("SQL Exception"+e.getMessage());
                            }
                        }
                        else if(c==7)
                        {
                            Record r=new Record();
                            String to=r.getTo();
                            try(PreparedStatement p=con.prepareStatement(updateto))
                            {
                                p.setString(1,to);
                                p.setInt(2,id);
                                int rows=p.executeUpdate();
                                if(rows>0)
                                System.out.println("Record Updated");
                                else
                                System.out.println("Record was not Updated");
                            }
                            catch(SQLException e)
                            {
                                System.err.println("SQL Exception"+e.getMessage());
                            }
                        }
                    }
                    else if(choice==4)
                    {
                        try(PreparedStatement p=con.prepareStatement(show);
                           ResultSet rs=p.executeQuery())
                        {
                                while(rs.next())
                                {
                                    int id=rs.getInt("id");
                                    String trainNo=rs.getString("trainNo");
                                    String PassName=rs.getString("PassName");
                                    String MobileNo=rs.getString("MobileNo");
                                    String classt=rs.getString("class");
                                    String date=rs.getString("dater");
                                    String from=rs.getString("fromL");
                                    String to=rs.getString("toL");
                                    System.out.println("Id: "+id);
                                    System.out.println("Train Number:"+trainNo);
                                    System.out.println("Passenger Name: "+PassName);
                                    System.out.println("Mobile Number: "+MobileNo);
                                    System.out.println("Class Type: "+classt);
                                    System.out.println("Date: "+date);
                                    System.out.println("From Location: "+from);
                                    System.out.println("To Location: "+to);
                                    System.out.println("*********--------------*********");
                                }
                        }
                        catch(SQLException e)
                        {
                            System.err.println("SQL Exception"+e.getMessage());
                        }
                    }
                    else if(choice==5)
                    {
                        System.out.println("Exiting the program");
                        break;
                    }
                    else
                    System.out.println("Invalid choice entered");
                }
            }
            catch(SQLException e)
            {
                System.err.println("SQL Exception"+e.getMessage());
            }
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("Error loading JDBC driver "+e.getMessage());
        }
        sc.close();
    }
}
