package j4_practice1;

public class StudentListDto {

	private String student_id;
	private int gender;
	private int age;
	private int career_mon;
	private String branch_name;
	private String course_name;

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCareer_mon() {
		return career_mon;
	}

	public void setCareer_mon(int career_mon) {
		this.career_mon = career_mon;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

}
