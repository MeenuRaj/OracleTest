import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Simple Java Program to connect Oracle database by using Oracle JDBC thin driver
 * Make sure you have Oracle JDBC thin driver in your classpath before running this program
 * @author
 */
public class OracleJBDCExample {

    public static void main(String args[]) throws SQLException {
        //URL of Oracle database server
        String url = "jdbc:oracle:thin:testuser/password@localhost"; 
      
        //properties for creating connection to Oracle database
        Properties props = new Properties();
        props.setProperty("user", "testdb");
        props.setProperty("password", "password");
      
        //creating connection to Oracle database using JDBC
        Connection conn = DriverManager.getConnection(url,props);

       // String sql ="select sysdate as current_day from dual";
        String sql ="select CUST_LAST_NAME, CUST_CITY, CUST_STATE from " + "demo_customers";
        //creating PreparedStatement object to execute query
        PreparedStatement preStatement = conn.prepareStatement(sql);
    
        ResultSet result = preStatement.executeQuery();
      
        while(result.next()){
            //System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
        	System.out.printf("%s %s, %s\n",
        			result.getString("CUST_LAST_NAME"),
        			result.getString("CUST_CITY"),
        			result.getString("CUST_STATE"));
        }
        System.out.println("done");
      
    }
}