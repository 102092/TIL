package lab.spring.parking.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

	// main page
	@RequestMapping("/main.do")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home_view");
		return mav;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView loginTry(String useremail, String userpwd, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		UserVO user = null;
		user = service.login(useremail, userpwd);
		request.setAttribute("userinfo", useremail);
		mav.addObject("user", user);
		mav.setViewName("home_view");
		return mav;
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logoutSuccess(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		request.removeAttribute("userinfo");
		mav.setViewName("home_view");
		return mav;
	}

	// join page
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public ModelAndView getjoin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member");
		return mav;
	}

	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public ModelAndView joinSuccess(UserVO user) {
		ModelAndView mav = new ModelAndView();
		// System.out.println(service.addUser(user));
		if (service.addUser(user) > 0) {
			mav.setViewName("home_view");
		}
		return mav;
	}

	// test

	@RequestMapping(value = "/test1.do")
	public ModelAndView getAll(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		List<PrkplceVO> lots = null;
		lots = service.findAllList();
		mav.addObject("lots", lots);
		mav.setViewName("kakaomap2");
		return mav;

	}

	@RequestMapping(value = "/parking.do")
	public ModelAndView parkingtMap(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		List<PrkplceVO> lots = null;
		lots = service.findAllList();
		mav.addObject("lots", lots);
		mav.setViewName("parking_view");
		return mav;
	}

	@RequestMapping(value = "/stop.do")
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
	
	@RequestMapping(value = "/ParkStop.do")
	@ResponseBody
	public String defaultmap2(@RequestBody Map<String,Object> pos) {
		
		System.out.println(pos.get("lat1"));
		
		return "{ \"status\" : 1 }";
	}

	@RequestMapping(value = "/Fav.do")
	@ResponseBody
	public String defaultmap3(@RequestBody Map<String,Object> pos) {
		
		MyFavVO vo = new MyFavVO();
		vo.setUsermail("user@user.com");
		vo.setFavlat(pos.get("lat1").toString());
		vo.setFavlng(pos.get("lng1").toString());
		
		service.addMyFav(vo);
		
		System.out.println(vo.toString());
		
		return "{ \"status\" : 1 }";
	}

	
}