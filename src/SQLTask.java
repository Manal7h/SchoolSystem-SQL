import java.sql.*;
import java.util.Scanner;

public class SQLTask {

	public static void main(String[] args) {

        // Creating the connection using Oracle DB
        // Note: url syntax is standard, so do grasp
        String url = "jdbc:sqlserver://192.168.100.100:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

        // Username and password to access DB
        // Custom initialization
        String user = "sa";
        String pass = "root";

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
        String sql = "insert into Students values(" + id + ",'" + fname + "','" + lname + "','" + birthdate + "')";

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
            if (m >=  1)
                System.out.println(
                        "inserted successfully : " + sql);
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