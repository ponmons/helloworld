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
		return memDao.insertMember(dto);
	}

	@Override
	public MemberDTO isIdValid(String email, String mempw) {
		return memDao.isIdValid(new MemberDTO(email, mempw));
	}
	@Override
	public MemberDTO memJoinCheck(String email) {
		return memDao.memJoinCheck(email);
	}
	//지윤
	@Override
	public MemberDTO isPwValid(MemberDTO dto){
		return memDao.isPwValid(dto);
	}
	@Override
	public int updateMember(MemberDTO dto){
		return memDao.updateMember(dto);
	}
	@Override
	public int deleteMember(MemberDTO dto){
		return memDao.deleteMember(dto);
	}
	@Override//upload
	public List<MemberDTO> memPicSelect(int memno){
		return memDao.memPicSelect(memno);
	}
	@Override
	public int updatePicture(MemberDTO dto){
		return memDao.updatePicture(dto);
	}
	//지윤
}