package model.service;

import java.util.List;

import model.domain.MemberDTO;

public interface MemberService {
	List<MemberDTO>memberSelect();
	int insertMember(MemberDTO dto);
	MemberDTO isIdValid(String email, String mempw);
	MemberDTO memJoinCheck(String email);
	//지윤
	int updateMember(MemberDTO dto);
	int deleteMember(MemberDTO dto);
	MemberDTO isPwValid(MemberDTO dto);
	List<MemberDTO> memPicSelect(int memno);//upload
	int updatePicture(MemberDTO dto);
	//지윤
}
