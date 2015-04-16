/**
 * Created by ThinkPad on 2015/3/23.
 */
import java.sql.*;
public class Sqlitedatatest {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:MarchRank.db");
            Statement stat = conn.createStatement();
            stat.executeUpdate( "insert into rank values(170,170,'HAI','CHN',122);" );
            ResultSet rs = stat.executeQuery("SELECT * FROM rank;");
            while (rs.next()) {
                System.out.print("Ranking = " + rs.getString("Ranking") + " ");
                System.out.println("Previous = " + rs.getString("Previous") + " ");
                System.out.println("Name =" + rs.getString("Name") + " ");
                System.out.println("Assoc =" + rs.getString("Assoc") + " ");
                System.out.println("RankingPts =" + rs.getString("RankingPts"));
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
