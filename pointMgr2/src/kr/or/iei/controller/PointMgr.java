package kr.or.iei.controller;
import kr.or.iei.vo.Silver;
import java.util.Scanner;
import kr.or.iei.vo.Gold;
import kr.or.iei.vo.Vip;
public class PointMgr {
   //숙제 searchMember 완성시키기
   Scanner sc;
   Silver[] s; 	//Silver 객체를 만들어서 넣어줘야한다.
   int index;
   Gold [] g;	//Gold 객체를 만들어서 넣어줘야한다.
   int gIndex;
   Vip [] v;	//Vip 객체를 만들어서 넣어줘야한다.
   int vIndex;
   //생성자
   public PointMgr() {
      super();
      sc = new Scanner(System.in);
      s = new Silver[10];
      index = 0;
      gIndex = 0;
      vIndex = 0;
   }
   //메인 실행
   public void main() {
      while(true) {
         System.out.println("-- 포인트 관리 프로그램 v2 --");
         System.out.println("1. 회원 정보 등록");
         System.out.println("2. 전체 회원 조회");
         System.out.println("3. 회원 1명 조회");
         System.out.println("4. 회원 정보 수정");
         System.out.println("5. 회원 삭제");
         System.out.println("0. 프로그램 종료");
         System.out.print("선택 > ");
         int sel = sc.nextInt();
       
         switch(sel) {
         case 1:
            insertMember();
            break;
         case 2:
            printAllMember();
            break;
         case 3:
            printOneMember();
            break;
         case 4:
            modifyMember();
            break;
         case 5:
            deleteMember();
            break;
         case 0: 
            System.out.println("안녕~");
            return;
         default:
            System.out.println("잘못입력했습니다");
            break;   
         }
      }
   }
   public void insertMember() {
      System.out.println("----회원정보 입력----");
      System.out.println("등급입력 [silver/gold/vip] : ");
      System.out.print("등급입력 : ");
      String grade = sc.next();
      System.out.print("이름입력 : ");
      String name = sc.next();
      System.out.print("포인트입력 : ");
      int point = sc.nextInt();
      switch(grade) {
      case "silver":
         s[index++]= new Silver(grade, name, point); //실버 객체 만들기
         break;
      case "gold" :
         g[gIndex++] = new Gold(grade, name, point);
         break;
      case "vip":
         v[vIndex++] = new Vip(grade, name, point);
         break;
      }
      
      System.out.println("등록완료!");
      /**
       * Silver silver = new Silver (grade,name,point)
       * s[index] = silver; 실버객체값을 s배열에 넣고
       * index++; 인덱스를 하나 늘린다 위에 한줄코드 풀어쓰면 이렇게
       */
   }
   public void printAllMember() {
      System.out.println("전체 회원 출력");
      System.out.println("등급\t이름\t포인트\t보너스");
      for(int i=0;i<index;i++) {
         System.out.println(s[i].getGrade() +
               "\t" + s[i].getName() + 
               "\t" + s[i].getPoint()+"\t"+s[i].getBonus());
      }
      for(int i =0 ; i<gIndex; i++) {
         System.out.println(g[i].getGrade() + "\t"
               +g[i].getName()+"\t"+ g[i].getPoint()+"\t" + g[i].getBonus());
      }
      for(int i =0 ; i<vIndex; i++) {
         System.out.println(v[i].getGrade() + "\t"
               +v[i].getName()+"\t"+ v[i].getPoint()+"\t" + v[i].getBonus());
      }
   }
   public void printOneMember() {
      System.out.println("선택 회원 출력");
      System.out.print("조회 할 회원 이름 입력");
      String name = sc.next();
      int searchIndex = searchMember(name);
      if(searchIndex == -1) {
         System.out.println("회원 정보가 없습니다");
      }else {
         System.out.println("등급 : " +s[searchIndex].getGrade());
         System.out.println("이름 : " +s[searchIndex].getName());
         System.out.println("포인트 : " +s[searchIndex].getPoint());
         System.out.println("보너스 : " +s[searchIndex].getBonus());
      }
   }
   public void modifyMember() {
      System.out.println("회원 정보 수정");
      System.out.println("수정할 회원 이름 입력");
      String name = sc.next();
      int searchIndex = searchMember(name);
      if(searchIndex == -1) {
         System.out.println("해당 회원이 없습니다");
      }else {
         System.out.print("수정 등급 입력 : ");
         String mGrade = sc.next();
         System.out.print("수정 이름 입력 : ");
         String mName = sc.next();
         System.out.print("수정 포인트 입력 : ");
         int mPoint = sc.nextInt();
         //새로운 Silver 객체를 생성해서 해당 객체로 배열의 값을 변경
         s[searchIndex] = new Silver(mGrade,mName,mPoint);
         
         /* 
         s[searchIndex].setGrade(mGrade);
         s[searchIndex].setName(mName);
         s[searchIndex].setPoint(mPoint);
         */
         System.out.println("수정완료");
      }
   }
   public void deleteMember() {
      System.out.println("====회원 정보 삭제====");
      System.out.println("삭제할 회원 이름 입력");
      String name = sc.next();
      int searchIndex = searchMember(name);
      if(searchIndex == -1) {
         System.out.println("회원 정보가 없습니다.");
      }else {
         for(int i = searchIndex ; i<index-1; i++) {
            s[i] = s[i+1];
         }
         index--;
         s[index]=null;
         System.out.println("삭제완료");
      }
   }
   public int searchMember(String name) {
      for(int i=0; i<index;i++) {
         if(s[i].getName().equals(name)) {
            return i;
         }
      }
      return -1;
   }
}