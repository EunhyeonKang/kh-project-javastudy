package kh.java.MethodTest;

public class Aclass extends Bclass {
	private int num;

	public Aclass() {
		super(); 	//부모 생성자 호출 -> Bclass()
	}
	public Aclass(int num,int no) {
		super(no);	//부모 생성자 호출 -> Bclass(int no)
		this.num=num;
	
	}
	public int getNum() {
		return num;
	}
	public int setNum(int num) {
		return this.num=num;
	}
	@Override
	public void printMsg() {
		System.out.println("난 Aclass야~!!!!");
	}
}
