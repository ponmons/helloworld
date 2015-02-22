package sub.controller;


import javax.annotation.Resource;

import model.domain.PayDTO;
import model.service.MeetingService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingController {
	
	@Resource(name="meetingService")
    private MeetingService meetingService;
	
	/* 스프링 웹 설정 파일 참조 : springAjaxMyBatis-servlet.xml  
		<bean id="jsonView" class="net.sf.json.spring.web.servlet.view.JsonView" >
			<property name="contentType" value="text/html;charset=UTF-8" />
		</bean> */
	@RequestMapping("/insertfee.do")
	@ResponseBody
	public String insertPay(@RequestParam("price") int price, @RequestParam("totalfee") int totalfee){				//@requestParam meetno가 들어가야 된다...
		String resultMsg = "no";
		int result = meetingService.insertPay(new PayDTO(price, totalfee, 2));
		if(result > 0)  {
			resultMsg = "ok";
			System.out.println("회비 추가 성공");
		}
		return resultMsg ;
	}
}