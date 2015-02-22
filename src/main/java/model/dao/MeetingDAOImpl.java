package model.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import util.DBUtil;

@Repository("meetingDAO")
public class MeetingDAOImpl implements MeetingDAO {

	@Override
	public int insertPay(int price, int totalfee) {
		SqlSession session = null;
		boolean flag = false;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.insert("payment.insertpay", price);
			result = session.insert("meeting.insertpay", totalfee);
			flag = result > 0 ? true : false;
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}

}
