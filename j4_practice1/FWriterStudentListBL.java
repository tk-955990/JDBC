package j4_practice1;

import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FWriterStudentListBL {

	public void extractAll() {
		
		final String FILE_PATH = "C:\\Udemy\\WriteFilePractice.csv";
		final String NEW_LINE  = System.getProperty("line.separator");
		final String COMMA = ",";

		StudentListDao dao = new StudentListDao();
		List<StudentListDto> extractedList = dao.selectStudentInfoAll();

		if (extractedList != null) {

			for (int i = 0; i < extractedList.size(); i++) {
				StringBuffer rsbuf = new StringBuffer();
				rsbuf.append(extractedList.get(i).getStudent_name());
				rsbuf.append(COMMA);
				rsbuf.append(extractedList.get(i).getSex());
				rsbuf.append(COMMA);
				rsbuf.append(extractedList.get(i).getAge());
				rsbuf.append(COMMA);
				rsbuf.append(extractedList.get(i).getCareer());
				rsbuf.append(COMMA);
				rsbuf.append(extractedList.get(i).getBranch_name());
				rsbuf.append(COMMA);
				rsbuf.append(extractedList.get(i).getCourse_name());
				rsbuf.append(COMMA);

				System.out.println(rsbuf.toString());
			}

		} else {
			System.out.println("[INFO]該当のユーザー情報を取得できませんでした");
		}
		
		try {
			File file = new File(FILE_PATH);
			FileWriter fileWriter = new FileWriter(file);

			fileWriter.write("#--受講生一覧--");
			fileWriter.write(NEW_LINE);
			fileWriter.write("名前,性別,年齢,職歴,登録支店,受講講座");
			fileWriter.write(NEW_LINE);

			for(int i=0;i<extractedList.size();i++) {
				fileWriter.write(extractedList.get(i).getStudent_name());
				fileWriter.write(COMMA);
				fileWriter.write(extractedList.get(i).getSex());
				fileWriter.write(COMMA);
				fileWriter.write(extractedList.get(i).getAge());
				fileWriter.write(COMMA);
				fileWriter.write(extractedList.get(i).getCareer());
				fileWriter.write(COMMA);
				fileWriter.write(extractedList.get(i).getBranch_name());
				fileWriter.write(COMMA);
				fileWriter.write(extractedList.get(i).getCourse_name());
				fileWriter.write(COMMA);
				fileWriter.write(NEW_LINE);
			}
			fileWriter.flush();
			fileWriter.close();
		}catch(IOException e) {
			System.out.println(e);
		}

	}

}
