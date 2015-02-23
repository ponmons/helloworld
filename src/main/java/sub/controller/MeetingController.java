package sub.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.domain.MeetingDTO;
import model.domain.PayDTO;
import model.service.MeetingService;
import model.service.PayService;

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
public class MeetingController {
	
	@Resource(name="meetingService")
    private MeetingService meetingService;
	@Resource(name="payService")
    private PayService payService;

	// 회비 추가 기능 
	@RequestMapping("/insertfee.do")
	@ResponseBody
	//@requestParam meetno가 들어가야 된다...
	public String insertPay(@RequestParam("price") int price, @RequestParam("totalfee") int totalfee){		
		String resultMsg = "no";
		int result = meetingService.insertPay(new PayDTO(price, totalfee, 2));
		if(result > 0)  {
			resultMsg = "ok";
			System.out.println("회비 추가 성공");
		}
		return resultMsg ;
	}
	// 모임 추가 폼으로 이동
	@RequestMapping(value="insertMeeting.do", method=RequestMethod.POST)
	public ModelAndView insertMeeting(){
		System.out.println("확인");
		ModelAndView mv=new ModelAndView();
		
			/*if(dto.getMemname().equals("admin")){
				session.setAttribute("admin", "ok");
			}
			*/mv.setViewName("addTest");
			return mv;
	}
	// 친구 목록 불러오기 
	@RequestMapping("/friendSelect.do")
	public ModelAndView friendSelect(@RequestParam("meetno") int meetno){
		List<PayDTO> list =  payService.friendSelect(meetno);
		System.out.println(list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);			
		mv.setViewName("jsonView");
		return mv;
	}
	// 모임 추가하기 
	@RequestMapping(value="addSpend.do", method=RequestMethod.POST)
	public ModelAndView addSpend(@RequestParam("spendCategory") String spendCategory,
								@RequestParam("spendLocation") String spendLocation,
								@RequestParam("spendDate") String spendDate,
								@RequestParam("spendMemo") String spendMemo,
								HttpServletRequest req){
		int result=0;
		HttpSession session=req.getSession();
		System.out.println("###### 모임추가 #######");
		System.out.println( "id : "+session.getAttribute("id"));
		MeetingDTO mb = meetingService.selectMeetNo((String)(session.getAttribute("id")));
			
		/*PaymentDTO pb = new PaymentDTO(1,2);
		int v = paymentService.insertPayment(pb);*/
		
		int count2 = 0; //임시적으로 사용자의 마지막 meetno을 저장하는  변수
           if(mb==null){ //해당 사용자가 처음 값을 넣게 될때 meetno이 1이므로 1일때랑 1아닐때랑 구분해서 insert를 해준다. 1이 아닐때는 해당 사용자가 만든 마지막 모임 meetno을 가지고 와서 else에서 작업을 한다.
        	   result = meetingService.insertMeeting(new MeetingDTO(Integer.parseInt(spendCategory), (String)(session.getAttribute("id")), spendLocation, spendDate, spendMemo, ++count2, ((Integer)session.getAttribute("memno")).intValue(),0)); 
			   }else{	   			   
   			   count2 = mb.getMeetNo();
   			   count2++;//사용자가 가지고 있는 meetNO마지막값에서 1증가시켜서 다음 번호로 추가하기 위한 변수
   			   		//이부분 customer1부분을 지윤이 session객체 받아서 넣기
				   result = meetingService.insertMeeting(new MeetingDTO(Integer.parseInt(spendCategory), (String)(session.getAttribute("id")), spendLocation, spendDate, spendMemo, count2, ((Integer)session.getAttribute("memno")).intValue(),0));
			   }
           
            if(result==1){
				System.out.println("데이터 삽입 성공!");
			}
		//다시 list값을 뿌려 주기 위해 불러오는 부분..
            List<MeetingDTO> list = meetingService.selectAll((String)(session.getAttribute("id")));
		//request.setAttribute("spendView", MeetingDAOImpl.selectAll("customer1")); //지윤이가 session값 넘겨주면 그 id로 사용하기!
            ModelAndView mv=new ModelAndView();
			mv.addObject("spendView",list);
            mv.setViewName("Test");
			
		return mv;
	}
}