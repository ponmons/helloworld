package model.service;

import java.util.ArrayList;
import java.util.List;

import model.domain.PushDTO;
import model.domain.WebPushDTO;

public interface PushService {
	int pushInsert(PushDTO vo);
	List<PushDTO> pushSelect();
	List<WebPushDTO> pushWebSelect(int ckNo);
	ArrayList<WebPushDTO> ResBeforeSelect(int ckno);
	int pushResInsert(PushDTO vo);
}
