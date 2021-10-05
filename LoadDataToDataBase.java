import java.sql.*;
import java.util.*;


public class LoadDataToDataBase {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		PreparedStatement st = con.prepareCall("insert into Quiz values(?,?,?,?,?,?)");
		for (int i = 1 ; i <= 20; i++) {

			System.out.println("ques : ");
			String ques = sc.nextLine();
			// sc.next();
			System.out.println("a : ");
			String a = sc.nextLine();
			// sc.next();
			System.out.println("b : ");
			String b = sc.nextLine();
			// sc.next();
			System.out.println("c : ");
			String c = sc.nextLine();
			// sc.next();
			System.out.println("d : ");
			String d = sc.nextLine();

			st.setInt(1, i);
			st.setString(2, ques);
			st.setString(3, a);
			st.setString(4, b);
			st.setString(5, c);
			st.setString(6, d);

			int n = st.executeUpdate();
			if (n != 0) {
				System.out.println("inserted");
			} else {
				System.out.println("not inserted");
			}
		}
		st.close();
		con.close();

	}
}