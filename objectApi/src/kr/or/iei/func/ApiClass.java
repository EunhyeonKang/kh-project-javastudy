package kr.or.iei.func;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ApiClass {
	public void math() {
		System.out.println(Math.abs(-10));// 절대값 -> 부호를 모두 +로
		System.out.println(Math.abs(10));
		// 올림, 버림, 반올림
		System.out.println(Math.ceil(10.1));
		System.out.println(Math.floor(10.9));
		System.out.println(Math.round(10.5));
		// 1.3456
		System.out.println(Math.round(1.3456 * 100) / (double) 100);
		System.out.println(Math.round(12345 / (double) 100) * 100);
		System.out.println(Math.random() * 10 + 1);
		System.out.println(Math.max(50, 30));
		System.out.println(Math.max(30, 50));
	}

	public void calendar() {
		Calendar today = Calendar.getInstance();
		// GregorianCalendar객체를 생성함(Calendar는 추상클래스로 객체생성불가)
		// 한국 표준 시간대 정보를 가져옴
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(Calendar.MONTH) + 1); // 0~11
		System.out.println(today.get(Calendar.DATE)); // 일출력
		System.out.println(today.get(Calendar.AM_PM)); // Am==0 , PM==1
		System.out.println(today.get(Calendar.HOUR)); // 시간
		System.out.println(today.get(Calendar.MINUTE)); // 분
		System.out.println(today.get(Calendar.SECOND)); // 초
		System.out.println(today.get(Calendar.DAY_OF_WEEK)); // 요일(1.일요일~7:토요일)
		
		Calendar day1 = Calendar.getInstance();
		System.out.println(day1.get(Calendar.DATE));
		System.out.println(day1.get(Calendar.DAY_OF_WEEK));
		
		day1.set(Calendar.MONTH, 3);
		day1.set(Calendar.DATE, 27);
		System.out.println(day1.get(Calendar.DAY_OF_WEEK));
		
		// 1일 -> 24*60*60 => 86400초 -> 86400000
		Calendar day2 = Calendar.getInstance();
		long time1 = day2.getTimeInMillis();
		day2.set(Calendar.DATE, 27);
		long time2 = day2.getTimeInMillis();

		System.out.println(time1);
		System.out.println(time2 - time1);
	}

	public void date() {
		Date today = new Date();
		System.out.println(today);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초 E요일");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:s");
		String todayString = format1.format(today);
		String todayStaing2 = format2.format(today);
		System.out.println(todayString);
		System.out.println(todayStaing2);
	}

	public void exam2() {
		Scanner sc = new Scanner(System.in);
		
		Calendar cal = Calendar.getInstance(); 	//오늘 날짜용
		Calendar cal1 = Calendar.getInstance();	//D=Day용
		//System.out.println("car : "+cal.getTimeInMillis());
		//System.out.println("carl : "+cal1.getTimeInMillis());
		
		long today = cal.getTimeInMillis(); //1960년부터~오늘날짜까지 ms초 환산
		
		System.out.println("=========== D-Day 계산기 ==============");
		System.out.print("D-Day [년도] 입력 : ");
		int year = sc.nextInt();
		System.out.print("D-Day [월] 입력 : ");
		int month = sc.nextInt();
		System.out.print("D-Day [일] 입력 : ");
		int day = sc.nextInt();
		cal1.set(Calendar.YEAR, year);
		cal1.set(Calendar.MONTH, month-1); 
		cal1.set(Calendar.DATE, day);
		long dday = cal1.getTimeInMillis(); //1960년부터~dday까지 ms초 환산
		
		long time = dday/1000 - today/1000;		//두 날짜 사이의 차이값(ms)
		long d = time/(24*60*60); 	//ms -> day 변환(86400000)
		if(d == 0) {
			System.out.println("D-Day입니다.");
		}else if(d>0) {
			System.out.println(d+"일 남았습니다.");
		}else{
			System.out.println(Math.abs(d)+"일 남았습니다.");
		}
	}
	
	
	
	public void wrapper() {
		//정수형변수 선언해서 10대입
		int num=10;
		System.out.println(num);
		//wrapperclass로 정수형 10대입(class타입이라 클래스생성 -> 메소드사용)
		Integer num1 = new Integer(10);
		System.out.println(num1.intValue());
		//auto-boxing (간단하게 하기 위해)
		Integer num2 =10; //toString();
		System.out.println(num2+1);
		System.out.println(num2.toString()+1);
		
		Character ch ='a';	//new Character('a')
		System.out.println(ch);//ch.characterValue();
		
		//String -> 기본자료형 변환(char)->charAt()
		String str = "1";
		System.out.println(str+1);	//11
		int no = Integer.parseInt(str);
		double no1 = Double.parseDouble(str);
		System.out.println(no+10);
		System.out.println(no1+10);
		
		//기본자료형 -> String 변환(문자 제외)
		double d1 = 11.1;
		String str1 = Double.valueOf(d1).toString();
		String str11 = String.valueOf(d1);
		System.out.println(str1);
		int no2 = 100;
		String str2 = Integer.valueOf(no2).toString();
		String str22 = String.valueOf(no2);
		System.out.println(str2);
		Character ch1 = 'a';
		String str3 = ch1.toString();
		System.out.println(str3);
	}
}