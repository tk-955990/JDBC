package j4_practice1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FWriterStudentsByCourseBL {

	public void extractAll() {

		final String FILE_PATH = "C:\\Udemy\\WriteFilePractice.csv";
		final String NEW_LINE = System.getProperty("line.separator");
		final String COMMA = ",";

		StudentsCountByCourseDao courseDao = new StudentsCountByCourseDao();
		List<StudentsCountByCourseDto> extractedList = courseDao.countStudentsInfoAll();

		if (extractedList != null) {

			for (int i = 0; i < extractedList.size(); i++) {
				StringBuffer rsbuf = new StringBuffer();
				rsbuf.append(extractedList.get(i).getBranch_name());
				rsbuf.append(COMMA);
				rsbuf.append(extractedList.get(i).getCourse_name());
				rsbuf.append(COMMA);
				rsbuf.append(extractedList.get(i).getCount_students());
				rsbuf.append(COMMA);

				System.out.println(rsbuf.toString());
			}

		} else {
			System.out.println("[INFO]該当のユーザー情報を取得できませんでした");
		}

		try {
			File file = new File(FILE_PATH);
			FileWriter fileWriter = new FileWriter(file, true);
			fileWriter.write(NEW_LINE);
			fileWriter.write(NEW_LINE);
			fileWriter.write("#--集計結果--");
			fileWriter.write(NEW_LINE);
			fileWriter.write("登録支店,受講講座,受講者数");
			fileWriter.write(NEW_LINE);

			for (int i = 0; i < extractedList.size(); i++) {
				fileWriter.write(extractedList.get(i).getBranch_name());
				fileWriter.write(COMMA);
				fileWriter.write(extractedList.get(i).getCourse_name());
				fileWriter.write(COMMA);
				fileWriter.write(extractedList.get(i).getCount_students());
				fileWriter.write(NEW_LINE);
			}
			fileWriter.close();

		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
