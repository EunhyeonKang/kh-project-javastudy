package kr.or.iei.model.vo;

public class Pilates extends Exercise{

	public Pilates() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pilates(String progrName, String roomName, String teachName, int totalNum, int month) {
		super(progrName, roomName, teachName, totalNum, month);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrice() {
		return 50000*getMonth();
	}

	public Pilates(String progrName, String subName, String roomName, String teachName, int totalNum, int month) {
		super(progrName, subName, roomName, teachName, totalNum, month);
		// TODO Auto-generated constructor stub
	}

	public Pilates(String subName, int month) {
		super(subName, month);
		// TODO Auto-generated constructor stub
	}
}
