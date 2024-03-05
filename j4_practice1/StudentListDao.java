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
			buf.append(" select	         ");
			buf.append(" student_name,   ");
			buf.append(" case gender when 1 then '男性'      when 2 then '女性'    end as sex,   ");
			buf.append(" age,career_mon, ");
			buf.append(" case when career_mon = 0      then '職歴なし' ");
			buf.append(" when (floor(career_mon/12)=0)  then concat(career_mon%12,'ヶ月')          ");
			buf.append(" when (career_mon%12=0)        then concat(floor(career_mon/12),'年')    ");
			buf.append(" else concat(floor(career_mon/12),'年',career_mon%12,'ヶ月')             ");
			buf.append(" end as career,  ");
			buf.append(" branch_name,     ");
			buf.append(" case  when course_name is null then '受講なし'  else course_name ");
			buf.append(" end as course_name     ");
			buf.append(" from   uzuz_student s   ");
			buf.append(" inner join branch b on s.BRANCH_ID = b.BRANCH_ID left outer join ");
			buf.append(" course c on s.COURSE_ID = c.COURSE_ID         ");
			buf.append(" order by  s.STUDENT_ID    ");

			ps = con.prepareStatement(buf.toString());
			rs = ps.executeQuery();

			while (rs.next()) {
				StudentListDto dto = new StudentListDto();
				dto.setStudent_name(rs.getString("student_name"));
				dto.setSex(rs.getString("sex"));
				dto.setAge(rs.getString("age"));
				dto.setCareer(rs.getString("career"));
				dto.setBranch_name(rs.getString("branch_name"));
				dto.setCourse_name(rs.getString("course_name"));
                dtoList.add(dto);
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
