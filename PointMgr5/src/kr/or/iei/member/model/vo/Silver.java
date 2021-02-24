package kr.or.iei.member.model.vo;

public class Silver extends Member{

	public Silver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Silver(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getBonus() {
		return 0.02*getPoint();
	}
}
