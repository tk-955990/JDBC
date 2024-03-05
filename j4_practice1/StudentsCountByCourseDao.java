package j4_practice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsCountByCourseDao {

	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8";
	String USER_ID = "test_user";
	String USER_PASS = "test_pass";

	public List<StudentsCountByCourseDto> countStudentsInfoAll() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<StudentsCountByCourseDto> courseDtoList = new ArrayList<StudentsCountByCourseDto>();

		try {

			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);

			StringBuffer buf = new StringBuffer();
			buf.append(" select	        ");
			buf.append(" b.BRANCH_NAME, ");
			buf.append(" c.COURSE_NAME, ");
			buf.append(" count(c.COURSE_NAME) as COUNT_STUDENTS      ");
			buf.append(" from  	      ");
			buf.append(" branch b 	  ");
			buf.append(" inner join   ");
			buf.append(" uzuz_student s on b.BRANCH_ID = s.BRANCH_ID ");
			buf.append(" inner join   ");
			buf.append(" course c on c.COURSE_ID = s.COURSE_ID       ");
			buf.append(" group by 	  ");
			buf.append(" b.BRANCH_ID, ");
			buf.append(" c.COURSE_ID  ");
			buf.append(" order by 	  ");
			buf.append(" b.BRANCH_ID  ");

			ps = con.prepareStatement(buf.toString());
			rs = ps.executeQuery();

			while (rs.next()) {
				StudentsCountByCourseDto courseDto = new StudentsCountByCourseDto();
				courseDto.setBranch_name(rs.getString("branch_name"));
				courseDto.setCourse_name(rs.getString("course_name"));
				courseDto.setCount_students(rs.getString("count_students"));
				courseDtoList.add(courseDto);
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
		return courseDtoList;

	}

}
