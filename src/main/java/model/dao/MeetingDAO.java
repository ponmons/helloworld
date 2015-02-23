package model.dao;

import java.util.List;

import model.domain.MeetingDTO;
import model.domain.PayDTO;

public interface MeetingDAO {
	int insertPay(PayDTO payDTO);

	MeetingDTO selectMeetNo(String id);

	int insertMeeting(MeetingDTO meetingDTO);

	List<MeetingDTO> selectAll(String id);
}
