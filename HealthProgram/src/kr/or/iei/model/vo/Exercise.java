package kr.or.iei.model.vo;

public abstract class Exercise {
	private String progrName; 	//프로그램명
	private String roomName;	//강의실
	private String teachName;	//강사명
	private int totalNum;		//수강 인원수
	private int month;			//등록일수	
	private String subName;
	public Exercise() {
		super();
	}
	
	public Exercise(String progrName, String roomName, String teachName, int totalNum, int month) {
		super();
		this.progrName = progrName;
		this.roomName = roomName;
		this.teachName = teachName;
		this.totalNum = totalNum;
		this.month = month;
	}
	public Exercise(String progrName,String subName, String roomName, String teachName, int totalNum, int month) {
		super();
		this.progrName = progrName;
		this.subName = subName;
		this.roomName = roomName;
		this.teachName = teachName;
		this.totalNum = totalNum;
		this.month = month;
	}
	public Exercise(String subName,int month) {
		super();
		this.subName = subName;
		this.month = month;
	}
	public String getProgrName() {
		return progrName;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public void setProgrName(String progrName) {
		this.progrName = progrName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getTeachName() {
		return teachName;
	}

	public void setTeachName(String teachName) {
		this.teachName = teachName;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public abstract double getPrice();
	
}
