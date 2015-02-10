package sub.controller;

import java.util.List;

import javax.annotation.Resource;

import model.domain.memberDTO;
import model.service.SService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	
	@Resource(name="memService")
    private SService memService;
	
	/* 스프링 웹 설정 파일 참조 : springAjaxMyBatis-servlet.xml  
		<bean id="jsonView" class="net.sf.json.spring.web.servlet.view.JsonView" >
			<property name="contentType" value="text/html;charset=UTF-8" />
		</bean> */
	@RequestMapping("/select.do")
	public ModelAndView select(){
		List<memberDTO> list =  memService.memberSelect();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);			
		mv.setViewName("jsonView");	//id=jsonView 객체를 찾아서 JsonView실행
		return mv;
	}
}