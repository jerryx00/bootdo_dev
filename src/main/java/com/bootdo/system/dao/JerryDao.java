package com.bootdo.system.dao;

import com.bootdo.system.domain.JerryDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-23 15:54:20
 */
@Mapper
public interface JerryDao {

	JerryDO get(Integer jid);
	
	List<JerryDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(JerryDO jerry);
	
	int update(JerryDO jerry);
	
	int remove(Integer jid);
	
	int batchRemove(Integer[] jids);
}
