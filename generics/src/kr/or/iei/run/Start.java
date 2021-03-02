package kr.or.iei.run;

import kr.or.iei.func.GenericEx1;
import kr.or.iei.func.GenericEx2;

public class Start {
	public static void main(String[] args) {
		GenericEx1<Object> ge = new GenericEx1<Object>("str");
		GenericEx1<Integer> g = new GenericEx1<Integer>(10);
		GenericEx1<Character> g1 = new GenericEx1<Character>();
		int gNum = g.getData()+120;
		System.out.println(gNum);
		GenericEx2<Integer,String> g2 = new GenericEx2<Integer,String>(10,"s");
		int num1 = g2.getData1(); 	//오토언박싱 포함
		String str = g2.getData2();	
		
		System.out.println(num1);
		System.out.println(str);
		/*
		Tiger t = new Tiger(100);
		Bear b = new Bear(200);
		//generic
		AnimalMgr<Tiger> mgr1
		= new AnimalMgr<Tiger>(t);
		AnimalMgr<Bear> mgr2 
		= new AnimalMgr<Bear>(b);
		System.out.println(mgr1.getData().getHp());
		System.out.println(mgr2.getData().getHp());
		Tiger t1 = mgr1.getData();
		int hp1 = t1.getHp();
		Bear b1 = mgr2.getData();
		int hp2 = b1.getHp();
		System.out.println(hp1);
		System.out.println(hp2);
		
		AnimalMgr mgr1 = new AnimalMgr(t);
		AnimalMgr mgr2 = new AnimalMgr(b);
		//mgr1에 있는 data의 hp => 100
		//mgr2에 있는 data의 hp => 200
		Object obj1 = mgr1.getData();
		//Object obj = Tiger객체의 주소
		int hp1 = ((Tiger)obj1).getHp();
		System.out.println(hp1);
		Object obj2 = mgr2.getData();
		int hp2 = ((Bear)obj2).getHp();
		System.out.println(hp2);
		*/
		
	}

}
