package kr.or.tv.model.vo;

public class SamsungTV implements TV {
	public void powerOn() {
		System.out.println("SamsungTV -- 전원 ON");
	}
	public void powerOff() {
		System.out.println("SamsungTV -- 전원 OFF");
	}
	public void volumeUp() {
		System.out.println("SamsungTV -- 소리 올림");
	}
	public void volumeDown() {
		System.out.println("SamsungTV -- 소리 내림");
	}
}
