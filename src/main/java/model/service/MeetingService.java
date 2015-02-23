package model.service;

import java.util.List;

import model.domain.MeetingDTO;
import model.domain.PayDTO;


public interface MeetingService {
	int insertPay(PayDTO payDTO);
	MeetingDTO selectMeetNo(String id);
	int insertMeeting(MeetingDTO meetingDTO);
	List<MeetingDTO> selectAll(String id);
}
