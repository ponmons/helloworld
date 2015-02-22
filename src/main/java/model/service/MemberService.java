package model.service;

import java.util.List;

import model.domain.MemberDTO;

public interface MemberService {
	List<MemberDTO>memberSelect();
	int insertMember(MemberDTO dto);
	MemberDTO isIdValid(String email, String mempw);
}
