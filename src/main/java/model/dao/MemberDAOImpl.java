package model.dao;

import java.util.List;

import model.domain.MemberDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import util.DBUtil;

@Repository("memDAO")
public class MemberDAOImpl implements MemberDAO {

	@Override
	public List<MemberDTO> memberSelect() {
		SqlSession session = null;
		List<MemberDTO> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("member.memSelect");
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}

	@Override
	public MemberDTO isIdValid(MemberDTO vo) {
		SqlSession session = null;
		MemberDTO sVo = null;
		try {
			session = DBUtil.getSqlSession();
			sVo = session.selectOne("member.memEmailCheck", vo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return sVo;
	}


}
