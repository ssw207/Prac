package com.song.woo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.ws.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	시작페이지로 이동
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String move(Locale locale, Model model ) {
		logger.info("Welcome home! The client locale is {}.", locale);
		String a="아이고";
		model.addAttribute("a",a);
		return "home";
	}
	
//	아작스처리
	@RequestMapping(value = "/watch.do", method = RequestMethod.GET)//주소만 보내므로 get방식으로 통신
	@ResponseBody//return값을 ajax로 처리하기위해 선언 
	public Map<String, String>watch() {//입력값이 없으므로 파라미터 선언하지 않음
		
		Date today = new Date();//현재날짜
		SimpleDateFormat date =new SimpleDateFormat("yyyy-MM-dd");//현재날짜를 년-월-일 형태로 변경
		SimpleDateFormat time =new SimpleDateFormat("HH:mm:ss");//현재날짜를 시:분:초 형태로 변경
//		System.out.println(date.toString());
//		System.out.println(time.toString());
		
		String fDate=date.format(today);
		String fTime=time.format(today);

		//화면 표시 항목 : "현재 시간은  YYYY-mm-dd  HH24:mm:ss  입니다."
		String result="현재 시간은 "+fDate+" "+fTime+"입니다.";//컨켄트네이트로 스트링 결합
		System.out.println(result);
		Map<String, String> map= new HashMap<String, String>();
		map.put("result", result);//결과값을 map에 담음
		
		return map;//결과값 반환   
	}
	
	
}
