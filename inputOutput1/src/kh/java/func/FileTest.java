package kh.java.func;
import java.io.File;
import java.util.Scanner;

public class FileTest {
	public void fileTest() {
		Scanner sc = new Scanner(System.in);
		System.out.print("파일명을 입력하세요 : ");
		String fileName = sc.next();
		File file = new File(fileName);
		if(file.exists()) { 	//exists() -> 파일 존재 여부 true/false
			System.out.println("파일명 : "+file.getName());
			System.out.println("파일 상대 경로 : "+file.getPath());
			System.out.println("파일 절대 경로 : "+file.getAbsolutePath());
			System.out.println("파일 크기 : "+file.length()+"Byte");
		}else {
			System.out.println("해당 파일이 존재하지 않습니다.");
		}
	}
}
