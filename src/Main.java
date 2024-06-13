import java.sql.*;
import java.io.*;
public class Main {

    public static void main(String[] args) {
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lab6_db",
                    "root","<hidden password will change when needed to access mysql>");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from players");
            int colCount=rs.getMetaData().getColumnCount();
            FileWriter fw=new FileWriter("mock_readme.txt");
            String s=String.format("%-10s %-20s %-10s %-5s%n", "PlayerID", "PlayerName", "TeamNum", "Age");
            fw.write(s);
            System.out.printf(s);
            while(rs.next()){
                s=String.format("%-10d %-20s %-10d %-5d%n",
                        rs.getInt("playerid"),
                        rs.getString("playername"),
                        rs.getInt("teamnum"),
                        rs.getInt("age"));
                System.out.printf(s); // Move to the next line
                fw.write(s);
            }
            fw.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }/*
        try{
            if(fw!=null){
                fw.close();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }*/
        try{
            if(con!=null){
                con.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}