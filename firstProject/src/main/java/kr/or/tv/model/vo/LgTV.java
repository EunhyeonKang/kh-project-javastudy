package kr.or.tv.model.vo;

public class LgTV implements TV{
	public void powerOn() {
		System.out.println("LgTV -- 전원 ON");
	}
	public void powerOff() {
		System.out.println("LgTV -- 전원 OFF");
	}
	public void volumeUp() {
		System.out.println("LgTV -- 볼륨 압");
	}
	public void volumeDown() {
		System.out.println("LgTV -- 볼륨 다운");
	}
}
