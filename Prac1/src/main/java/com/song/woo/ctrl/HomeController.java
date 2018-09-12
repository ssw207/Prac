package com.song.woo.ctrl;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.woo.model.IService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IService service;
	
//	시작페이지로 이동
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String move(Locale locale, Model model ) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "home";
	}
	
	
	@RequestMapping(value = "/watch.do", produces = "application/text; charset=utf8", method = RequestMethod.GET)//주소만 보내므로 get방식으로 통신,produeces사용하여 Http헤더의 컨텐트타입을 utf-8로 변경
	@ResponseBody//return값을 ajax로 처리하기위해 선언 
	public String watch(){//입력값이 없으므로 파라미터 선언하지 않음
		String result=service.watch();
		return result;//결과값 반환   
	}
	
}
