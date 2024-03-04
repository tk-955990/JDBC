package j4_practice1;

import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FWriterStudentListBL {

	public void extractAll() {
		
		final String FILE_PASS = "C:\\Udemy\\WriteFilePractice.csv";
		final String NEW_LINE  = System.getProperty("line.separator");
		final String COMMA = ",";

		StudentListDao dao = new StudentListDao();
		List<StudentListDto> exstractedList = dao.selectStudentInfoAll();

		if (exstractedList != null) {

			for (int i = 0; i < exstractedList.size(); i++) {
				StringBuffer rsbuf = new StringBuffer();
				rsbuf.append(exstractedList.get(i).getStudent_name());
				rsbuf.append(COMMA);
				rsbuf.append(exstractedList.get(i).getSex());
				rsbuf.append(COMMA);
				rsbuf.append(exstractedList.get(i).getAge());
				rsbuf.append(COMMA);
				rsbuf.append(exstractedList.get(i).getCareer());
				rsbuf.append(COMMA);
				rsbuf.append(exstractedList.get(i).getBranch_name());
				rsbuf.append(COMMA);
				rsbuf.append(exstractedList.get(i).getCourse_name());
				rsbuf.append(COMMA);

				System.out.println(rsbuf.toString());
			}

		} else {
			System.out.println("[INFO]該当のユーザー情報を取得できませんでした");
		}
		
		try {
			File file = new File(FILE_PASS);
			FileWriter fileWriter = new FileWriter(file);

			fileWriter.write("#--受講生一覧--");
			fileWriter.write(NEW_LINE);
			fileWriter.write("名前,性別,年齢,職歴,登録支店,受講講座");
			fileWriter.write(NEW_LINE);

			for(int i=0;i<exstractedList.size();i++) {
				fileWriter.write(exstractedList.get(i).getStudent_name());
				fileWriter.write(COMMA);
				fileWriter.write(exstractedList.get(i).getSex());
				fileWriter.write(COMMA);
				fileWriter.write(exstractedList.get(i).getAge());
				fileWriter.write(COMMA);
				fileWriter.write(exstractedList.get(i).getCareer());
				fileWriter.write(COMMA);
				fileWriter.write(exstractedList.get(i).getBranch_name());
				fileWriter.write(COMMA);
				fileWriter.write(exstractedList.get(i).getCourse_name());
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
