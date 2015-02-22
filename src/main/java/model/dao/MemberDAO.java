package model.dao;

import java.util.List;

import model.domain.MemberDTO;

public interface MemberDAO {
	List<MemberDTO> memberSelect();
	MemberDTO isIdValid(MemberDTO vo);
}
