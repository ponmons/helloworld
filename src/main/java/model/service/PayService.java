package model.service;

import java.util.ArrayList;
import java.util.List;

import model.domain.PayDTO;
import model.domain.PushDTO;
import model.domain.WebPushDTO;

public interface PayService {
	List<PayDTO> paySelect();
	List<WebPushDTO> ResAfterSelect(int ckNo);
	int payUpdate(PayDTO vo);
	int payMeetUpdate(PayDTO vo);
}
