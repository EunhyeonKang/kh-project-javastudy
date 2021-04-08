package programmers;

public class Solution1 {

	public int[] solution(int brown, int yellow) {
		
		int width = 0;
		int height = 0;

		for (int i = 1; i <= yellow / 2 + 1; i++) {
			width = i;
			height = (yellow % i == 0) ? yellow / i : yellow / i + 1;

			if (2 * width + 2 * height + 4 == brown)
				break;

		}

		int[] answer = { Math.max(width, height) + 2, Math.min(width, height) + 2 };

		return answer;

	}

}
