import java.sql.*;
import java.util.*;


public class FetchDataFromDataBase {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		PreparedStatement st = con.prepareStatement("select * from quiz where id=?");
		String questionData = "";
		String option[] = new String[4];
		// Statement stm = con.createStatement();
		// ResultSet rs1 = stm.executeQuery("select * from quiz where id=3");
		// while (rs1.next()) {
		// 	questionData = rs1.getString(2);
		// 	option[0] = rs1.getString(3);
		// 	option[1] = rs1.getString(4);
		// 	option[2] = rs1.getString(5);
		// 	option[3] = rs1.getString(6);
		// }
		// System.out.println(questionData + " " + option[0]);
		try {
			st.setInt(1, 10);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				questionData = rs.getString(2);
				option[0] = rs.getString(3);
				option[1] = rs.getString(4);
				option[2] = rs.getString(5);
				option[3] = rs.getString(6);
			}
		} catch (Exception e) {}
		System.out.println(questionData + " " + option[0]);
		// correct = rand.nextInt(4);
		// String temp1 = option[correct];
		// option[correct] = option[0];
		// option[0] = temp1;
		st.close();
		con.close();

	}
}