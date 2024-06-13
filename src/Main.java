import java.sql.*;
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
            System.out.printf("%-10s %-20s %-10s %-5s%n", "PlayerID", "PlayerName", "TeamNum", "Age");
            while(rs.next()){

                System.out.printf("%-10d %-20s %-10d %-5d%n",
                        rs.getInt("playerid"),
                        rs.getString("playername"),
                        rs.getInt("teamnum"),
                        rs.getInt("age")); // Move to the next line
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
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