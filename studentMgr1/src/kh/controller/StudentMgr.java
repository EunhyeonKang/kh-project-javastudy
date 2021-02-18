package kh.controller;
import java.util.Scanner;
public class StudentMgr {
	//10명 학생정보를 입력/출력/수정/삭제 하는 프로그램
	//학생 정보 이름/나이/주소
	String[] name;	//이름 저장할 배열
	int[] age;		//나이 저장할 배열
	String[] addr;	//주소 저장할 배역
	int index;		//배열 관리 번호
	Scanner sc;		//키보드 입력값을 받기 위한 객체
	public StudentMgr() {
		name = new String[10];
		age = new int[10];
		addr = new String[10];
		index = 0;
		sc = new Scanner(System.in);
		System.out.println("프로그램 구동 준비 완료");
	}
	//전체 진행메뉴
	public void main() {
		while(true) {
			System.out.println("\n----- 학생관리 프로그램v1 -----\n");
			System.out.println("1. 학생 정보 등록");
			System.out.println("2. 학생 정보 출력(전체)");
			System.out.println("3. 학생 정보 출력(1명 이름으로 검색)");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			switch(sel) {
			case 1:
				insertStudent();
				break;
			case 2:
				printAllStudent();
				break;
			case 3:
				printOneStudent();
				break;
			case 4:
				modifyStudent();
				break;
			case 5:
				break;
			case 0:
				System.out.println("Bye~!");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}
	/**
	 * 학생정보를 이비력받아 배열에 넣어주는 메소드
	 */
	public void insertStudent() {
		System.out.println("----- 학생 정보 등록 -----");
		System.out.print("이름 입력 : ");
		String inputName = sc.next();
		System.out.print("나이 입력 : ");
		int inputAge = sc.nextInt();
		System.out.print("주소 입력 : ");
		sc.nextLine();					//버퍼에서 개행문자 제거
		String inputAddr = sc.nextLine();
		//배열에 입력받은 값을 넣고 배열관리번호 증가
		name[index] = inputName;
		age[index] = inputAge;
		addr[index] = inputAddr;
		index++;
		System.out.println("정보 등록 완료");
	}
	/**
	 * 배열에 저장되어있는 모든 학생 정보를 출력하는 메소드
	 */
	public void printAllStudent() {
		System.out.println("\n-----전체 학생 정보 출력 -----\n");
		System.out.println("이름\t나이\t주소");
		System.out.println("------------------------");
		for(int i=0;i<index;i++) {
			System.out.println(name[i]+"\t"+age[i]+"\t"+addr[i]);
		}
	}
	/**
	 * 학생 이름을 입력받아 해당 학생의 정보를 출력하는 메소드
	 */
	public void printOneStudent(){
		System.out.println("\n ----- 학생 정보 출력(1명) -----\n");
		System.out.print("조회할 학생 이름 입력 : ");
		String searchName = sc.next();
		int searchIndex = searchStudent(searchName);
		if(searchIndex == -1) {
			System.out.println("학생 정보가 없습니다.");
		}else {
			System.out.println("이름 : "+name[searchIndex]);
			System.out.println("나이 : "+age[searchIndex]);
			System.out.println("주소 : "+addr[searchIndex]);
		}
	}
	/**
	 * 학생이름을 매개변수로 받아서 name배열에 몇번째 인덱스에 있는지 찾는 메소드
	 */
	public int searchStudent(String searchName) {
		for(int i=0;i<index;i++) {
			if(name[i].equals(searchName)) {
				return i;
			}
		}
		return -1;	//인덱스에 없는 값
	}
	public void modifyStudent() {
		System.out.println("\n ----- 학생 정보 수정 -----\n");
		System.out.print("수정할 학생 이름 입력 : ");
		/**
		 * 1. 수정할 학생 이름을 입력 받음
		 * 2. 입력받은 학생이 존재하는지 조회
		 * 3. 존대하지 않으면 "학생정보가 없습니다." 출력
		 * 4. 존재하면 이름, 나이, 주소 새로 입력받아서 배열에 정보 변경
		 */
		//수정할 정보 이름으로 검색
		String modifyName = sc.next();
		//입력받은 학생이 존재하는지 조회
		int modifyIndex = searchStudent(modifyName);
		if(modifyIndex==-1) {
			//존재하지 않으면
			System.out.println("학생 정보가 없습니다.");
		}else {
			//존재하면
			String mName = sc.next();
			int mAge = sc.nextInt();
			sc.nextLine();
			String mAddr = sc.nextLine();
			System.out.print("수정할 이름 입력 : ");
			name[modifyIndex] = mName;
			System.out.print("수정할 나이 입력 : ");
			age[modifyIndex]= mAge;
			System.out.print("수정할 주소 입력 : ");
			addr[modifyIndex]=mAddr;
			System.out.println("\n ----- 수정된 학생정보 조회 -----\n");
			System.out.println("이름 : "+name[modifyIndex]);
			System.out.println("나이 : "+age[modifyIndex]);
			System.out.println("주소 : "+addr[modifyIndex]);
		}
		
	}
}
