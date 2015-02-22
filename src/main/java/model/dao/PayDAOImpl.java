package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.domain.PayDTO;
import model.domain.PushDTO;
import model.domain.WebPushDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import util.DBUtil;


@Repository("payDao")
public class PayDAOImpl implements PayDAO {
	private static DataSource source = null;
	
    static{	
		try{
		    Context ctx = new InitialContext();			
		    source = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");	
		    System.out.println(source);
		}catch(Exception e) {
		    e.printStackTrace();
		}			
    }

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
	
	
	
}