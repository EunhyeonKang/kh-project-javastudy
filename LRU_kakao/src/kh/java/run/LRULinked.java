package kh.java.run;

import java.util.LinkedList;

import java.util.Scanner;

public class LRULinked {

	LinkedList<String> lru;

	public LRULinked() {

		super();

		lru = new LinkedList<String>();

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

				boolean hit = lru.removeFirstOccurrence(arr[i].toLowerCase());

				lru.add(arr[i].toLowerCase());

				totalCount += 1;

				if (!hit) {

					totalCount += 4;

					if (lru.size() > cacheSize) {

						lru.removeFirst();

					}

				}

			}

			System.out.println("총 시간 : " + totalCount);

		}

	}

}
