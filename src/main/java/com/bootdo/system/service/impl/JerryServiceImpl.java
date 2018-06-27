package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.JerryDao;
import com.bootdo.system.domain.JerryDO;
import com.bootdo.system.service.JerryService;



@Service
public class JerryServiceImpl implements JerryService {
	@Autowired
	private JerryDao jerryDao;
	
	@Override
	public JerryDO get(Integer jid){
		return jerryDao.get(jid);
	}
	
	@Override
	public List<JerryDO> list(Map<String, Object> map){
		return jerryDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return jerryDao.count(map);
	}
	
	@Override
	public int save(JerryDO jerry){
		return jerryDao.save(jerry);
	}
	
	@Override
	public int update(JerryDO jerry){
		return jerryDao.update(jerry);
	}
	
	@Override
	public int remove(Integer jid){
		return jerryDao.remove(jid);
	}
	
	@Override
	public int batchRemove(Integer[] jids){
		return jerryDao.batchRemove(jids);
	}
	
}
