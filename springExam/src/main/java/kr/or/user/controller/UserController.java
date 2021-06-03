package kr.or.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.user.model.service.UserService;
import kr.or.user.model.vo.User;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	public UserController() {
		super();
		System.out.println("컨트롤러 생성ㅎㅎㅎ");
	}
	@RequestMapping(value="login.do")
	public String login(User u,HttpServletRequest session) {
		System.out.println(u.getEmail());
		System.out.println(u.getUserPw());
		return null;
	}
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm() {
		return "user/join";
	}
	@RequestMapping(value="/join.do")
	public String insertUser(User u,Model model) {
		int result = service.insertUser(u);
		if (result > 0) {
			model.addAttribute("msg", "회원가입 성공");
		} else {
			model.addAttribute("msg", "회원가입 실패");
		}
		model.addAttribute("loc", "/");
		return "common/msg";
	}	
	@ResponseBody
	@RequestMapping(value="/idCheck.do")
	public String idCheck(User u) {
		User user = service.selectOneUser(u);
		if(user!=null) {
			return "1";
		}else {
			return "0";
		}
	}
}
