package model.dao;

import java.util.ArrayList;
import java.util.List;


import model.domain.PushDTO;
import model.domain.WebPushDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import util.DBUtil;

@Repository("pushDao")
public class PushDAOImpl implements PushDAO {
	
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
	public ArrayList<WebPushDTO> ResBeforeSelect(int ckno) {
		ArrayList<WebPushDTO> list =null;
		SqlSession session = null;
		try{
			session = DBUtil.getSqlSession();
			list = (ArrayList)session.selectList("webselect.selectMessage", ckno);
		}finally {
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
	@Override
	public int pushResInsert(PushDTO vo) {
		SqlSession session = null;
		boolean flag = false;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.update("notification.pushResInsert", vo);
			flag = result > 0 ? true : false;
	
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}
}
