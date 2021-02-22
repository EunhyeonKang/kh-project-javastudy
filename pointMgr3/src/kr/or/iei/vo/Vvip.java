package kr.or.iei.vo;

public class Vvip extends Silver{

	public Vvip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vvip(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}
	public double getBonus(){
		return 0.1*getPoint();
	}
}
