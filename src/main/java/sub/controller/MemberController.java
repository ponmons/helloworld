package sub.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.domain.MemberDTO;
import model.service.MemberService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberController {
	
	@Resource(name="memService")
    private MemberService memService;
	
	
	@RequestMapping("/select.do")
	public ModelAndView select(){
		List<MemberDTO> list =  memService.memberSelect();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);			
		mv.setViewName("jsonView");	//id=jsonView 객체를 찾아서 JsonView실행
		return mv;
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("mempw") String mempw,
							 HttpServletRequest req){
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
			MemberDTO vo = memService.isIdValid(email, mempw);
			if(vo != null){
				session.setAttribute("dto", vo);
				mv.addObject("dto",vo );
				mv.setViewName("meeting");
				return mv;
			}
			return mv;
	}
	
	@RequestMapping(value="insertMember.do", method=RequestMethod.POST)
	public ModelAndView insertMember(@RequestParam("memname") String memname,
									@RequestParam("mempw") String mempw,
									@RequestParam("email") String email,
									@RequestParam("phonenumber") int phonenumber,
									HttpServletRequest req){
		MemberDTO dto = new MemberDTO(memname, mempw, email, phonenumber);
		dto.setDeviceid("82cfe0b7-b9b8-11e4-86a9-06a6fa0000b9");
		HttpSession session= req.getSession();
		try {
			memService.insertMember(dto);
			session.setAttribute("dto", dto);
		} catch (Exception e) {
			session.setAttribute("error", "가입 실패");
			e.printStackTrace();
		}
			ModelAndView mv=new ModelAndView("error");
			mv.setViewName("meeting");
			return mv;
	}
}