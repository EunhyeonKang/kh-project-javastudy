package kr.or.notice.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.notice.model.service.NoticeService;
import kr.or.notice.model.vo.Notice;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService service;

	public NoticeController() {
		super();
		System.out.println("NoticeController 생성완료");
	}
	@RequestMapping(value="/notice.do")
	public String notice(Model model) {
		ArrayList<Notice> list = service.selectAllNotice();
		model.addAttribute("list",list);
		return "notice/allNotice";
	}
	@RequestMapping(value="/insertNoticeFrm.do")
	public String insertNoticeFrm() {
		return "notice/insertNoticeFrm";
	}
	@RequestMapping(value="/insertNotice.do")
	public String insertNotice(Notice n, Model model) {
		int result = service.insertNotice(n);
		if(result>0) {
			model.addAttribute("msg","등록 성공");
		}else {
			model.addAttribute("msg","등록 실패");
		}
		model.addAttribute("loc","/");
		return "common/msg";
	}
	@RequestMapping(value="/detailNotice.do")
	public String detailNotice(int noticeNo,Model model) {
		Notice notice = service.detailNotice(noticeNo);
		model.addAttribute("notice",notice);
		return "notice/detailNotice";
	}
	
	@RequestMapping(value="/deleteNotice.do")
	public String deleteNotice(int noticeNo,HttpSession session, Model model) {		
		int result = service.deleteNotice(noticeNo);
		if(result>0) {
			model.addAttribute("msg","글이 삭제되었습니다.");
		}else {
			model.addAttribute("msg","삭제 실패했습니다.");
		}
		model.addAttribute("loc","/notice.do");
		return "common/msg";
	}
	@RequestMapping(value="/updateNotice.do")
	public String updateNotice(Notice n) {
		int result = service.updateNotice(n);
		return "redirect:/detailNotice.do?noticeNo="+n.getNoticeNo();
	}
}
