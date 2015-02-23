package sub.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.domain.MemberDTO;
import model.domain.PayDTO;
import model.service.MeetingService;
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
	@Resource(name="meetingService")
    private MeetingService meetingService;
	
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
		ModelAndView mv=new ModelAndView("error");
		HttpSession session=req.getSession();
			MemberDTO vo = memService.isIdValid(email, mempw);
			if(vo != null){
				List<PayDTO> list = meetingService.meetingList(vo.getMemno());
				session.setAttribute("dto", vo);
				mv.addObject("list",list);
				mv.addObject("dto",vo );
				mv.setViewName("main");
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
		ModelAndView mv=new ModelAndView();
		MemberDTO checkDto=memService.memJoinCheck(email);
			if(checkDto==null)
				{
					
					memService.insertMember(dto);
					session.setAttribute("dto", dto);
					mv.setViewName("meeting");
				}
			else
				{
					System.out.println("에러 발생");
					
					mv.setViewName("joinError");
				}
			return mv;
	}
	/*@RequestMapping(value="updateMember.do", method=RequestMethod.POST)
	public ModelAndView updateMember(@RequestParam("email") String email,
			@RequestParam("memname") String memname,
			@RequestParam("mempw") String mempw,
			@RequestParam("phonenumber") int phonenumber,
			@RequestParam("cardpw") String cardpw,
			@RequestParam("account") String account,
			@RequestParam("deviceId") String deviceId,
			HttpServletRequest req){
		ModelAndView mv=new ModelAndView();
		HttpSession session = req.getSession();
		System.out.println("확인");
		
		MemberDTO dto = new MemberDTO(memname, mempw, cardpw, email, account, deviceId, phonenumber);
	
		dto.setEmail(req.getParameter("email").trim());
		dto.setMemname(req.getParameter("memname").trim());
		dto.setMempw(req.getParameter("mempw").trim());
		dto.setPhonenumber(Integer.parseInt(req.getParameter("phonenumber")));
		dto.setCardpw(req.getParameter("cardpw").trim());
		dto.setAccount(req.getParameter("account").trim());
		dto.setDeviceid(req.getParameter("deviceid").trim());
		System.out.println(dto);
		try{
			memService.updateMember(dto);
		}catch(Exception e){
			e.printStackTrace();
			req.getSession().setAttribute("error","에러났습니다.");
		}
		mv.setViewName("Test");
		return mv;
	}*/
	
	
	@RequestMapping(value="isPwValid.do", method=RequestMethod.POST)
	public ModelAndView isPwValid(@RequestParam("mempw") String mempw,
				HttpServletRequest req)
			{
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
        
		MemberDTO dto = new MemberDTO();
		dto.setMempw(mempw);
		session.setAttribute("dto", memService.isPwValid(dto));
		
		mv.setViewName("main"); //id=test 객체를 찾아서 Test실행
		return mv;
	}
}