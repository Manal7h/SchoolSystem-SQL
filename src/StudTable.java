import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class StudTable {
	
    public static void studentSQL() throws IOException {
	// Creating the connection using Oracle DB
    // Note: url syntax is standard, so do grasp
    String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";
	// Username and password to access DB
    // Custom initialization
    String user = "sa";
    String pass = "root";
	
	String sql = "CREATE TABLE Student " + "(id INTEGER not NULL, " + " fname VARCHAR(8), "
			+ " lname VARCHAR(8), " + " birthdate date, " + " PRIMARY KEY ( id ))";
	
    // Entering the data
    Scanner scanner = new Scanner(System.in);

    System.out.println("enter id");
    Integer id = scanner.nextInt();

    System.out.println("enter first name");
    String fname = scanner.next();
    
    System.out.println("enter last name");
    String lname = scanner.next();

    System.out.println("enter birthdate");
    String birthdate = scanner.next();
    
    // Inserting data using SQL query
    String sqlstud = "insert into Students values(" + id + ",'" + fname + "','" + lname + "','" + birthdate + "')";
	
	
	
    // Connection class object
    Connection con = null;
    
    // Try block to check for exceptions
    try {

        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        // Registering drivers
        DriverManager.registerDriver(driver);

        // Reference to connection interface
        con = DriverManager.getConnection(url, user,
                pass);

        // Creating a statement
        Statement st = con.createStatement();

        // Executing query
        int m = st.executeUpdate(sql);
        if (m >=  0)
            System.out.println(
                    "inserted successfully : " + sql);
        else
            System.out.println("insertion failed");

        // Closing the connections
        con.close();
        
        
     // Executing query
        int s = st.executeUpdate(sqlstud);
        if (s >=  0)
            System.out.println(
                    "inserted successfully : " + sqlstud);
        else
            System.out.println("insertion failed");

        // Closing the connections
        con.close();
    }
        
    // Catch block to handle exceptions
    catch (Exception ex) {
        // Display message when exceptions occurs
        System.err.println(ex);
    }
    

}
}

