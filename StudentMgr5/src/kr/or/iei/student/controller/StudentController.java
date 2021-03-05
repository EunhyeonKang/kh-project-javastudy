package kr.or.iei.student.controller;

import java.util.HashMap;

import kr.or.iei.student.model.vo.Student;
import kr.or.iei.student.view.StudentView;

public class StudentController {
	//키값은 이름, 밸루는 학생객체로 관리
	HashMap<String, Student> students;
	StudentView view;
	public StudentController() {
		super();
		view = new StudentView();
		students = new HashMap<String, Student>();
	}
	public void main() {
		while(true) {
			int sel = view.showMenu();
			switch(sel) {
			case 0 : return;
			case 1 : 
				insetStudent();
				break;
			case 2 : 
				printAllStudent();
				break;
			case 3 : 
				printOneStudent();
				break;
			case 4 : 
				modifyStudent();
				break;
			case 5 : 
				deleteStudent();
				break;
			}
		}
	}
	public void deleteStudent() {
		String name = view.getName("삭제");
		if(students.containsKey(name)) {
			students.remove(name);
		}else {
			view.printMsg("존재하지 않는 학생입니다.");
		}
	}
	public void modifyStudent() {
		String name = view.getName("수정");
		if(students.containsKey(name)) {
			Student s = view.getStudent("수정");
			students.remove(name);
			students.put(s.getName(), s);
			
		}else {
			view.printMsg("존재하지 않는 학생입니다.");
		}
	}
	public void printOneStudent() {
		String name = view.getName("조회");
		Student s= students.get(name); //존재하지 않는 key로 get을 하는 경우 null 리턴
		if(s!=null) {
			view.printOneStudent(s);
		}else {
			view.printMsg("존재하지 않는 학생입니다.");
		}
		/*
		if(students.containsKey(name)) {
			//containsKey(매배견수) -> 매개변수로 전달한 값이 키값에 있는지 검사
			//있으면 true 없으면 false 리턴
			Student s = students.get(name);
			view.printOneStudent(s);
		}else {
			view.printMsg("존재하지 않는 학생입니다.");
		}*/
	}
	public void printAllStudent() {
		view.printAllStudent(students);
	}
	public void insetStudent() {
		Student s = view.getStudent("등록");
		students.put(s.getName(), s);
	}	
}
