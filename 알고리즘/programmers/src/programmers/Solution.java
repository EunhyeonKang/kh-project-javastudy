package programmers;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
	static int cnt = 0;

	static int depth = 0;
	static int n = 0;
	static int[] num;
	static int answer = 0;
	static boolean[] visited;
	static TreeSet<Integer> set = new TreeSet<Integer>();
	
	public int solution(String numbers) {
		num = new int[numbers.length()];
		n = numbers.length();
		visited = new boolean[numbers.length()];
		for (int i = 0; i < n; i++) {
			num[i] = numbers.charAt(i) - '0';
		}
		Arrays.sort(num);
		for (int i = 0; i < n; i++) {
			int[] list = new int[i + 1];
			Combination(0, i + 1, -1, list);
		}
		boolean[] prime = new boolean[set.last() + 1];
		prime[0] = prime[1] = true;
		// 소수 체크
		for (int i = 2; i <= Math.sqrt(set.last()); i++) {
			if (prime[i])
				continue;
			for (int j = i + i; j <= set.last(); j += i) {
				prime[j] = true;
			}
		}
		for (Integer i : set) {
			if (!prime[i])
				answer++;
		}
		System.out.println(answer);
		return answer;
	}

	public static void Combination(int depth, int length, int com, int[] list) {
		if (depth == length) {
			String tmp = "";
			for (int i = 0; i < list.length; i++) {
				tmp += list[i];
			}
			set.add(Integer.parseInt(tmp));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list[depth] = num[i];

				Combination(depth + 1, length, i, list);
				visited[i] = false;
			}
		}
	}

}
