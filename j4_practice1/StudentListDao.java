package j4_practice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentListDao {

	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8";
	String USER_ID = "test_user";
	String USER_PASS = "test_pass";

	public List<StudentListDto> selectStudentInfoAll() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<StudentListDto> dtoList = new ArrayList<StudentListDto>();

		try {

			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);

			StringBuffer buf = new StringBuffer();
			buf.append(" seledt         ");
			buf.append(" student_name,  ");
			buf.append(" gender,        ");
			buf.append(" age,           ");
			buf.append(" career_mon,    ");
			buf.append(" branch_name,   ");
			buf.append(" course_name    ");
			buf.append(" from                 ");
			buf.append(" uzuz_student s       ");
			buf.append(" inner join branch b  ");
			buf.append(" on s.BRANCH_ID       ");
			buf.append("  = b.BRANCH_ID       ");
			buf.append(" left outer join course c ");
			buf.append(" on s.COURSE_ID  ");
			buf.append(" = c.COURSE_ID   ");
			buf.append(" order by        ");
			buf.append(" s.STUDENT_ID    ");

			ps = con.prepareStatement(buf.toString());
			rs = ps.executeQuery();

			while (rs.next()) {
				StudentListDto dto = new StudentListDto();
				dto.setId(rs.getInt("id"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dtoList;

	}
}
