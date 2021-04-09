package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solutions {

	public static void main(String[] args) {
		String[] str = { "sun", "bed", "car" };
		solution(str, 1);
	}

	public static String[] solution(String[] strings, int n) {
		//문자열 정렬
//		Arrays.sort(strings, Comparator.reverseOrder()); --역순
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				//n번째 문자 추출
				char c1 = s1.charAt(n);
				char c2 = s2.charAt(n);
				// n번째 문자가 같을 경우에 원본 스트링을 사전순으로
				if (c1 == c2) {
					return s1.compareTo(s2);
				} else
					return c1 - c2;
			}
		});

		return strings;
	}

}
