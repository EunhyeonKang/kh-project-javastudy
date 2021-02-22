package kr.or.iei.vo;

public class Silver {
   //변수 등급 , 이름, 포인트 점수
   private String grade;
   private String name;
   private int point;
   //기본생성자
   public Silver() {
      
   } 
   //매개변수 있는 생성자
   public Silver(String grade, String name, int point) {
      this.grade = grade;
      this.name=name;
      this.point=point;
   }
   //getter 
   public String getGrade() {
      return grade;
   }
   public String getName() {
      return name;
   }
   public int getPoint() {
      return point;
   }
   //setter
   public void setGrade(String grade) {
      this.grade = grade;
   }
   public void setName(String name) {
      this.name = name;
   }
   public void setPoint(int point) {
      this.point = point;
   }
   public double getBonus() {
      return 0.02*point;
   }
}