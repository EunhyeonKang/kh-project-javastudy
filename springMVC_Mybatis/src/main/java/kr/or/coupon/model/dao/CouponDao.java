package kr.or.coupon.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.coupon.model.vo.Coupon;

@Repository
public class CouponDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public ArrayList<Coupon> couponList(String memberId) {
		List<Coupon> list = sqlSession.selectList("coupon.couponList",memberId);
		return (ArrayList<Coupon>)list;
	}

	public int couponExpired() {
		return sqlSession.update("coupon.couponExpired");
	}
}
