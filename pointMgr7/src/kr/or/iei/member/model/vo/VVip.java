package kr.or.iei.member.model.vo;

public class VVip extends Member{

	public VVip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VVip(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getBonus() {
		// TODO Auto-generated method stub
		return 0.1*getPoint();
	}

}
