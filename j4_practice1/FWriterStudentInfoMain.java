package j4_practice1;

public class FWriterStudentInfoMain {
	public static void main(String[] args) {

		FWriterStudentListBL bl = new FWriterStudentListBL();
        bl.extractAll();
        
        FWriterStudentsByCourseBL courseBl = new FWriterStudentsByCourseBL();
        courseBl.extractAll();
	}

}
