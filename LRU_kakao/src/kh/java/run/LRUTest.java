package kh.java.run;

import java.util.ArrayList;

import java.util.Scanner;

public class LRUTest {

	ArrayList<String> lru;

	public LRUTest() {

		super();

		lru = new ArrayList<String>();

	}

	public void main() {

		Scanner sc = new Scanner(System.in);

		int totalCount = 0;

		System.out.print("캐시의 크기를 입력하세요(0~30) : ");

		int cacheSize = sc.nextInt();

		String[] arr = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };

//		String [] arr = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

//		String [] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

//		String [] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

//		String [] arr = {"Jeju", "Pangyo", "NewYork", "newyork"};

//		String [] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

		if (cacheSize == 0) {

			System.out.println("총 시간 : " + arr.length * 5);

		} else {

			for (int i = 0; i < arr.length; i++) {

				if (check(arr[i].toLowerCase())) {

					totalCount += 1;

					changeSeq(arr[i].toLowerCase(), getIndex(arr[i].toLowerCase()));

					lru.set(0, arr[i].toLowerCase());

				} else {

					totalCount += 5;

					if (lru.size() < cacheSize) {

						if (lru.size() == 0) {

							lru.add(arr[i].toLowerCase());

						} else {

							addSeq(arr[i].toLowerCase());

						}

					} else {

						changeSeq(arr[i].toLowerCase(), lru.size() - 1);

						lru.set(0, arr[i].toLowerCase());

					}

				}

			}

			System.out.println("총 시간 : " + totalCount);

		}

	}

	public void addSeq(String city) {

		lru.add(city);

		changeSeq(city, lru.size() - 1);

		lru.set(0, city);

	}

	public boolean check(String city) {

		for (int i = 0; i < lru.size(); i++) {

			if (lru.get(i).equals(city)) {

				return true;

			}

		}

		return false;

	}

	public void changeSeq(String city, int index) {

		if (index != 0) {

			for (int i = index; i > 0; i--) {

				lru.set(i, lru.get(i - 1));

			}

		}

	}

	public int getIndex(String city) {

		for (int i = 0; i < lru.size(); i++) {

			if (lru.get(i).equals(city)) {

				return i;

			}

		}

		return -1;

	}

}