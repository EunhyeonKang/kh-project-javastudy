package kh.java.func;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StreamTest1 {
	public void imageStream() {
		//파일 내용 읽어오기 위한 보조스트림
		BufferedReader br = null;
		//읽어온 파일을 변환 ->
		//이미지 파일로 내보내기 위한 보조스트림
		BufferedOutputStream bos = null;
		try {
			//파일에서  데이터를 읽어오기 위한 주스트림 생성
			FileReader fr = new FileReader("quiz.txt");
			//기능 개선을 위한 보조스트림 생성
			br = new BufferedReader(fr);
			//파일의 1줄을 읽어오기
			String str = br.readLine();		
			//읽어온 값을 이미지 파일로 내보내기 위한 주스트림 생성
			FileOutputStream fos = new FileOutputStream("test2.gif");
			bos = new BufferedOutputStream(fos);
			
			ArrayList<Byte> al = new ArrayList<Byte>();
			StringTokenizer sT = new StringTokenizer(str," ");
			while(sT.hasMoreTokens()) {
				String num = sT.nextToken();
				int iNum = Integer.parseInt(num,16);
				al.add((byte)iNum);
			}
			for(Byte b :al) {
				bos.write(b);
			}
			System.out.println("파일 내보내기 완료");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
