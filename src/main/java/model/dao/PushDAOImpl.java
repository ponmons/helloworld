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

import model.domain.PushDTO;
import model.domain.WebPushDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import util.DBUtil;

@Repository("pushDao")
public class PushDAOImpl implements PushDAO {
	
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
	public List<PushDTO> pushSelect() {
		SqlSession session = null;
		List<PushDTO> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("notification.pushSelect");
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	@Override
	public ArrayList<WebPushDTO> ResBeforeSelect(int ckNo) {
		Connection con = null;
		SqlSession session = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<WebPushDTO> list =null;
		try{
			list = new ArrayList<>();
			
			con = source.getConnection();
			
			pstmt = con.prepareStatement("select * from WEB_PUSH_INFO where ALRAMTIME <= SYSDATE and ckNo=?");
			pstmt.setInt(1, ckNo);
			
			rset = pstmt.executeQuery();
			System.out.println("jdbc 디버깅");
			while(rset.next()){
				list.add(new WebPushDTO(rset.getString(1),rset.getString(2), rset.getInt(3), rset.getInt(4), 
						rset.getInt(5), rset.getInt(6), rset.getString(7)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	@Override
	public List<WebPushDTO> pushWebSelect(int ckNo) {
		SqlSession session = null;
		List<WebPushDTO> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("webselect.WebPushSelect",ckNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	@Override
	public int pushInsert(PushDTO vo) {
		SqlSession session = null;
		boolean flag = false;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.insert("notification.pushInsert", vo);
			flag = result > 0 ? true : false;
	
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}
	public int pushResContentUpdate(PushDTO vo) {
		SqlSession session = null;
		boolean flag = false;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.update("notification.pushResContentUpdate", vo);
			flag = result > 0 ? true : false;
	
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}
	public int pushContentUpdate(PushDTO vo) {
		SqlSession session = null;
		boolean flag = false;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.update("notification.pushContentUpdate", vo);
			flag = result > 0 ? true : false;
	
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}
}
