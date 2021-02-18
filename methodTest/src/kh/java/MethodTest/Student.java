package kh.java.MethodTest;

public class Student {
	private int stdNo;	 //0
	private String name; //null
	private String dept; //null
	private int age;	 //0
	private char gender; //''
	//생성자 
	//JVM에서 생성자를 자동으로 만들어줌
	public Student() {
		//this.age = 20; 
	}
	//맨처음할때 초기화해주듯이 사용
	public Student(int stdNo, String name, String dept, int age, char gender) {
		this.stdNo = stdNo;
		this.name = name;
		this.dept = dept;
		this.age = age;
		this.gender = gender;
	}
	//getter -> 변수값을 가져오는 메소드
	public int getStdNo() {
		return this.stdNo;
	}
	public String getName() {
		return this.name;
	}
	public String getDept() {
		return this.dept;
	}
	public int getAge() {
		return this.age;
	}
	public char getGender() {
		return this.gender;
	}
	//setter -> 변수값을 저장하는 메소드
	public void setStdNo(int stdNo) { 	//변수이름이 (전역이름==지역이름) 이면 둘다 지역변수로 인식 -> 전역변수를 this.stdNo
		this.stdNo = stdNo;				//어디서 쓰더라도 전역변수를 호출할거야
	}
	public void setName(String name) {//변수의 값을 저장하는 거라 리턴값없어도됌
		this.name = name;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}
