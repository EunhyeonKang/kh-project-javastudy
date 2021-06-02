package kr.or.notice.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.notice.model.vo.Notice;
import kr.or.notice.model.vo.NoticeRowMapper;
@Repository
public class NoticeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public NoticeDao() {
		super();
		System.out.println("NoticeDao 생성완료");
	}

	public List selectAllNotice() {
		String query = "select * from notice";
		List list = jdbcTemplate.query(query,new NoticeRowMapper());
		return list;
	}

	public int insertNotice(Notice n) {
		String query = "insert into notice values(notice_seq.nextval,?,?,?,to_char(sysdate-1,'yyyy-mm-dd'))";
		Object[] params = {n.getNoticeTitle(),n.getNoticeContent(),n.getWriter()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}
	public int deleteNotice(int noticeNo) {
		String query = "delete from notice where notice_no=?";
		Object[] params = {noticeNo};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

	public List detailNotice(int noticeNo) {
		String query="select * from notice where notice_no = ?";
		Object[] params = {noticeNo};
		List list = jdbcTemplate.query(query, params,new NoticeRowMapper());
		return list;
	}

	public int updateNotice(Notice n) {
		String query="update notice set notice_title=?,notice_content=?,notice_writer=? where notice_no=?";
		Object[] params = {n.getNoticeTitle(),n.getNoticeContent(),n.getWriter(),n.getNoticeNo()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

}
