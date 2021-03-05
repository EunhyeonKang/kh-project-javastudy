package kr.or.iei.member.model.vo;

public class Gold extends Member{
	public Gold() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gold(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getBonus() {
		return 0.05*getPoint();
	}
	
}
