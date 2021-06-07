package kr.or.coupon.model.vo;

import lombok.Data;

@Data
public class Coupon {
	private int couponNo;
	private String couponName;
	private String couponContent;
	private String memberId;
	private String startDate;
	private String endDate;
	private String status;
}
