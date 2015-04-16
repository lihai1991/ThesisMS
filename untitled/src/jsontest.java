/**
 * Created by ThinkPad on 2015/4/9.
 */
import org.json.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
public class jsontest {
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
            String line = "";
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
            System.out.println(text);
            /*for(int j=0;j<tokens.length;j=j+7)
            {
                if(j>=63){int ed=2;
                    tokens[j]=tokens[j].substring(0,ed);}
                else if (j<63){int ed=1;
                    tokens[j]=tokens[j].substring(0,ed);}
                for(int k=6;k<tokens.length;k=k+7)
                {tokens[k]=tokens[k].substring(0,4);}
            }*/
            for(int k=0;k<20;k++){
                    /*String jsonContent = '{"Rank":'"+tokens[7*k]+"',"Previous":"tokens[7*k+1]","Name":"tokens[7*k+2]"+" "+"tokens[7*k+3]","Assoc":"tokens[7*k+5]","RankingPts":"tokens[7*k+6]"}';
                    JSONObject jsonObject = new JSONObject(jsonContent);
                    String str1 = jsonObject.getString("Rank");
                    String str2 = jsonObject.getString("Previous");
                    String str3=jsonObject.getString("Name");
                    String str4=jsonObject.getString("Assoc");
                    String str5=jsonObject.getString("RankingPts");
                    System.out.println(str1);
                    System.out.println(str2);*/
                JSONObject json;
                json=new JSONObject();
                json.put("rank",tokens[7*k]);
                json.put("previous",tokens[7*k+1]);
                json.put("name",tokens[7*k+2]+" "+tokens[7*k+3]);
                json.put("assoc",tokens[7*k+5]);
                json.put("rankingpts",tokens[7*k+6]);
                /*stmt.executeUpdate("INSERT INTO rank VALUES(json.getJSONObject().getString(rank),json.getJSONObject().getString(preivous),json.getJSONObject().getString(name),json.getJSONObject().getString(assoc),json.getJSONObject().getString(rankingpts))");
                */System.out.println(json);
                stmt.executeUpdate("INSERT INTO  rank VALUES('"+json.getString("rank")+"','"+json.getString("previous")+"','"+json.getString("name")+"','"+json.getString("assoc")+"','"+json.getString("rankingpts")+"')");
                System.out.print(json.getString("rank")+" ");
                System.out.print(json.getString("previous")+" ");
                System.out.print(json.getString("name")+" ");
                System.out.print(json.getString("assoc")+" ");
                System.out.println(json.getString("rankingpts"));

            }
            /*for(int i=0;i<tokens.length;i++)
            {
                System.out.println(tokens[i]);
                stmt.executeUpdate("INSERT INTO rank VALUES( "+tokens[7*i]+","+tokens[7*i+1]+",'"+tokens[7*i+2]+" "+tokens[7*i+3]+"','"+tokens[7*i+5]+"',"+tokens[7*i+6]+")");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

