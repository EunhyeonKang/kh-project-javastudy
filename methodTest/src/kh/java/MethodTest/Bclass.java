package kh.java.MethodTest;

public class Bclass {
	private int no;

	public Bclass() {
		super();
	}
	public Bclass(int no) {
		super();
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	public int setNo(int no) {
		return this.no=no;
	}
	public void printMsg() {
		System.out.println("난 Bclass야~!!!");
	}
}
