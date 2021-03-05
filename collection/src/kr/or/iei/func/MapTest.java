package kr.or.iei.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MapTest {
	public void mapTest1() {
		ArrayList<String> list = new ArrayList<String>();
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		list.add("Hello");
		list.add("Hi");
		list.add("Bye");
		list.add("안녕하세요");
		
		map.put(0, "Hello");
		map.put(1, "Hi");
		map.put(2, "Bye");
		map.put(100, "안녕하세요");
		//리스트에서 Hi 출력
		System.out.println(list.get(3));
		System.out.println(map.get(100));
		//String num1 = list.get(5);
		String num2 = map.get(2);	//해당 키값이 존재하면 케에 해당하는 value리턴
		System.out.println(num2);	//키 값이 존재하지 않으면 null 리턴
		map.remove(1);
		String str = map.get(1);
		System.out.println(str);
	}
	public void mapTest2() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("three", "셋");
		//System.out.println(map.get("three"));
		//System.out.println(map.get("four"));
		map.remove("two");
		//System.out.println(map.get("two"));
		map.put("two", "넷");
		//System.out.println(map.get("two"));
		boolean bool = map.containsKey("two");
		//System.out.println(bool);
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(map.get(key));
		}
	}
}
