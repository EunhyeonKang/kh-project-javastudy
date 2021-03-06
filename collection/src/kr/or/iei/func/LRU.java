package kr.or.iei.func;

import java.util.Scanner;

public class LRU {
	public void main() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("문자열 입력 : ");
			String str= sc.next();
			//대소문자 구별
			System.out.println(str.toLowerCase());
			System.out.println(str.toUpperCase());
		}
	}
}
