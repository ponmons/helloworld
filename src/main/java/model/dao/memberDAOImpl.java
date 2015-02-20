package model.dao;

import java.util.List;

import model.domain.memberDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import util.DBUtil;

@Repository("memDAO")
public class memberDAOImpl implements memberDAO {



	@Override
	public List<memberDTO> memberSelect() {
		SqlSession session = null;
		List<memberDTO> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("member.memSelect");
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}


}
