import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class SubjectsTable {
	
	
	public static void subjectSQL() throws IOException {
    String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

    String user = "sa";
    String pass = "root";
	
	String sql = "CREATE TABLE Subjects " + "(subid INTEGER not NULL, " + " title VARCHAR(8), "
			+ " description VARCHAR(250), " + " pricePerStudent DECIMAL , " + " PRIMARY KEY ( subid ))";
	
	 // Entering the data
    Scanner scanner = new Scanner(System.in);

    System.out.println("enter Subjects id");
    Integer id = scanner.nextInt();

    System.out.println("enter title");
    String title = scanner.next();
    
    System.out.println("enter description");
    String description = scanner.next();

    System.out.println("enter pricePerStudent");
    Integer pricePerStudent = scanner.nextInt();
    
    
	  Connection con = null;
        

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user,
                    pass);
            Statement st = con.createStatement();


            int m = st.executeUpdate(sql);
            if (m >=  0)
                System.out.println(
                        "inserted successfully : " + sql);
            else
                System.out.println("insertion failed");

            con.close();
        }

        catch (Exception ex) {
            // Display message when exceptions occurs
            System.err.println(ex);
        }
	
	
	}
}
