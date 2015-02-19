package model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import model.dao.memberDAO;
import model.domain.memberDTO;


@Service("memService")
public class ServiceImpl implements SService {

	@Resource(name="memDAO")
	private memberDAO memDao;

	@Override
	public List<memberDTO> memberSelect() {
		return memDao.memberSelect();
	}
	

}