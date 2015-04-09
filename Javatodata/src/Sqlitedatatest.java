/**
 * Created by ThinkPad on 2015/3/23.
 */
import java.sql.*;
public class Sqlitedatatest {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:MarchRank.db");
            String sInsert= "insert into rank values(170,175,'WALKER Samuel','ENG',1774)";
            String sSelect="SELECT * FROM rank";
            String sDelete="delete from rank where Ranking=170" ;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sDelete);
            ResultSet rs = stmt.executeQuery(sSelect);
            while (rs.next()) {
                System.out.print("Ranking = " + rs.getString("Ranking") + " ");
                System.out.print("Previous = " + rs.getString("Previous") + " ");
                System.out.print("Name =" + rs.getString("Name") + " ");
                System.out.print("Assoc =" + rs.getString("Assoc") + " ");
                System.out.println("RankingPts =" + rs.getString("RankingPts"));
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
