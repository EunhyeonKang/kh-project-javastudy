package kr.or.tv.model.vo;

public class BeanFactory {
	public TV getTV(String brand) {
		if(brand.equals("samsung")) {
			return new SamsungTV();
		}else if(brand.equals("lg")) {
			return new LgTV();
		}else {
			return null;
		}
	}
}
