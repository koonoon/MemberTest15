package com.icia.member.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

@Controller
public class MemberController {
	
	// ModelAndView를 사용하기 위해 mav 객체 생성
	private ModelAndView mav = new ModelAndView();
	
	// Controller와 Service를 연결
	@Autowired
	private MemberService msvc;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	// joinForm : 회원가입 페이지로 이동
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "joinForm";	// joinForm.jsp로 이동
	}
	
	// memberJoin : 회원가입 메소드
	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
	public ModelAndView mJoin(@ModelAttribute MemberDTO member) {
		System.out.println("[1]controller : " + member);
		
		mav = msvc.mJoin(member);
		// MemberService의 mJoin(member) 메소드를 호출한다.
		// MemberService의 mJoin(member) 메소드의 리턴값을 가져온다.
		// MemberService의 mJoin()로 member의 데이터를 가지고 이동한다.
		
		System.out.println("[5]controller " + mav);
		
		return mav;
	}
	
	// mList : 회원목록 메소드
	@RequestMapping(value = "/mList", method = RequestMethod.GET)
	public ModelAndView mList() {
		System.out.println("[1]controller");
		
		mav = msvc.mList();
		
		System.out.println("[5]controller " + mav);
		
		return mav;
	}
	
	// memberView : 회원정보 상세보기 메소드
	@RequestMapping(value = "/memberView", method = RequestMethod.GET)
	public ModelAndView mView(@RequestParam("mId") String mId) {
		// String타입의 변수 mId에 jsp에서 넘어온 mId를 넣는다.
		
		System.out.println("[1]controller : " + mId);
		
		mav = msvc.mView(mId);
		
		return mav;
	}
	
	@RequestMapping(value = "/memberDelete", method = RequestMethod.GET)
	public ModelAndView mDelete(@RequestParam("mId") String mId) {
		// String타입의 변수 mId에 jsp에서 넘어온 mId를 넣는다.
		
		System.out.println("[1]controller : " + mId);
		
		mav = msvc.mDelete(mId);
		
		return mav;
	}
	
	// memberModiForm : 회원정보 수정 페이지로 이동
	@RequestMapping(value = "/memberModiForm", method = RequestMethod.GET)
	public ModelAndView mModiForm(@RequestParam("mId") String mId) {
	
		System.out.println("[1]수정p controller : " + mId);
		
		mav = msvc.mModiForm(mId);
		
		System.out.println("[5]수정p controller : " + mav);
		return mav;
	}
	
	// memberModify : 회원정보 수정 메소드
	@RequestMapping(value = "/memberModify", method = RequestMethod.POST)
	public ModelAndView mModify(@ModelAttribute MemberDTO member) {
		System.out.println("[1]수정controller : " + member);
		
		mav = msvc.mModify(member);
		
		System.out.println("[5]수정controller " + mav);
		
		return mav;
	}
}