package kr.or.member.model.vo;

public class DM {
	private int dmNo;
	private String sender;
	private String receiver;
	private String dmConnect;
	private String dmTime;
	private String readStatus;
	public DM() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DM(int dmNo, String sender, String receiver, String dmConnect, String dmTime, String readStatus) {
		super();
		this.dmNo = dmNo;
		this.sender = sender;
		this.receiver = receiver;
		this.dmConnect = dmConnect;
		this.dmTime = dmTime;
		this.readStatus = readStatus;
	}
	public int getDmNo() {
		return dmNo;
	}
	public void setDmNo(int dmNo) {
		this.dmNo = dmNo;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getDmConnect() {
		return dmConnect;
	}
	public void setDmConnect(String dmConnect) {
		this.dmConnect = dmConnect;
	}
	public String getDmTime() {
		return dmTime;
	}
	public void setDmTime(String dmTime) {
		this.dmTime = dmTime;
	}
	public String getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}
	
}
