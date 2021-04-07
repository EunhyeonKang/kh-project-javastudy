import java.util.Arrays;

public class TelChart {
	public static void main(String[] args) {
		String[] arr = { "119", "97674223", "1195524421" };
		 System.out.println(solution(arr));
	}

	public static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length; i++) {
			if (phone_book[i].startsWith(phone_book[i]))return false;
		} return true;
	}
}
