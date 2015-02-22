package sub.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.domain.MemberDTO;
import model.domain.PayDTO;
import model.domain.PushDTO;
import model.domain.WebPushDTO;
import model.service.MeetingService;
import model.service.MemberService;
import model.service.PayService;
import model.service.PushService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PushAndPayController {
	@Resource(name="memService")
	private  MemberService memService;
	@Resource(name="meetingService")
	private MeetingService meetingService;
	@Resource(name="pushService")	
	private PushService pushService;
	@Resource(name="payService")
	private PayService payService;
	
	@RequestMapping("/pay.do")
	@ResponseBody
	public String paying(PayDTO vo){
		System.out.println(vo);
		List<PayDTO> list=payService.paySelect();
		String resultMsg="no";
		int resultPrice=0;
		int resultTotal=0;
		
		for(int i=0;i<list.size();i++)
		{
			if(vo.getAccount().equals(list.get(i).getAccount()) && vo.getCarPw().equals(list.get(i).getCarPw()))
			{
				list.get(i).setPrice(list.get(i).getPrice()-vo.getPrice());
				resultPrice=payService.payUpdate(list.get(i));
				list.get(i).setTotalfee(list.get(i).getTotalfee()-vo.getPrice());
				resultTotal=payService.payMeetUpdate(list.get(i));
			}
		}
			if((resultPrice > 0) && (resultTotal > 0))  
			{
				resultMsg = "ok";
			}
			
				
		return resultMsg;
	}
	@RequestMapping("/selectMessage.do" )
	public ModelAndView selectMessage(HttpServletRequest req){
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		ArrayList<WebPushDTO> wpsBefore = pushService.ResBeforeSelect((int)((MemberDTO)session.getAttribute("dto")).getMemno());// 2=로그인한 유저의 memno
			mv.addObject("list", wpsBefore);			
			mv.setViewName("jsonView");
			return mv;
	}
	
	@RequestMapping("/selectDevice.do")
	@ResponseBody
	public String select(String vo,HttpServletRequest req){
		HttpSession session=req.getSession();
		String result="";
		
		List<MemberDTO> memberInfo =  memService.memberSelect();
		PushDTO pushDto =  new PushDTO("보내는 메시지",(int)session.getAttribute("memno"),1);
		//pushDto.setContent("보내는 메시지");
//		pushDto.setMemno(session.getAttribute("memno"));// 1=로그인한 유저의 memno
	//	pushDto.setMeetno(1);// 1=로그인한 유저의 meetno
		System.out.println(vo);
		for(int i=0;i<memberInfo.size();i++)
		{
			if(vo.equals(memberInfo.get(i).getMemname()))
				{
					System.out.println(vo);
					result=memberInfo.get(i).getDeviceid();
					pushDto.setCkNo(memberInfo.get(i).getMemno()); //푸시를 받는 유저의 memno
					session.setAttribute("receivedMemno", memberInfo.get(i).getMemno());
					System.out.println(pushDto);
					pushService.pushInsert(pushDto);
					
				}
		}
		return result;
	}
	@RequestMapping("/pushWebInsert.do")
	@ResponseBody
	public String pushInsert(PushDTO vo,HttpServletRequest req){
		HttpSession session=req.getSession();
		String resultMsg = "no";
		int result=0;
		PushDTO dto = new PushDTO();
		List<PushDTO> list2=pushService.pushSelect();
		System.out.println((int)session.getAttribute("receivedMemno"));
		for(int i=0;i<list2.size();i++)
		{
			if(list2.get(i).getCkNo()==(int)session.getAttribute("receivedMemno")) //2->로그인한 유저의 memno
			{
				dto.setCkNo((int)session.getAttribute("receivedMemno"));//상대방의 memno
				dto.setNotificationno(list2.size());
				dto.setContent(vo.getContent()); //보내는 메시지
				
				if(vo.getAlramtime().equals("")) //db에 보내는 메시지 저장
				{
					result =pushService.pushContentUpdate(dto);
					
				}
				else
				{
					dto.setAlramtime(vo.getAlramtime());
					result =pushService.pushResContentUpdate(dto);
					System.out.println(dto);
				}
			}
		}
		if(result > 0 )  {
			resultMsg = "ok";
		}
		return resultMsg;
	}
}