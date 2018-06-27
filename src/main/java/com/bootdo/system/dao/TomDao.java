package com.bootdo.system.dao;

import com.bootdo.system.domain.TomDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-23 20:06:42
 */
@Mapper
public interface TomDao {

	TomDO get(Integer tid);
	
	List<TomDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TomDO tom);
	
	int update(TomDO tom);
	
	int remove(Integer tid);
	
	int batchRemove(Integer[] tids);
}
