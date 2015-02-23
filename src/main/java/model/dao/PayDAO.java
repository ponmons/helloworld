package model.dao;

import java.util.List;

import model.domain.PayDTO;
import model.domain.WebPushDTO;

public interface PayDAO {
	List<PayDTO> paySelect();
	int payUpdate(PayDTO vo);
	int payMeetUpdate(PayDTO vo);
	List<PayDTO> friendSelect(int meetno);
	List<WebPushDTO> ResAfterSelect(int ckNo);
}
