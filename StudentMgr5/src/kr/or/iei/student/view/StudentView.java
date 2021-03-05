package kr.or.iei.student.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import kr.or.iei.student.model.vo.Student;

public class StudentView {
	Scanner sc;
	public StudentView() {
		super();
		sc = new Scanner(System.in);
	}

	public int showMenu() {
		System.out.println("----- 학생관리 프로그램v4 -----");
		System.out.println("1. 학생정보등록");
		System.out.println("2. 학생전체출력");
		System.out.println("3. 학생1명출력");
		System.out.println("4. 학생정보수정");
		System.out.println("5. 학생정보삭제");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		return sel;
	}

	public Student getStudent(String string) {
		System.out.println(string+"할 학생 이름 입력 : ");
		String name = sc.next();
		System.out.println(string+"할 학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.println(string+"할 학생 주소 입력 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		Student s = new Student(name,age,addr);
		return s;
	}

	public void printAllStudent(HashMap<String, Student> students) {
		System.out.println("----- 학생 전체 출력 -----");
		System.out.println("이름\t나이\t주소");
		Set<String> keys = students.keySet();
		for(String key : keys) {
			System.out.println(students.get(key));
		}
//		ArrayList<String> key = new ArrayList<String>(keys);
//		for(int i=0;i<key.size();i++) {
//			String currKey = key.get(i);
//			System.out.println(students.get(currKey));
//		}
	}

	public String getName(String string) {
		System.out.print(string+"할 이름 입력 : ");
		String name = sc.next();
		return name;
	}

	public void printMsg(String string) {
		System.out.println(string);
	}

	public void printOneStudent(Student s) {
		System.out.println("이름 : "+s.getName());
		System.out.println("나이 : "+s.getAge());
		System.out.println("주소 : "+s.getAddr());
		
	}

}
