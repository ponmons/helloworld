package model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import model.dao.MemberDAO;
import model.domain.MemberDTO;


@Service("memService")
public class MemberServiceImpl implements MemberService {

	@Resource(name="memDAO")
	private MemberDAO memDao;

	@Override
	public List<MemberDTO> memberSelect() {
		return memDao.memberSelect();
	}

	@Override
	public int insertMember(MemberDTO dto) {
		System.out.println(dto);
		return 0;
	}

	@Override
	public MemberDTO isIdValid(String email, String mempw) {
		return memDao.isIdValid(new MemberDTO(email, mempw));
	}
	

}