package kr.or.coupon.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.coupon.model.dao.CouponDao;
import kr.or.coupon.model.vo.Coupon;

@Service
public class CouponService {
	@Autowired
	private CouponDao dao;

	public ArrayList<Coupon> couponList(String memberId) {
		return dao.couponList(memberId);
	}

	@Transactional
	public int couponExpired() {
		// TODO Auto-generated method stub
		return dao.couponExpired();
	}


}
