package controller;

import model.domain.DataDomain;
import model.domain.People;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"kodb", "key", "key2"})
public class SpringSubController {
	
	@RequestMapping(value="A.do")
	public String getProcess(){
		return "welcome";
	}
	
	@RequestMapping(value="B.do")
	public String getProcessB(){
		return "welcome2";
	}
	
	
	@RequestMapping(value="C.do")
	public String getProcessC(){
		return "redirect:/welcome3.jsp";
	}
	
	@RequestMapping(value="D.do", method=RequestMethod.POST)
	public ModelAndView getProcessD(@RequestParam("id") String id, 
														 @RequestParam("pw") String pw){
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.addObject("pw", pw);
		mv.setViewName("welcome4");
		return mv;
	}
	
	
	@RequestMapping(value="E.do", method=RequestMethod.POST)
	public String getProcessE(@ModelAttribute("p") People people){
		return "welcome5";
	}

	@RequestMapping(value="F.do", method=RequestMethod.POST)
	public String getProcessF() throws Exception{
		if(true){
			throw new Exception("예외 처리 연습");
		}
		return "welcome6";
	}
	
	//예외 처리 전담 메소드
	@ExceptionHandler(Exception.class)
	public String getProcessExc(Exception e){
		System.out.println("----------난 예외 처리만 담당-------------");
		e.printStackTrace();
		return "redirect:/failView.jsp";
	}
	
	@RequestMapping(value="G.do", method=RequestMethod.GET)
	public String getProcessG(String id, Model model){
		model.addAttribute("kodb", id);
		return "redirect:/welcome7.jsp";
	}
	
	/* 1. 세션 객체 생성과 세션 객체 삭제 하는 기법 학습
	 * 2. index.html -> 8번 링크 클릭 -> .. 
	 * 		-> getProcessH() : 쿼리스트링 값으로 순수 자바 빈 객체에 데이터 자동 저장
	 * 			세션에 데이터 저장 
	 * 		-> welcome8.jsp로 이동 : 세션 사용, 세션 삭제를 위한 링크
	 * 		-> 링크로  sessionDelete() 실행
	 * 			: SessionStatus parameter로 받아서 session의 데이터 삭제 무효화
	 * 				- session.setComplete(); 
	 * 		-> welcome8.jsp에서 세션데이터 없기 때문에 출력 안함 
	 *  */
	@RequestMapping(value="H.do", method=RequestMethod.GET)
	public String getProcessH(@ModelAttribute DataDomain v, 
										  Model m){
		m.addAttribute("kodb", v.getKodb());
		m.addAttribute("key", v.getKey());
		m.addAttribute("key2", v.getKey2());
		return "redirect:/welcome8.jsp";
	}
	
	@RequestMapping(value="sessionDelete.do", method=RequestMethod.GET)
	public String sessionDelete(@ModelAttribute DataDomain v, 
											SessionStatus session){
		session.setComplete();
		return "redirect:/welcome8.jsp";
	}
	
	
	/* 요청시 응답까지 처리하는 로직 
	 * @ResponseBody 
	 * 		: subController가 직접 출력을 할 경우에 필수인 어노테이션
	 * 		: 주의사항
	 * 			- 응답 데이터 인코딩 문제 발생
	 * 			 Spring 설정 파일에 @ResponseBody 만을 위한 인코딩 설정 필수 
	 *		: 주로 사용 하는 시점
	 *			- 비동기시에 주로 사용 
	 *			- JSON library & spring 연동해서 서버의 데이터를 JSON형식의 문자열로 응답하는 빈도가 
	 *			 요즘에 엄청 높음
	 * */
	@RequestMapping(value="responseBodyTest.do")
	@ResponseBody
	public String getStringData(){
		return "데이터";		
	}
}











