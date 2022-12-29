import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class SQLTask {
	
	static void MenueMain() {
		
		System.out.println("Please Choice one Option:");
		System.out.println("1. Create Student Table");
		System.out.println("2. Create Subjects Table");
		System.out.println("3. List Top 100 Students");
		System.out.println("4. List Top 50 Subjects");
		System.out.println("5. Add Student");
		System.out.println("6. Add subject ");
		System.out.println("7. Exit ");
	}
	
	

	//7,8
	public static   void topten() {
		String sql="SELECT * FROM Stud ORDER BY id LIMIT 10;";
	}
	public static   void topFifteen() {
		String sql="SELECT * FROM Subjects ORDER BY id LIMIT 15;";
	}

	public static void main(String[] args) throws NumberFormatException, IOException{
		Scanner sc = new Scanner(System.in);		
		MenueMain();
		
		do {
		int select = sc.nextInt();
//		boolean isExit = true;
//		while (isExit) {

		switch (select) {
		case 1:
			StudTable CreateStudentTable = new StudTable();
			CreateStudentTable.studentSQL();
			break;
			
			
		case 2:
			SubjectsTable CreateSubjectTable = new SubjectsTable();
			CreateSubjectTable.subjectSQL();
			break;
			
			
		}
		
		
		} 
		
		while (true);
	}
}


