package kr.or.iei.student.controller;

import kr.or.iei.student.model.vo.Student;
import kr.or.iei.student.view.StudentView;

public class StudentController {
	Student[] s;
	int index;
	StudentView view;

	public StudentController() {
		super();
		s = new Student[10];
		index = 0;
		view = new StudentView();
	}

	public void main() {
		while (true) {
			int sel = view.showMenu(); // 메인 메뉴를 보여주는 메뉴 선택값을 리턴하는 메소드
			switch (sel) {
			case 0:
				view.printMsg("Bye!!~");
				return;
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
				deleteStudent();
				break;
			}
		}
	}

	public void insertStudent() {
		//1.학생정보 입력받기
		Student stu = view.insertStudent();
		//2.입력받은 정보로 객체를 만들어서 배열에 저장
		s[index++] = stu;
	}
	public void printAllStudent() {
		view.printAllStudent(s,index);
	}
	public void printOneStudent() {
		String name = view.inputName("조회");
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			view.printMsg("학생이름이 존재하지 않습니다");
		}else {
			view.printOneStudent(s[searchIndex]);
		}
		//출력할 학생이름 입력  -> 뷰
		//[JAVA]15일차 _숙제
		//입력받은 이름이 배열에 몇번째 존재하는 조회 -> 컨트롤러
		//배열에 존재하는 경우 해당 학생 정보를 출력 -> 뷰
	}
	public int searchStudent(String name) {
		for(int i=0;i<index;i++) {
			if(s[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	public void modifyStudent() {
		String name = view.inputName("수정");
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			view.printMsg("학생이름이 존재하지 않습니다");
		}else {
			Student student = view.modifyStudent();
			s[searchIndex] = student;
		}
	}
	public void deleteStudent() {
		String name =view.inputName("삭제");
		int searchIndex = searchStudent(name);
		if(searchIndex==-1) {
			view.printMsg("학생정보가 없습니다.");
		}else {
			for(int i=searchIndex;i<index-1;i++) {
				s[i]=s[i+1];
			}
			s[--index]=null;
		}
	}
}
