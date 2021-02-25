package kr.or.iei.model.vo;

public class Swim extends Exercise{

	public Swim() {
		super();
	}

	public Swim(String progrName, String roomName, String teachName, int totalNum, int month) {
		super(progrName, roomName, teachName, totalNum, month);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrice() {
		return 30000*getMonth();
	}

	public Swim(String subName, int month) {
		super(subName, month);
		// TODO Auto-generated constructor stub
	}

	public Swim(String progrName, String subName, String roomName, String teachName, int totalNum, int month) {
		super(progrName, subName, roomName, teachName, totalNum, month);
		// TODO Auto-generated constructor stub
	}
}
