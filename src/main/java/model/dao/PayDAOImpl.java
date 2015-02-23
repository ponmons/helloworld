package model.dao;

import java.util.List;

import model.domain.PayDTO;
import model.domain.WebPushDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import util.DBUtil;


@Repository("payDao")
public class PayDAOImpl implements PayDAO {

	@Override
	public List<PayDTO> paySelect() {
		SqlSession session = null;
		List<PayDTO> list = null;
		
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("payment.paySelect");
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
	@Override
	public List<WebPushDTO> ResAfterSelect(int ckNo) {
		SqlSession session = null;
		List<WebPushDTO> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("webselect.ResAfterSelect",ckNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
	@Override
	public int payUpdate(PayDTO vo) {
		SqlSession session = null;
		boolean flag = false;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.update("payment.payUpdate", vo);
			flag = result > 0 ? true : false;
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}
	
	@Override
	public int payMeetUpdate(PayDTO vo) {
		SqlSession session = null;
		boolean flag = false;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.update("payment.payMeetUpdate", vo);
			flag = result > 0 ? true : false;
	
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}

	@Override
	public List<PayDTO> friendSelect(int meetno) {
		SqlSession session = null;
		List<PayDTO> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("payment.friendSelect", meetno);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
}