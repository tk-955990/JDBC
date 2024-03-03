package j4_practice1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FWriterStudentListBL {

	public void export() {

		StudentListDao dao = new StudentListDao();

		final String FILE_PATH = "\"C:\\Udemy\\WriteFilePractice.csv\"";
		final String NEW_LINE = System.getProperty("line.separator");
		final String COMMA = ",";
		
		try {
			File file = new File(FILE_PATH); 
			FileWriter fileWriter = new FileWriter(file);
			
			
		}catch(IOException e) {
			System.out.println(e);
		}
		
	}

}
