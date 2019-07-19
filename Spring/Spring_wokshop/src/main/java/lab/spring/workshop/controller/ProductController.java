package lab.spring.workshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import lab.spring.workshop.model.ProductVO;
import lab.spring.workshop.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;

	@RequestMapping(value = "/list.do")
	public ModelAndView listPro(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		List<ProductVO> prolist = null;

		prolist = service.findProList();
		mav.addObject("product", prolist);
		mav.setViewName("product_list");
		return mav;
	}	
	
	@RequestMapping(value = "/add.do")
	public String addPro() {
		return "product_form";
	}	

	
	
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public ModelAndView addPro(@ModelAttribute("product") ProductVO vo) {
		ModelAndView mav = new ModelAndView();
		if (service.addPro(vo) > 0) {
			mav.setViewName("redirect:/list.do");
		}
		return mav;
	}	

	@RequestMapping(value = "/view.do")
	public ModelAndView viewPro(@RequestParam("pcode") String pcode) {
		ModelAndView mav = new ModelAndView();
		ProductVO prolist = null;
		prolist = service.getPro(pcode);
		mav.addObject("product", prolist);
		mav.setViewName("product_view");
		return mav;
	}
	

	@RequestMapping(value = "/modify.do")
	public ModelAndView modifyPro(@RequestParam("pcode") String pcode) {
		ModelAndView mav = new ModelAndView();
		ProductVO prolist = null;
		prolist = service.getPro(pcode);
		mav.addObject("product", prolist);
		mav.setViewName("product_modify");
		return mav;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView updatePro(@ModelAttribute("product") ProductVO vo) {
		ModelAndView mav = new ModelAndView();
		if (service.updatePro(vo) > 0) {
			mav.setViewName("redirect:/list.do");
		} else {
			mav.setViewName("redirect:/modify.do");
		}
		return mav;
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public ModelAndView removePro(@RequestParam("pcode") String pcode) {
		ModelAndView mav = new ModelAndView();
		if (service.removePro(pcode) > 0) {
			mav.setViewName("redirect:/list.do");
		} else {
			mav.setViewName("redirect:/modify.do");
		}
		return mav;
	}

}
