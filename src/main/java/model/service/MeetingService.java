package model.service;

import java.util.List;

import model.domain.MeetingDTO;
import model.domain.PayDTO;


public interface MeetingService {
	int insertPay(PayDTO payDTO);
	int insertMeeting(MeetingDTO meetingDTO);
	List<PayDTO> meetingList(int memno);
}
