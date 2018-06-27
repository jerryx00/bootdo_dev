package com.bootdo.system.service;

import com.bootdo.system.domain.TomDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-23 20:06:42
 */
public interface TomService {
	
	TomDO get(Integer tid);
	
	List<TomDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TomDO tom);
	
	int update(TomDO tom);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
