package kh.java.func;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamTest {
	public void primaryStream() {
		Scanner sc = new Scanner(System.in);
		System.out.print("저장할 파일명 입력 : ");
		String fileName = sc.next();
		sc.nextLine();
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			System.out.println("'"+fileName+"' 파일에 저장될 내용 입력");
			System.out.println("종료는 exit");
			int lineNumber = 1;
			while(true) {
				System.out.println((lineNumber++)+" : ");
				String str = sc.nextLine()+"\r\n";
				if(str.equals("exit\r\n")) {
					break;
				}
				fw.write(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void subStream() {
		Scanner sc = new Scanner(System.in);
		System.out.print("저장할 파일명 입력 : ");
		String fileName = sc.next();
		sc.nextLine();
		BufferedWriter bw = null;
		try {
			//주스트림 생성
			FileWriter fw = new FileWriter(fileName);
			//생성된 주스트림을 이용한 보조스크림 생성
			bw = new BufferedWriter(fw);
			System.out.println("["+fileName+"] 파일에 저장될 내용 입력");
			System.out.println("종료는 exit");
			int lineNumber=1;
			while(true) {
				System.out.println((lineNumber++)+" : ");
				String str = sc.nextLine();
				if(str.equals("exit")) {
					break;
				}
				bw.write(str);
				//보조스트림에만 존재하는 추가적인 기능
				bw.newLine(); 	//개행처리
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//보조스트림을 닫는 경우 주스트림은 같이 닫힘
				bw.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public void charStreamReader() {
		Scanner sc = new Scanner(System.in);
		//1. 스트림생성(객체를 생성) 2. 메소드를 이용한 입력 or 출력  3. 자원반환
		System.out.print("로드할 파일명 입력 : ");
		String fileName = sc.next();
		sc.nextLine();
		//데이터를 읽어올 예정이므로 Reader사용
		BufferedReader br = null;
		//주스크림 생성
		try {
			FileReader fr = new FileReader(fileName);
			//주스트림을 이용하여 보조스트림 생성
			br = new BufferedReader(fr);
			while(true){
				//파일에서 한줄 읽어옴
				//더이상 읽어올값이 없으면  null을 리턴
				String str = br.readLine();
				if(str == null) {
					break;
				}
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
