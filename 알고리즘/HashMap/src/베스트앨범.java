import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class 베스트앨범 {
	public static ArrayList<Integer> solution(String[] genres, int[] plays) {
		int[] answer = {};
		int max = plays[0];
		HashMap<Integer, String> gm = new HashMap<Integer, String>();
		HashMap<Integer, Integer> pm = new HashMap<Integer, Integer>();
		for (int i = 0; i < genres.length; i++) {
			gm.put(i, genres[i]);
			pm.put(i, plays[i]);
		}
		HashSet<String> gSet = new HashSet<String>();
		for (int i = 0; i < genres.length; i++) {
			gSet.add(genres[i]);
		}
		HashMap<Integer, String> coPlay = new HashMap<Integer, String>();
		for (String x : gSet) {
			int count = 0;
			for (int i = 0; i < genres.length; i++) {
				if (gm.get(i).equals(x)) {
					count += pm.get(i);
				}
			}
			coPlay.put(count, x);
		}
		// 정렬
		TreeMap sort = new TreeMap(coPlay);
		String[] sortGenre = new String[gSet.size()];
		int index = 0;
		for (Object o : sort.keySet()) {
			sortGenre[index] = sort.get(o).toString();
			index++;
		}
		ArrayList<Integer> fIndex = new ArrayList<Integer>();
		for (int i = sortGenre.length - 1; i >= 0; i--) {
			int count = 0;
			for (int p1 : gm.keySet()) {
				if (sortGenre[i].equals(gm.get(p1))) {
					count++;
				}
			}
			int[] temp = new int[count];
			int k = 0;
			for (int p2 : gm.keySet()) {
				if (sortGenre[i].equals(gm.get(p2))) {
					temp[k] = pm.get(p2);
					k++;
				}
			}

			if (temp.length != 1) {
				Arrays.sort(temp);
				for (int j = temp.length - 1; j >= temp.length - 2; j--) {
					for (int p : pm.keySet()) {
						if (temp[j] == pm.get(p)) {
							fIndex.add(p);
							pm.put(p, 0);
							break;
						}
					}
				}
			} else {
				for (int p : pm.keySet()) {
					if (temp[0] == pm.get(p)) {
						fIndex.add(p);
						pm.put(p, 0);
						break;
					}
				}
			}
		}
		return fIndex;
	}

	public static void main(String[] args) {
		String[] arr = { "classic", "pop", "classic", "classic", "pop" };
		int[] p = { 500, 600, 150, 800, 2500 };
		solution(arr, p);
	}
}
