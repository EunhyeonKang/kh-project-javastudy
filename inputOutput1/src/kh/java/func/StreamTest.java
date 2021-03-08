package kh.java.func;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StreamTest {
	public void imageStream() {
		//quiz.txt파일에 있는 내용 읽어오기위한 보조스트림
		BufferedReader br = null;
		//읽어온 파일을 변환해서 이미지 파일로 내보내기 위한 보조스트림
		BufferedOutputStream bos = null;
		try {
			//quiz.txt파일에서 데이터를 읽어오기위한 주 스트림 생성
			FileReader fr = new FileReader("quiz.txt");
			//기능개선을 위한 보조스트림 생성
			br = new BufferedReader(fr);
			String str = br.readLine();//quiz.txt파일의 1줄 읽어옴
			//읽어온 값을 이미지 파일로 내보내기 위한 주스트림 생성
			FileOutputStream fos = new FileOutputStream("test.gif");
			bos = new BufferedOutputStream(fos);
			
			ArrayList<Byte> al = new ArrayList<Byte>();
			StringTokenizer sT = new StringTokenizer(str," ");
			while(sT.hasMoreTokens()) {
				String num = sT.nextToken();
				//String a = "a";
				int iNum = Integer.parseInt(num,16);
				al.add((byte)iNum);
			}
			for(Byte b : al) {
				bos.write(b);
			}
			System.out.println("파일 내보내기 완료");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
