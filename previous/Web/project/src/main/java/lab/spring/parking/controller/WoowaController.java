package lab.spring.parking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.parking.model.*;
import lab.spring.parking.service.WoowaService;


@RestController
public class WoowaController {
	
	@Autowired
	WoowaService service;
	HttpSession session;
	/* user start*/
	//main page
	@RequestMapping("/main.do")
	public ModelAndView main() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("home_view");
		return mav;
	}
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView loginTry(String useremail, String userpwd, HttpServletRequest request) {
		ModelAndView mav= new ModelAndView();
		UserVO user =null;
		session=request.getSession();		
		user=service.login(useremail, userpwd);
		session.setAttribute("user", user);
		mav.setViewName("home_view");
		return mav;
	}
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logoutSuccess( HttpServletRequest request) throws Exception {
		ModelAndView mav= new ModelAndView();
		HttpSession session=request.getSession();
		session.invalidate();
		mav.setViewName("home_view");
		return mav;
	}
	//join page//
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public ModelAndView getjoin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member");
		return mav;
	}
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public ModelAndView joinSuccess(UserVO user) {
		ModelAndView mav = new ModelAndView();
		//System.out.println(service.addUser(user));
		if(service.addUser(user)>0) {
			mav.setViewName("home_view");
		}
		return mav;
	}
	/* user end */
	
	/* board start */
	@RequestMapping(value="/notice.do", method=RequestMethod.GET)
	public ModelAndView listNotice() {
		ModelAndView mav = new ModelAndView();
		List<NoticeVO> list =null;
		list=service.getNoticeList();
		mav.addObject("notice", list);
		mav.setViewName("notice_list");
		return mav;
	}
	
	@RequestMapping(value="/notice_write.do", method=RequestMethod.GET)
	public ModelAndView writeNotice(UserVO user, HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView();
		if(user.getIsmanager().equals("Y")){
			mav.setViewName("notice_write");	
		}else {
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('관리자만 접근가능한 페이지입니다.');</script>");
			mav.setViewName("notice_list");
		}
		return mav;
	}
	@RequestMapping(value="/notice_write.do", method=RequestMethod.POST)
	public ModelAndView postNotice(NoticeVO notice) {
		ModelAndView mav = new ModelAndView();
		if(service.addNotice(notice)>0) {
			mav.setViewName("notice_list");
		}
		return mav;
	}

	/* board end */
	
	//test
	@RequestMapping(value = "/test1.do")
	public ModelAndView getAll(HttpSession session){
		ModelAndView mav = new ModelAndView();
		List<PrkplceVO> lots = null;
		lots =service.findAllList();
		mav.addObject("lots",lots);
		mav.setViewName("kakaomap2");
		return mav;
		
	}
	
	@RequestMapping(value = "/parking.do")
	public ModelAndView defaultMap(HttpSession session){
		ModelAndView mav = new ModelAndView();
		List<PrkplceVO> lots = null;
		lots =service.findAllList();
		mav.addObject("lots",lots);
		mav.setViewName("parking_view");
		return mav;


	}
	
	@RequestMapping(value = "/stop.do") //아직안한거죠?
	public ModelAndView stopMap(HttpSession session){
		ModelAndView mav = new ModelAndView();
		List<PrkplceVO> lots = null;
		lots =service.findAllList();
		mav.addObject("lots",lots);
		mav.setViewName("stop_view");
		return mav;
	}	
	
	@RequestMapping(value = "/MyParkLo.do")
	@ResponseBody
	public String defaultmap(@RequestBody Map<String,Object> point) {
		
		System.out.println(point.get("lat1"));
		
		return "{ \"status\" : 1 }";
	}
}