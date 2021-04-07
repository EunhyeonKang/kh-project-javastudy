import java.util.HashMap;
import java.util.Set;

public class 위장 {
	public static int solution1(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		Set<String> s = map.keySet();
		for(String key : s) {
			answer*=map.get(key)+1;
		}
		return answer - 1;
	}

	public static void main(String[] args) {
		String[][] people = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(solution1(people));
	}
}
