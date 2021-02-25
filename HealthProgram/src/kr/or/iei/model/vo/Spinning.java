package kr.or.iei.model.vo;

public class Spinning extends Exercise{


	public Spinning() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Spinning(String progrName, String roomName, String teachName, int totalNum, int month) {
		super(progrName, roomName, teachName, totalNum, month);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrice() {
		return 20000*getMonth();
	}

	public Spinning(String subName, int month) {
		super(subName, month);
		// TODO Auto-generated constructor stub
	}

	public Spinning(String progrName, String subName, String roomName, String teachName, int totalNum, int month) {
		super(progrName, subName, roomName, teachName, totalNum, month);
		// TODO Auto-generated constructor stub
	}
}
