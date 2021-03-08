package kh.java.func;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class UserMgr {
	Scanner sc;
	User user;
	public UserMgr() {
		super();
		sc = new Scanner(System.in);
	}
	public void main() {
		while(true) {
			System.out.println("1. 유저 정보 등록");
			System.out.println("2. 유저 정보 출력");
			System.out.println("3. 유저 정보 불러오기");
			System.out.println("4. 유저 정보 내보내기");
			System.out.println("0. 종료");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			switch(sel){
			case 1:
				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("나이 입력 : ");
				int age = sc.nextInt();
				System.out.print("주소 입력 : ");
				sc.nextLine();
				String addr = sc.nextLine();
				user = new User(name,age,addr);
				break;
			case 2:
				if(user != null) {
					System.out.println("이름 : "+user.getName());
					System.out.println("나이 : "+user.getAge());
					System.out.println("주소 : "+user.getAddr());
				}else {
					System.out.println("회원 정보가 없습니다.");
				}
				break;
			case 3:
				objectInput();
				break;
			case 4:
				objectOutput();
				break;
			case 0:
				return;
			default:
				System.out.println("잘못 입력함");
			}
		}
	}
	public void objectInput() {
		ObjectInputStream ois = null;
		try {
			//바이트 주스트림생성
			FileInputStream fis = new FileInputStream("object.txt");
			//객체를 읽어오기 위한 보조스트림 생성
			ois = new ObjectInputStream(fis);
			//객체를 읽어오는 코드
			user = (User)ois.readObject();
			System.out.println("불러오기 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void objectOutput() {
		ObjectOutputStream oos = null;
		try {
			//바이트 주스트림 생성
			FileOutputStream fos = new FileOutputStream("object.txt");
			//객체를 내보내기 위한 보조스트림 생성
			oos = new ObjectOutputStream(fos);
			oos.writeObject(user);	//객체를 내보내는 코드
			System.out.println("저장완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
