package kr.or.iei.member.model.vo;

public class Vip extends Member{

	public Vip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vip(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getBonus() {
		// TODO Auto-generated method stub
		return 0.07*getPoint();
	}

}
