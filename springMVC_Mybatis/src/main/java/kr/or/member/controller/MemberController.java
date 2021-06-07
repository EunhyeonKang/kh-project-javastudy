package kr.or.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.or.member.model.service.MemberService;
import kr.or.member.model.vo.DM;
import kr.or.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;

	public MemberController() {
		super();
		System.out.println("MemberController 생성 완료");
	}

	@RequestMapping(value = "/login.do")
	public String login(Member m, HttpServletRequest request, Model model) {
		Member member = service.selectOneMember(m);
		if (member != null) {
			HttpSession session = request.getSession();//// HttpServletRequest request 대신 HttpSession session을 매개변수로 주면
														//// 생략가능
			session.setAttribute("m", member);
			model.addAttribute("msg", "로그인 성공");
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호를 확인해주세요.");
		}
		model.addAttribute("loc", "/");
		return "common/msg";
	}

	@RequestMapping(value = "/joinFrm.do")
	public String joinFrm() {
		return "member/joinFrm";
	}

	@RequestMapping(value = "/join.do")
	public String join(Member m, Model model) {
		int result = service.insertMember(m);
		if (result > 0) {
			model.addAttribute("msg", "회원가입 성공");
		} else {
			model.addAttribute("msg", "회원가입 실패");
		}
		model.addAttribute("loc", "/");
		return "common/msg";
	}

	@RequestMapping(value = "/searchFrm.do")
	public String searchFrm() {
		return "member/searchFrm";
	}

	@RequestMapping(value = "/idSearch.do")
	public String idSearch(Member m, Model model) {
		Member member = service.searchId(m);
		if (member != null) {
			model.addAttribute("msg", "아이디는[" + member.getMemberId() + "] 입니다.");
		} else {
			model.addAttribute("msg", "정보를 조회할 수 없습니다.");
		}
		model.addAttribute("loc", "/");
		return "common/msg";
	}

	@RequestMapping(value = "/deleteMember.do")
	public String deleteMember(String memberId, HttpSession session, Model model) {
		int result = service.deleteMember(memberId);
		if (result > 0) {
			session.invalidate();
			model.addAttribute("msg", "bye bye");
		} else {
			model.addAttribute("msg", "에러발생");
		}
		model.addAttribute("loc", "/");
		return "common/msg";
	}

	@RequestMapping(value = "/mypage.do")
	public String mypage(Member m, Model model) {
		Member member = service.selectOneMember(m);
		model.addAttribute("member", member);
		return "member/mypage";
	}

	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value = "/updateMember.do")
	public String updateMember(Member m) {
		int result = service.memberUpdate(m);
		return "redirect:/mypage.do?memberId=" + m.getMemberId();
	}

	@RequestMapping(value = "/allMember.do")
	public String allMember(Model model) {
		ArrayList<Member> list = service.selectAllMember();
		model.addAttribute("list", list);
		return "member/allMember";
	}

	@RequestMapping(value = "/allMemberCount.do")
	public String allMemberCount(Model model) {
		int result = service.selectAllMemberCount();
		model.addAttribute("msg", "총 회원 수는" + result + "명 입니다.");
		model.addAttribute("loc", "/");
		return "common/msg";
	}

	@RequestMapping(value = "/idCheck.do")
	public String idCheck(Member m) {
		Member member = service.selectOneMember(m);
		if (member != null) {
			return "1";
		} else {
			return "0";
		}
	}

	@RequestMapping(value = "/allMemberAjax.do")
	public String allMemberFrm() {
		return "member/allMemberAjax";
	}

	@ResponseBody
	@RequestMapping(value = "/allMemAjax.do", produces = "application/json; charset=utf-8")
	public String allMemAjax() {
		ArrayList<Member> list = service.selectAllMember();
		return new Gson().toJson(list);
	}

	@RequestMapping(value = "/pwChange.do")
	public String pwChange(Member m, Model model) {
		int result = service.pwChangeMember(m);
		if (result > 0) {
			model.addAttribute("msg", "변경성공");
		} else {
			model.addAttribute("msg", "변경실패");
		}
		model.addAttribute("loc", "/mypage.do?memberId=" + m.getMemberId());
		return "common/msg";
	}

	@RequestMapping(value = "/pwCheck.do")
	public String pwCheck() {
		return "member/pwCheck";
	}

	@ResponseBody
	@RequestMapping(value = "/checkPw.do")
	public String checkPw(Member m) { // 해당하는아이디의 비밀번호가 일치하는지 확인
		Member member = service.selectOneMember(m);
		if (member != null) {
			// 입력한 비밀번호가 일치하는경우
			return "1";
		} else { // 비밀번호 틀린경우
			return "0";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/checkId.do")
	public String checkId(Member m) {
		Member member = service.selectOneMember(m);
		if (member != null) {
			return "1";
		} else {
			return "0";
		}
	}
	/*
	 * @RequestMapping(value="/pwSearch.do") public String pwSearch(Member m, Model
	 * model) { Member member = service.searchPw(m); if(member!=null) {
	 * model.addAttribute("msg","비밀번호는["+member.getMemberPw()+"] 입니다."); }else {
	 * model.addAttribute("msg","정보를 조회할 수 없습니다."); } model.addAttribute("loc","/");
	 * return "common/msg"; }
	 * 
	 * 
	 */
	@RequestMapping(value="/allMemberChat.do")
	public String allMemberChat() {
		return "member/allChat";
	}
	@RequestMapping(value="/dmList.do")
	public String dmList() {
		return "dm/dmList";
	}
	@RequestMapping(value="/dmSend.do")
	public String dmSend(String msg) {
		System.out.println(msg);
		DM dm = service.selectDmSend(msg);
		return "dm/dmList";
	}

}
