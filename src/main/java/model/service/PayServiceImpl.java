package model.service;

import java.util.List;

import javax.annotation.Resource;

import model.dao.PayDAO;
import model.domain.PayDTO;
import model.domain.WebPushDTO;

import org.springframework.stereotype.Service;


@Service("payService")
public class PayServiceImpl implements PayService {

	@Resource(name="payDao")
	private PayDAO payDao;
	

	@Override
	public List<PayDTO> paySelect() {
		return payDao.paySelect();
	}
	
	@Override
	public List<WebPushDTO> ResAfterSelect(int ckNo) {
		return payDao.ResAfterSelect(ckNo);
	}
	
	@Override
	public int payUpdate(PayDTO vo) {
		return payDao.payUpdate(vo);
	}

	@Override
	public int payMeetUpdate(PayDTO vo) {
		return payDao.payMeetUpdate(vo);
	}

	@Override
	public List<PayDTO> friendSelect(int meetno) {
		return payDao.friendSelect(meetno);
	}
	
}