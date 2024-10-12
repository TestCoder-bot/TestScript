package Socket;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class Connect_Database {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            String url = "jdbc:postgresql://192.168.1.228:5432/postgres";
            String username = "postgres";
            String password = "Bitcomm@123";
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
 
            System.out.println("Database connected");
 
            ArrayList<String> resultList = new ArrayList<>();
            resultList.add("AELN_PM_202A");
            resultList.add("AELN_PM_202B");
            resultList.add("AELN_PM_203A");
            resultList.add("AELN_PM_20B");
            
            String query = "SELECT x.* FROM public.device_credentials x WHERE credentials_value LIKE ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
 
            for (String value : resultList) {
                pstmt.setString(1, "%" + value + "%");
 
                ResultSet rset = pstmt.executeQuery();
 
                while (rset.next()) {
                    String result = rset.getString(5);
                    
                    if (result!=null) {
                    	System.out.println(result+":found");
                    	
                    }else {
                    	System.out.println(value+":not found");
                    }
                   // System.out.println(result);
                }
            }
 
        } catch (Exception e) {
            System.out.println(e + " Database not connected");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println(e + " Error closing connection");
            }
        }
    }
}