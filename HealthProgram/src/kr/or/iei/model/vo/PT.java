package kr.or.iei.model.vo;

public class PT extends Exercise{

	public PT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PT(String progrName, String roomName, String teachName, int totalNum, int month) {
		super(progrName, roomName, teachName, totalNum, month);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrice() {
		return 40000*getMonth();
	}

	public PT(String subName, int month) {
		super(subName, month);
		// TODO Auto-generated constructor stub
	}

	public PT(String progrName, String subName, String roomName, String teachName, int totalNum, int month) {
		super(progrName, subName, roomName, teachName, totalNum, month);
		// TODO Auto-generated constructor stub
	}
}
