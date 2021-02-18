package kh.java.MethodTest;

public class StudentMgr {
	public void main() {
		Student s1 = new Student(); //Student 객체화
		//new + 생성자 호출 시 
		//-> 메모리에 해당하는 객체 생성하고 해당 주소값 반환
		Student s2 = new Student();
		Student s3 = new Student(2222,"강은현","KH",30,'여');
		/*
		int stdNo = s1.getStdNo(); 	//선언한 변수의 메소드 호출
		System.out.println(stdNo); 	//0 출력
		s1.setStdNo(100);			//변수에 100 저장
		stdNo = s1.getStdNo();		//현재 변수 메소드 호출
		System.out.println(stdNo);	//100 출력
		/*
		 s1.메소드() -> Student클래스에 있는 stdNo라는 값을 가지고 오고 싶음
		 -> 메소드의 반환값을 이요해서 가지고 와야함 -> 반환값의 데이터 타입은
		 -> stdNo변수의 데이터 타입과 동일
		 */
		
		//s1 본인 정보 입력 학번, 이름, 학과, 나이, 성별 -> setter를 통해서 값 입력
		s1.setStdNo(17013230);
		s1.setName("강은현");
		s1.setDept("소프트웨어학과");
		s1.setAge(25);
		s1.setGender('여');
		s2.setGender('남');
		//getter를 통해서 출력
		int stdNo = s1.getStdNo(); //getStdNo 리턴타입은 int
		System.out.println(stdNo);
		String name = s1.getName();
		System.out.println(name);
		System.out.println(s1.getDept());
		System.out.println(s1.getAge());
		System.out.println(s1.getGender());
		System.out.println(s2.getAge());
		
	}
}
