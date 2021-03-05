package kr.or.iei.func;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ListTest {
	public void listTest1() {
		String[] str = new String[3];
		str[0] = "Hi";
		str[1] = "Hello";
		str[2] = "안녕하세요";
		System.out.println("배열 내용 출력");
		for(int i=0;i<str.length;i++) {
			System.out.println((i+1)+". "+ str[i]);
		}
		ArrayList<String> list = new ArrayList<String>(); 
		System.out.println("listsize : "+list.size());
		list.add("Hi");		//list의 가장 뒤에 Hi를 추가
		System.out.println("listsize : "+list.size());
		list.add("Hello");
		System.out.println("listsize : "+list.size());
		list.add("안녕하세요");
		System.out.println("listsize : "+list.size());
		System.out.println("리스트 내용 출력");
		for(int i=0;i<list.size();i++) {
			System.out.println((i+1)+". "+ list.get(i));
		}
	}
	public void listTest2() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(50);				//추가
		list.add(20);
		list.add(10);
		list.add(16);
		list.add(24);
		list.remove(2);				//삭제
		for(int i=0;i<list.size();i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
		int num =list.set(3, 100);	//해당인덱스의 값을 변경하고, 변경 전 값을 리턴
		System.out.println("num : "+num);
		for(int i=0;i<list.size();i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
		System.out.println("리스트 정렬");
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
		System.out.println("리스트 역순");
		Collections.reverse(list);
		for(int i=0;i<list.size();i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
		System.out.println(list);
		list.clear();
		System.out.println(list);
	}
	public void listTest3() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(21);
		list.add(100);
		list.add(1);
		list.add(18293);
		//foreach문 -> collection, list용 for문
		for(Integer num  : list) {
			System.out.println(num);
		}
//		for(int i=0;i<list.size();i++) {
//			Integer num = list.get(i);
//			System.out.println(list.get(i));
//		}
	}
}
