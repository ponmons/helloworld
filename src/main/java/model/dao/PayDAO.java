package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.domain.PayDTO;
import model.domain.PushDTO;
import model.domain.WebPushDTO;

public interface PayDAO {
	List<PayDTO> paySelect();
	int payUpdate(PayDTO vo);
	int payMeetUpdate(PayDTO vo);
	
	List<WebPushDTO> ResAfterSelect(int ckNo);
	
}
