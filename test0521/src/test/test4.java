package test;

public class test4 {
	public void main() {
		test2 t2 = new test2();
		test1 t1 = new test1();
		test3 t3 = new test3();
		
		t2.main(t1);
		//시점1 //t2소멸시점
		t3.main();
		//시점2 //t3소멸시점
		//코드 100만줄
	}
}
