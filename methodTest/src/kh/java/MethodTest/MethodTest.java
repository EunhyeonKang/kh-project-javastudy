package kh.java.MethodTest;

public class MethodTest {
	public void exam1() {
		int[] arr = {1,2,3,4,5};
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		test3(arr[2]);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		test4(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public void test3(int num) {
		num+=100;
		System.out.println(num);
	}
	public void test4(int[] arr1) {
		arr1[2]+=100;
		System.out.println(arr1[2]);
	}
	public void test11() {
		int n1 = 10,n2=20;
		int n3 = 30,n4=40;
		String n5 = "a",n6="b";
		System.out.println(sum(n1,n2)+" ");
		System.out.println(sum(n5,n6)+" ");
		System.out.println(sum(n1,n2,n3)+" ");
		System.out.println(sum(n1,n2,n3,n4)+" ");
		add1(10,"hi");
		add1("hi",0);
		//오버로딩 , 오버라이딩
		//오버로딩 : 메소드 이름동일한데 매개변수로 구분할 수 있다.
	}
	//두 수를 매개변수로 받아서 합친 값을 리턴하는 메소드
	public int sum(int n1,int n2) {
		int sum = n1+n2;
		return sum;
	}
	public String sum(String n1,String n2) {
		String sum = n1+n2;
		return sum;
	}
	public int add1(int n1,String n2) {
		return n1;
		
		
	}
	public int add1(String n1,int n2) {
		return n2;
	
		
	}
	//세 수를 매개변수로 받아서 합친 값을 리턴하는 메소드
	public int sum(int n1,int n2, int n3) {
		int sum = n1+n2+n3;
		return sum;
	}
	//네 수를 매개변수로 받아서 합친 값을 리턴하는 메소드
	public int sum(int n1,int n2, int n3,int n4) {
		int sum = n1+n2+n3+n4;
		return sum;
	}
}
