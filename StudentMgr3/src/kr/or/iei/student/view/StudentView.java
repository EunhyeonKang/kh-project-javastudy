package kr.or.iei.student.view;

import java.util.Scanner;

import kr.or.iei.student.model.vo.Student;

public class StudentView {
	Scanner sc;

	public StudentView() {
		super();
		sc = new Scanner(System.in);
	}
	public int showMenu() {
		System.out.println("===== 학생관리 프로그램v3 =====");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생전체 조회");
		System.out.println("3. 학생1명 조회");
		System.out.println("4. 학생정보 수정");
		System.out.println("5. 학생정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		return sel;
	}
	public Student insertStudent() {
		System.out.println("----- 학생 정보 등록 -----");
		System.out.print("학생 이름 입력 : ");
		String name = sc.next();
		System.out.print("학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("학생 주소 입력 : ");
		sc.nextLine();
		String addr =  sc.nextLine();
		Student s = new Student(name,age,addr);
		return s;
	}
	public void printAllStudent(Student[] s,int index) {
		System.out.println("----- 학생 정보 전체 조회 ------");
		System.out.println("이름\t나이\t주소");
		for(int i=0;i<index;i++) {
			System.out.println(s[i].getName()+"\t"+s[i].getAge()+"\t"+s[i].getAddr());
		}
	}
	public String printOneStudent() {
		System.out.println("----- 학생 1명 조회 -----");
		System.out.print("조회할 회원 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	public void printOneStudent(Student[] s,int index, int searchIndex) {
	
		for(int i=0;i<index;i++) {
			if(i==searchIndex) {
				System.out.println(s[searchIndex].getName()+"\t"+s[searchIndex].getAge()+"\t"+s[searchIndex].getAddr());
		
			}
		}
		

	}
}
