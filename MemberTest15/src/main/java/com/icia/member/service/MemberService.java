package com.icia.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;


@Service
public class MemberService {

	// ModelAndView를 사용하기 위해 mav 객체 생성
	private ModelAndView mav = new ModelAndView();
	
	// Controller와 DAO를 연결
		@Autowired
		private MemberDAO dao;
	
	// 회원가입 메소드
	public ModelAndView mJoin(MemberDTO member) {
		System.out.println("[2]service : " + member);
		
		// DB에 잘 저장되었는지 확인하기 위한, 회원가입이 성공했는지 확인하기 위한 변수 result생성
		int result = dao.mJoin(member);
		
		System.out.println("[4]service : " + result);
		
		if(result>0) {
			// 회원가입성공 result=1
			mav.setViewName("redirect:/mList");
		} else {
			// 회원가입실패 result =0
			mav.setViewName("joinForm");
		}
		
		return mav;
	}

	public ModelAndView mList() {
		System.out.println("[2]service");
		
		// 메소드를 만들면 해줘야 하는 것
		// (1) 메소드 타입의 return값 설정
		List<MemberDTO> memberList = dao.mList();
		
		System.out.println("[4]service " + memberList);
		
		mav.setViewName("memList");
		mav.addObject("memberList", memberList);
		
		// mav.addObject("jsp에서 사용할 이름", jsp에서 사용할 데이터);
		
		return mav;
	}

	public ModelAndView mView(String mId) {
		
		System.out.println("[2]service : " + mId);
		
		MemberDTO member = dao.mView(mId);
		
		System.out.println("[4]service : " + member);
		
		mav.setViewName("memView");
		mav.addObject("view", member);
		
		// memView.jsp에서 member의 값을 view라는 이름으로 사용하겠다.
		
		return mav;
	}

	public ModelAndView mDelete(String mId) {
		System.out.println("[2]삭제 service : " + mId);
		
		int result = dao.mDelete(mId);
		
		System.out.println("[4]삭제 service : " + result);
		
		if(result>0) {
			// 회원삭제성공 result=1
			mav.setViewName("redirect:/mList");
		} else {
			// 회원삭제실패 result =0
			mav.setViewName("index");
		}
		
		return mav;
	}

	public ModelAndView mModiForm(String mId) {
		
		// 수정 할 아이디의 정보
		MemberDTO member = dao.mView(mId);
		
		// DB에서 가져온 member의 정보를 modiForm.jsp에서 "modi"라는 이름으로 사용한다.
		mav.setViewName("modiForm");
		mav.addObject("modi", member);
		
		return mav;
	}

	public ModelAndView mModify(MemberDTO member) {
		System.out.println("[2]수정service : " + member);
		
		// DB에 잘 저장되었는지 확인하기 위한, 회원수정이 성공했는지 확인하기 위한 변수 result생성
		int result = dao.mModify(member);
		
		System.out.println("[4]수정service : " + result);
		
		if(result>0) {
			// 회원수정성공 result=1
			mav.setViewName("redirect:/memberView?mId="+member.getmId());
		} else {
			// 회원수정실패 result =0
			mav.setViewName("redirect:/mList");
		}
		
		return mav;
	}

	
}
