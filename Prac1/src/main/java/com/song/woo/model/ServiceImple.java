package com.song.woo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ServiceImple implements IService {

	@Override
	public String watch() {
			
		Date today = new Date();//현재날짜
		SimpleDateFormat date =new SimpleDateFormat("yyyy-MM-dd");//현재날짜를 년-월-일 형태로 변경
		SimpleDateFormat time =new SimpleDateFormat("HH:mm:ss");//현재날짜를 시:분:초 형태로 변경
//		System.out.println(date.toString());
//		System.out.println(time.toString());
		
		String fDate=date.format(today);
		String fTime=time.format(today);

		//화면 표시 항목 : "현재 시간은  YYYY-mm-dd  HH24:mm:ss  입니다."
		String result="현재 시간은 "+fDate+" "+fTime+"입니다.";//컨켄트네이트로 스트링 결합
		
		return result;
	}
	
}
