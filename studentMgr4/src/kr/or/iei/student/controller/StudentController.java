package kr.or.iei.student.controller;

import java.util.ArrayList;

import kr.or.iei.student.view.StudentView;
import kr.or.iei.student.vo.Student;

public class StudentController {
	ArrayList<Student> students;
	StudentView view;
	public StudentController() {
		super();
		students = new ArrayList<Student>();
		view = new StudentView();
	}
	public void main() {
		while(true) {
			int sel = view.showMenu();
			switch(sel) {
			case 0 : return;
			case 1 : 
				//students.add(view.getStudent("등록"));
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
		String name = view.searchName("삭제");
		int searchIndex = searchStudent(name);
		if(searchIndex == -1 ) {
			view.printMsg("학생이름이 존재하지 않습니다.");
		}else {
			students.remove(searchIndex);
			view.finishStudent("삭제");
		}
	}
	
	public void modifyStudent() {
		String name = view.searchName("수정");
		int searchIndex = searchStudent(name);
		if(searchIndex ==-1) {
			view.printMsg("학생이름이 존재하지 않습니다.");
		}else {
			Student s = view.getStudent("수정");
			students.set(searchIndex, s);
			view.finishStudent("수정");
		}
	}
	public void printOneStudent() {
		String name = view.searchName("조회");
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			view.printMsg("학생이름이 존재하지 않습니다");
		}else {
			view.printOneStudent(students.get(searchIndex));
		}
	}
	public int searchStudent(String name) {
		for(int i=0;i<students.size();i++) {
			if(students.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	public void printAllStudent() {
		view.printAllStudent(students);
	}
	public void insetStudent() {
		Student s = view.getStudent("등록");
		students.add(s);
		view.finishStudent("등록");
	}
}
