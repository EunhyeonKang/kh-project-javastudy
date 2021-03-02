package kr.or.iei.func;

public class GenericEx1<T> {
	private T data;
	public GenericEx1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GenericEx1(T data) {
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
