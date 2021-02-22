package kr.or.iei.controller;

import java.util.Scanner;
import kr.or.iei.vo.*;

public class PointMgr {
	//전역변수 선언 -> 메소드에서 항상 사용
	Scanner sc;
	Silver s[];
	Gold g[];
	Vip v[];
	Vvip V[];
	int index;
	int gIndex;
	int vIndex;
	int vvIndex;
	//등급 구별
	char flag;
	public PointMgr() {// 생성자에서 초기화시키기
		super();
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		s = new Silver[10];
		g = new Gold[10];
		v = new Vip[10];
		V = new Vvip[10];
		int index = 0;
		int gIndex = 0;
		int vIndex = 0;
		int vvIndex = 0;
	}

	public void main() {
		while (true) {
			System.out.println("==== 포인트 관리 프로그램 ====");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 1명 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				//회원 생성
				insertMember();
				break;
			case 2:
				//회원 전체 조회
				printAllMember();
				break;
			case 3:
				//회원 1명 조회
				printOneMember();
				break;
			case 4:
				//회원 수정
				modifyMember();
				break;
			case 5:
				//회원 삭제
				deleteMember();
				break;
			case 0:
				//종료
				System.out.println("Bye");
				return;
			default:
				//0~5 범위 벗어난 입력을 할 경우
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public void insertMember() {
		System.out.println("===== 회원 정보 입력 =====");
		System.out.print("등급[silver/gold/vip/vvip] : ");
		String grade = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("포인트 입력 : ");
		int point = sc.nextInt();
		//등급으로 구별하여 등급배열에 0부터 grade,name,point 입력
		switch (grade) {
		case "silver":
			s[index++] = new Silver(grade, name, point);
			break;
		case "gold":
			g[gIndex++] = new Gold(grade, name, point);
			break;
		case "vip":
			v[vIndex++] = new Vip(grade, name, point);
			break;
		case "vvip":
			V[vvIndex++] = new Vvip(grade, name, point);
			break;
		}
		System.out.println("등록 완료");
	}

	public void printAllMember() {
		System.out.println("===== 전체 회원 출력 ======");
		System.out.println("등급\t이름\t포인트\t보너스");
		//getter로 출력
		for (int i = 0; i < index; i++) {
			System.out
					.println(s[i].getGrade() + "\t" + s[i].getName() + "\t" + s[i].getPoint() + "\t" + s[i].getBonus());
		}
		for (int i = 0; i < gIndex; i++) {
			System.out
					.println(g[i].getGrade() + "\t" + g[i].getName() + "\t" + g[i].getPoint() + "\t" + g[i].getBonus());
		}
		for (int i = 0; i < vIndex; i++) {
			System.out
					.println(v[i].getGrade() + "\t" + v[i].getName() + "\t" + v[i].getPoint() + "\t" + v[i].getBonus());
		}
		for (int i = 0; i < vvIndex; i++) {
			System.out
					.println(V[i].getGrade() + "\t" + V[i].getName() + "\t" + V[i].getPoint() + "\t" + V[i].getBonus());
		}
	}
	public void printOneMember() {
		System.out.println("===== 회원 정보 출력 =====");
		System.out.print("조회할 회원 이름 입력 : ");
		String name = sc.next();
		
		int searchIndex = searchIndex(name);
		//회원 검색 -> 회원인덱스 받아옴
		if(searchIndex==-1) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			if(flag=='s') {
				System.out.println("등급 : " + s[searchIndex].getGrade());
				System.out.println("이름 : " + s[searchIndex].getName());
				System.out.println("포인트 : " + s[searchIndex].getPoint());
				System.out.println("보너스 : " + s[searchIndex].getBonus());
			}else if(flag=='g'){
				System.out.println("등급 : " + g[searchIndex].getGrade());
				System.out.println("이름 : " + g[searchIndex].getName());
				System.out.println("포인트 : " + g[searchIndex].getPoint());
				System.out.println("보너스 : " + g[searchIndex].getBonus());
			}else if(flag=='v') {
				System.out.println("등급 : " + v[searchIndex].getGrade());
				System.out.println("이름 : " + v[searchIndex].getName());
				System.out.println("포인트 : " + v[searchIndex].getPoint());
				System.out.println("보너스 : " + v[searchIndex].getBonus());		
			}else if(flag=='V') {
				System.out.println("등급 : " + V[searchIndex].getGrade());
				System.out.println("이름 : " + V[searchIndex].getName());
				System.out.println("포인트 : " + V[searchIndex].getPoint());
				System.out.println("보너스 : " + V[searchIndex].getBonus());			
			}
		}
	}
	public void deleteMember() {
		System.out.println("===== 회원 정보 삭제 =====");
		System.out.print("삭제할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		if(searchIndex==-1) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			if(flag=='s') {
				//삭제할 인덱스를 맨뒤로 빼주고 
				for(int i=searchIndex;i<index-1;i++) {
					s[i]=s[i+1];
				}
				//맨마지막 인덱스 null값 입력
				s[--index] = null;
			}else if(flag=='g') {
				for(int i=searchIndex;i<gIndex-1;i++) {
					g[i]=g[i+1];
				}
				g[--gIndex] = null;
			}else if(flag=='v') {
				for(int i=searchIndex;i<vIndex-1;i++) {
					v[i]=v[i+1];
				}
				s[--index] = null;
			}else if(flag=='V') {
				for(int i=searchIndex;i<vvIndex-1;i++) {
					V[i]=V[i+1];
				}
				V[--vvIndex] = null;
			}
		}
		System.out.println("삭제 완료");
	}
	public void modifyMember() {
		System.out.println("===== 회원 정보 수정 =====");
		System.out.print("수정할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		if (searchIndex == -1) {
			System.out.println("회원 정보가 없습니다.");
		} else {
			//수정할 때 등급마다 보너스점수가 다르므로 
			//먼저 수정할 데이터를 삭제한 후-> 새로 수정할 등급에 추가해준다.
			System.out.print("수정할 등급 입력 : ");
			String mGrade = sc.next();
			System.out.print("수정할 이름 입력 : ");
			String mName = sc.next();
			System.out.print("수정할 포인트 입력 : ");
			int mPoint = sc.nextInt();
			if(flag=='s') {
				for (int i = searchIndex; i < index - 1; i++) {
					s[i] = s[i + 1];
				}
				s[--index] = null;
			}else if(flag=='g') {
				for (int i = searchIndex; i < gIndex - 1; i++) {
					g[i] = g[i + 1];
				}
				g[--gIndex] = null;
			}else if(flag=='v') {
				for (int i = searchIndex; i < vIndex - 1; i++) {
					v[i] = v[i + 1];
				}
				v[--vIndex] = null;
			}else if(flag=='V') {
				for (int i = searchIndex; i < vvIndex - 1; i++) {
					V[i] = V[i + 1];
				}
				V[--vvIndex] = null;
			}
			switch (mGrade) {
			case "silver":
				s[index++] = new Silver(mGrade, mName, mPoint);
				break;
			case "gold":
				g[gIndex++] = new Gold(mGrade, mName, mPoint);
				break;
			case "vip":
				v[vIndex++] = new Vip(mGrade, mName, mPoint);
				break;
			case "vvip":
				v[vIndex++] = new Vip(mGrade, mName, mPoint);
				break;
			}
			System.out.println("수정 완료");
		}
	}
	//회원 검색하는 로직
	public int searchIndex(String name) {
		for(int i=0;i<index;i++) {
			if(s[i].getName().equals(name)) {
				flag='s';
				return i;
			}
		}
		for(int i=0;i<gIndex;i++) {
			if(g[i].getName().equals(name)) {
				flag='g';
				return i;
			}
		}
		for(int i=0;i<vIndex;i++) {
			if(v[i].getName().equals(name)) {
				flag='v';
				return i;
			}
		}
		for(int i=0;i<vvIndex;i++) {
			if(V[i].getName().equals(name)) {
				flag='V';
				return i;
			}
		}
		return -1;
	}
}
