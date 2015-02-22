package model.service;


import javax.annotation.Resource;

import model.dao.MeetingDAO;
import model.domain.PayDTO;

import org.springframework.stereotype.Service;


@Service("meetingService")
public class MeetingServiceImpl implements MeetingService {

	@Resource(name="meetingDAO")
	private MeetingDAO meetingDAO;

	@Override
	public int insertPay(PayDTO payDTO) {
		return meetingDAO.insertPay(payDTO);
	}
	
}