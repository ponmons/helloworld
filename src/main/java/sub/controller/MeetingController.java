package sub.controller;


import javax.annotation.Resource;

import model.service.MeetingService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingController {
	
	@Resource(name="meetingService")
    private MeetingService meetingService;
	
	/* 스프링 웹 설정 파일 참조 : springAjaxMyBatis-servlet.xml  
		<bean id="jsonView" class="net.sf.json.spring.web.servlet.view.JsonView" >
			<property name="contentType" value="text/html;charset=UTF-8" />
		</bean> */
	@RequestMapping("/insert.do")
	@ResponseBody
	public String insertPay( int price, int totalfee){
		String resultMsg = "no";
		int result = meetingService.insertPay(price, totalfee);
		if(result > 0 )  {
			resultMsg = "ok";
			System.out.println("성공");
		}
		return resultMsg ;
	}
}