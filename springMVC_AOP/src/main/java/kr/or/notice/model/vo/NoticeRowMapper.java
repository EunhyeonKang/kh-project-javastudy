package kr.or.notice.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NoticeRowMapper implements RowMapper{
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
		Notice n = new Notice();
		n.setNoticeNo(rs.getInt("notice_no"));
		n.setNoticeTitle(rs.getString("notice_title"));
		n.setNoticeContent(rs.getString("notice_content"));
		n.setWriter(rs.getString("notice_writer"));
		n.setNoticeDate(rs.getString("notice_date"));
		return n;
	}
}
