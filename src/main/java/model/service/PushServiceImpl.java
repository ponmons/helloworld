package model.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import model.dao.PushDAO;
import model.domain.PushDTO;
import model.domain.WebPushDTO;
@Service("pushService")
public class PushServiceImpl implements PushService{
	@Resource(name="pushDao")
	private PushDAO pushDao;
	@Override
	public List<PushDTO> pushSelect() {
		return pushDao.pushSelect();
	}
	@Override
	public ArrayList<WebPushDTO> ResBeforeSelect(int ckno) {
		return pushDao.ResBeforeSelect(ckno);
	}
	@Override
	public List<WebPushDTO> pushWebSelect(int ckNo) {
		return pushDao.pushWebSelect(ckNo);
	}
	@Override
	public int pushInsert(PushDTO vo) {
		return pushDao.pushInsert(vo);
	}
	@Override
	public int pushResInsert(PushDTO vo) {
		return pushDao.pushResInsert(vo);
	}
}
