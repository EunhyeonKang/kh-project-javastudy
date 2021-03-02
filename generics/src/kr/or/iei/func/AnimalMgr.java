package kr.or.iei.func;

public class AnimalMgr <T>{
	private T data;
	public AnimalMgr() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnimalMgr(T data) {
		super();
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
