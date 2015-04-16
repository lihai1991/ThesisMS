import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
public class RTW {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Rank.db");
            String sCreate = "CREATE TABLE rank(Ranking text,Previous text,Name text,Assoc text,RankingPts text)";
             Statement stmt = conn.createStatement();
            stmt.executeUpdate(sCreate);
            String strURL = "http://www.ittf.com/ittf_ranking/WR_Table_3_A2.asp?Month1=3&Year1=2015&Gender=M&Category=100M";
            URL url = new URL(strURL);
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) url.openConnection();
            InputStreamReader input = new InputStreamReader(httpConn
                    .getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);
            String line;
            StringBuilder contentBuf = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
            String buf = contentBuf.toString();
            int beginIx = buf.indexOf("1&nbsp;&nbsp");
            int endIx = buf.indexOf("2336")+4;
            String result = buf.substring(beginIx, endIx);
            Document doc=Jsoup.parse(result);
            String text=doc.body().text();
            int l=text.length();
            String []tokens=text.split("\\s{1,}", 140);
            /**Document doc = Jsoup.parse(buf);
            String html = "<div><p>Lorem ipsum.</p>";
            Document doc = Jsoup.parse(html);
            Document doc1 = Jsoup.parseBodyFragment(html);
            Element body = doc1.body();
            int beginIx = buf.indexOf("3/2015 -&nbsp;General List - Men");
             int endIx = buf.indexOf("2336");
             String result = buf.substring(beginIx, endIx);
             System.out.println( result);*/
            System.out.println(text);
            /*for(int j=0;j<tokens.length;j=j+7)
            {
                if(j>=63){int ed=2;
                    tokens[j]=tokens[j].substring(0,ed);}
                else if (j<63){int ed=1;
                    tokens[j]=tokens[j].substring(0,ed);}
                for(int k=6;k<tokens.length;k=k+7)
                {tokens[k]=tokens[k].substring(0,4);}
            System.out.println(tokens[j]);}*/
            for(int i=0;i<tokens.length;i++)
            {
                System.out.println(tokens[i]);
                stmt.executeUpdate("INSERT INTO rank VALUES( '"+tokens[7*i]+"','"+tokens[7*i+1]+"','"+tokens[7*i+2]+" "+tokens[7*i+3]+"','"+tokens[7*i+5]+"','"+tokens[7*i+6]+"')");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}