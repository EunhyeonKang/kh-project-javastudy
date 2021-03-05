package kr.or.iei.func;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetTest {
	public void setTest1() {
		HashSet<Integer> set = new HashSet<Integer>();
		boolean bool1 = set.add(10);	//데이터 입력 성공/실패 -> true/false
		System.out.println(bool1);
		System.out.println(set.size());
		boolean bool2 = set.add(20);
		System.out.println(bool2);
		System.out.println(set.size());
		boolean bool3 = set.add(10);
		System.out.println(bool3);
		System.out.println(set.size());
		System.out.println(set.add(30));
		System.out.println(set.add(40));
		System.out.println(set.size());
		System.out.println(set);
		System.out.println(set.remove(40));
		System.out.println(set);
		set.add(40);
		System.out.println(set);
		//set은 인덱스로 값을 관리하지 않아서 하나씩 꺼내서 사용하는 방법이 필요
		//1.ArrayList를 이용하는 방법
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		/*
		for(Integer num : list) {
			System.out.println(num);
		}
		*/
		//2. foreach사용
		for(Integer num: set) {
			System.out.println(num);
		}
		//정렬
		Collections.sort(list);
		System.out.println(list);
		//3. 반복자(iterator)
		Iterator<Integer> iter = set.iterator();
		/**
		 * iterator 객체 메소드
		 * next() : 값 한개를 가져옴(잘라내기개념)
		 * hasNext() : 꺼내올값이 남아있으면 true/없으면 false
		 */
		while(iter.hasNext()) {
			Integer num = iter.next();
			System.out.println(num);
		}
	}
	public void check() {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size()!=6) {
			System.out.print("숫자 입력 : ");
			int num = sc.nextInt();
			if(!set.add(num)) {
				System.out.println("중복숫자!");
			}
		}
		System.out.println(set);
	}
}
