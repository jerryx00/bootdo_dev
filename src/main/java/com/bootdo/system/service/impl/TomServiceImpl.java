package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.TomDao;
import com.bootdo.system.domain.TomDO;
import com.bootdo.system.service.TomService;



@Service
public class TomServiceImpl implements TomService {
	@Autowired
	private TomDao tomDao;
	
	@Override
	public TomDO get(Integer tid){
		return tomDao.get(tid);
	}
	
	@Override
	public List<TomDO> list(Map<String, Object> map){
		return tomDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tomDao.count(map);
	}
	
	@Override
	public int save(TomDO tom){
		return tomDao.save(tom);
	}
	
	@Override
	public int update(TomDO tom){
		return tomDao.update(tom);
	}
	
	@Override
	public int remove(Integer tid){
		return tomDao.remove(tid);
	}
	
	@Override
	public int batchRemove(Integer[] tids){
		return tomDao.batchRemove(tids);
	}
	
}
