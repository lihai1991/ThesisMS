/**
 * Created by ThinkPad on 2015/3/26.
 */
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
public class PD {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Rank.db");
            /**String sCreate = "CREATE TABLE rank(Ranking numeric,Previous numeric,Name text,Assoc text,RankingPts numeric)";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sCreate);*/
            String strURL = "http://www.ittf.com/ittf_ranking/WR_Table_3_A2.asp?Month1=3&Year1=2015&Gender=M&Category=100M";
            URL url = new URL(strURL);
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) url.openConnection();
            InputStreamReader input = new InputStreamReader(httpConn
                    .getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);
            String line = "";
            StringBuilder contentBuf = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
            String buf = contentBuf.toString();
            /**int beginIx = buf.indexOf("3/2015 -&nbsp;General List - Men");
            int endIx = buf.indexOf("2336");
            String result = buf.substring(beginIx, endIx);
            System.out.println( result);*/
            System.out.println(buf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
