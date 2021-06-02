package kr.or.notice.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.notice.model.dao.NoticeDao;
import kr.or.notice.model.vo.Notice;

@Service
public class NoticeService {
	@Autowired
	private NoticeDao dao;
	
	public NoticeService() {
		super();
		System.out.println("NoticeService 생성완료");
	}

	public ArrayList<Notice> selectAllNotice() {
		List list = dao.selectAllNotice();
		return (ArrayList<Notice>)list;
	}

	public int insertNotice(Notice n) {
		return dao.insertNotice(n);

	}

	public int deleteNotice(int noticeNo) {
		int result = dao.deleteNotice(noticeNo);
		return result;
	}

	public Notice detailNotice(int noticeNo) {
		List list = dao.detailNotice(noticeNo);
		Notice n = null;
		if(!list.isEmpty()) {
			n = (Notice)list.get(0);
		}
		return n;
	}

	public int updateNotice(Notice n) {
		int result= dao.updateNotice(n);
		return result;
	}

}
