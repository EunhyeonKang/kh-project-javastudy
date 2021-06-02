package kr.or.board.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FileRowMapper implements RowMapper{
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
		File f = new File();
		f.setFileNo(rs.getInt("file_no"));
		f.setFilename(rs.getString("filename"));
		f.setFilepath(rs.getString("filepath"));
		f.setBoardNo(rs.getInt("board_no"));
		return f;
	}
}
