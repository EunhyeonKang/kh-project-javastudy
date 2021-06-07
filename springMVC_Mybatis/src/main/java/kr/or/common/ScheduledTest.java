package kr.or.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.or.coupon.model.service.CouponService;

@Component
public class ScheduledTest {
	/*
	 * @Scheduled(fixedDelay = 60000) public void test1() {
	 * System.out.println("예약실행 테스트1(1초)"); }
	 */
	/*
	 * @Scheduled(cron="* * * * * *") public void test2() {
	 * System.out.println("cron : 1초에 한번 실행"); }
	 * 
	 * @Scheduled(cron="10 * * * * *") public void test3() {
	 * System.out.println("cron : 매분 10초마다(1분에 한번)"); }
	 */
	/*
	 * @Scheduled(cron="0-15 * * * * *") public void test2() {
	 * System.out.println("cron : 매분 0초에서 15초사이의 1초간격으로"); }
	 */
	@Autowired
	private CouponService service;
	@Scheduled(cron="0 20 10 * * *")
	public void expired() {
		service.couponExpired();
	}
}
