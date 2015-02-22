package model.dao;


import model.domain.PayDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import util.DBUtil;

@Repository("meetingDAO")
public class MeetingDAOImpl implements MeetingDAO {

	@Override
	public int insertPay(PayDTO payDTO) {
		SqlSession session = null;
		boolean flag = false;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			System.out.println("price : "+ payDTO.getPrice() + "totalfee : " +payDTO.getTotalfee() + "meetno" + payDTO.getMeetno());
			//모임에서 각 멤버에게 회비를 할당해 주어야 한다.( 필요한 값 : meetno)
			result = session.update("payment.priceUpdate", payDTO);
			System.out.println("price result :" + result);
			result = session.update("payment.totalfeeUpdate", payDTO);
			System.out.println("totalfee result :" + result);
			flag = result > 0 ? true : false;
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}
}
